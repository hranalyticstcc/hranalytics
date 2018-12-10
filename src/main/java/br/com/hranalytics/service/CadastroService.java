package br.com.hranalytics.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hranalytics.model.CadastroTemporario;
import br.com.hranalytics.model.Candidato;
import br.com.hranalytics.model.Personalidade;
import br.com.hranalytics.model.RoleEnum;
import br.com.hranalytics.model.StatusAnaliseEnum;
import br.com.hranalytics.model.Usuario;
import br.com.hranalytics.model.UsuarioDTO;
import br.com.hranalytics.repository.CadastroTemporarioRepository;
import br.com.hranalytics.repository.CandidatoRepository;
import br.com.hranalytics.repository.UsuarioRepository;
import br.com.hranalytics.utils.ReceitaException;
import br.com.hranalytics.wsclient.ReceitaWS;

@Service
public class CadastroService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private CadastroTemporarioRepository cadastroTempRepo;

	@Autowired
	private CandidatoRepository candidatoRepo;

	@Autowired
	private ReceitaWS receita;
	
	@Autowired
	private AnaliseDePersonalidadeService analiseService;

	public RedirectView cadastrarCandidato(Long idEmpresa, Long idCad, String nome, String dataNascimento, String email, String perfil,
			List<String> listaRespostasQuestionario, boolean aceitaTermos) {
		RedirectView rv = new RedirectView();
		
		if (aceitaTermos) {
			try {
				Candidato candidato = new Candidato();

				candidato.setNome(nome);
				candidato.setEmail(email);
				candidato.setPerfilTwitter(perfil);
				candidato.setAceitaTermosECondicoes(aceitaTermos);
				candidato.setStatusAnalise(StatusAnaliseEnum.EM_ANALISE);
				
				Personalidade personalidade = analiseService.analisarPersonalidade(candidato.getPerfilTwitter(), listaRespostasQuestionario);
				
				candidato.setPersonalidade(personalidade);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar dataNascimentoCal = Calendar.getInstance();
				dataNascimentoCal.setTime(sdf.parse(dataNascimento));

				candidato.setDataNascimento(dataNascimentoCal);
				
				Usuario usuario = usuarioRepo.findById(idEmpresa).get();
				candidato.setUsuario(usuario);
				candidatoRepo.save(candidato);
				
				cadastroTempRepo.deleteById(idCad);
				
				rv.setUrl("/");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			rv.setUrl("/termos");
		}
		return rv;
	}

	public ModelAndView redirecionarParaFormularioCandidato(Long idCadTemp, Long idEmpresa) {
		ModelAndView mv = new ModelAndView();
		
		CadastroTemporario cadastroTemporario = null;
		
		try {
			cadastroTemporario = cadastroTempRepo.findById(idCadTemp).get();
		}catch (Exception e) {
			mv.setViewName("formulario_nao_disponivel");
		}

		if (cadastroTemporario != null) {
			if (cadastroTemporario.getDataHoraFinal().compareTo(Calendar.getInstance()) == 1) {
				Candidato candidato = new Candidato();
				candidato.setNome(cadastroTemporario.getNome());
				candidato.setEmail(cadastroTemporario.getEmail());

				mv.setViewName("formulario_cadastro_candidato");
				mv.addObject("candidato", candidato);
				mv.addObject("idcad",idCadTemp);
			} else {
				mv.setViewName("formulario_cadastro_candidato_esgotado");
			}
		}

		return mv;
	}

	public ModelAndView cadastrarEmpresaPendente(Usuario usuario, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView();

		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			mv = new ModelAndView("cadastro-usuario");
			mv.addObject("usuariodto", usuario);

			List<FieldError> fieldErrors = new ArrayList<>();
			for (ObjectError erro : allErrors) {
				FieldError fe = (FieldError) erro;
				fieldErrors.add(fe);
			}

			mv.addObject("erros", fieldErrors);
			return mv;
		}

		usuario.setRole(RoleEnum.PENDING);
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

		usuarioRepo.save(usuario);

		mv = new ModelAndView("cadastro-pendente");
		return mv;
	}

	public ModelAndView validarCnpj(String cnpj) {
		UsuarioDTO usuario = null;
		ModelAndView mv = null;

		try {
			usuario = receita.validaCNPJ(cnpj);

			usuario.setEmail(null);
			usuario.setTelefone(null);

			mv = new ModelAndView("cadastro-usuario");
			mv.addObject("usuariodto", usuario);

		} catch (ReceitaException e) {

			mv = new ModelAndView("erros/erro-cnpj");
			mv.addObject("mensagem", e.getMessage());
		} catch (HttpClientErrorException e) {

			mv = new ModelAndView("erros/erro-cnpj");
			mv.addObject("mensagem", e.getMessage() + ". AGUARDE ALGUNS INSTANTE E DEPOIS TENTE NOVAMENTE");
		} catch (Exception e) {

			mv = new ModelAndView("erros/erro-cnpj");
			mv.addObject("mensagem", e.getMessage());
		}

		return mv;
	}

}
