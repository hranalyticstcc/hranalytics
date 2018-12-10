package br.com.hranalytics.service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hranalytics.model.CadastroTemporario;
import br.com.hranalytics.model.Candidato;
import br.com.hranalytics.model.Pagamento;
import br.com.hranalytics.model.StatusAnaliseEnum;
import br.com.hranalytics.model.Usuario;
import br.com.hranalytics.repository.CadastroTemporarioRepository;
import br.com.hranalytics.repository.CandidatoRepository;
import br.com.hranalytics.repository.PagamentoRepository;
import br.com.hranalytics.repository.UsuarioRepository;
import br.com.hranalytics.utils.EmailUtil;

@Service
public class UsuarioService {

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private CadastroTemporarioRepository cadastroTemporarioRepo;

	@Autowired
	private CandidatoRepository candidatoRepo;
	
	@Autowired
	private PagamentoRepository pagamentoRepo;

	public RedirectView atualizarStatusAnaliseCandidato(Long id, int idStatus) {
		Candidato candidato = candidatoRepo.findById(id).get();
		StatusAnaliseEnum status = StatusAnaliseEnum.values()[idStatus];
		candidato.setStatusAnalise(status);
		candidatoRepo.save(candidato);

		return new RedirectView("/user/dashboard");
	}

	public ModelAndView getCandidatoPorId(Long id) {

		Candidato candidato = candidatoRepo.findById(id).get();

		ModelAndView mv = new ModelAndView("dash-analise");
		mv.addObject("candidato", candidato);

		return mv;
	}

	public ModelAndView getUsuarioPorId() {
		String usuarioLogado = getUsuarioLogado();
		Usuario usuario = usuarioRepo.findByNomeUsuario(usuarioLogado);
		
		Calendar start = Calendar.getInstance();
	    start.set(Calendar.DAY_OF_MONTH, 1);
	    
	    Calendar end = Calendar.getInstance();
	    end.set(Calendar.DAY_OF_MONTH, end.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		Pagamento pagamento = 
				pagamentoRepo.findByUsuarioAndDataPagamentoGreaterThanEqualAndDataPagamentoLessThanEqual(
						usuario,start,end);

		ModelAndView mv = new ModelAndView("gerenciar-conta-usuario");
		mv.addObject("usuario", usuario);
		mv.addObject("pagamento", pagamento);
		
		return mv;
	}

	public ModelAndView enviaFormularioCandidato(String nomeCandidato, String emailCandidato) {

		ModelAndView mv = new ModelAndView("enviar-formulario");
		try {

			CadastroTemporario cadastroTemporario = criaCadastroTemporario(nomeCandidato, emailCandidato);

			Usuario usuario = usuarioRepo.findByNomeUsuario(getUsuarioLogado());

			String conteudoHtml = emailUtil.controiEmailFormularioCandidato(nomeCandidato, cadastroTemporario.getId(),
					usuario.getId());
			emailUtil.enviarHtml(emailCandidato, "HR Analytics - Formulario de Cadastro", conteudoHtml);

			mv.addObject("msg", "E-mail enviado com sucesso");
			mv.addObject("flag", true);

		} catch (Exception e) {
			mv.addObject("msg", "Ocorreu um erro ao enviar o e-mail. Tente novamente mais tarde.");
			mv.addObject("flag", false);
		}

		return mv;
	}

	public ModelAndView carregaCandidatos() {

		Usuario usuario = usuarioRepo.findByNomeUsuario(getUsuarioLogado());
		List<Candidato> candidatos = candidatoRepo.findByUsuario(usuario);

		ModelAndView mv = new ModelAndView("dash");
		mv.addObject("candidatos", candidatos);
		return mv;
	}

	public String getUsuarioLogado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = null;
		if (principal instanceof UserDetails) {
			usuario = ((UserDetails) principal).getUsername();
		} else {
			usuario = principal.toString();
		}

		return usuario;
	}

	public CadastroTemporario criaCadastroTemporario(String nomeCandidato, String emailCandidato) {
		Calendar dataHoraInicial = Calendar.getInstance();
		Calendar dataHoraFinal = Calendar.getInstance();
		dataHoraFinal.add(Calendar.DAY_OF_YEAR, 2);

		CadastroTemporario cadastro = new CadastroTemporario();
		cadastro.setNome(nomeCandidato);
		cadastro.setEmail(emailCandidato);
		cadastro.setDataHoraInicial(dataHoraInicial);
		cadastro.setDataHoraFinal(dataHoraFinal);

		cadastroTemporarioRepo.save(cadastro);

		return cadastro;
	}
	
	public void atualizaCadastro(Usuario usuario) {
		String usuarioLogado = getUsuarioLogado();
		Usuario usr = usuarioRepo.findByNomeUsuario(usuarioLogado);
		
		usr.setNomePessoaFisica(usuario.getNomePessoaFisica());
		usr.setEmail(usuario.getEmail());
		usr.setTelefone(usuario.getTelefone());
		usr.setCelular(usuario.getCelular());
		usr.setLogradouro(usuario.getLogradouro());
		usr.setNumero(usuario.getNumero());
		usr.setCep(usuario.getCep());
		
		usuarioRepo.save(usr);
	}
	
	public void excluirCadastro() {
		String usuarioLogado = getUsuarioLogado();
		Usuario usr = usuarioRepo.findByNomeUsuario(usuarioLogado);
		
		usuarioRepo.delete(usr);
	}
	
	public void redefinirSenha(String senha) {
		String usuarioLogado = getUsuarioLogado();
		Usuario usr = usuarioRepo.findByNomeUsuario(usuarioLogado);
		usr.setSenha(new BCryptPasswordEncoder().encode(senha));
		
		usuarioRepo.save(usr);
	}
	
	public boolean gerarNovaSenha(String email) {
		
		Usuario usuario = usuarioRepo.findByEmail(email);
		
		if(usuario == null) {
			return false;
		}
		
		String novaSenha = usuario.getNomeUsuario() + new Random().nextInt(10000) + 2000;
		usuario.setSenha(new BCryptPasswordEncoder().encode(novaSenha));
		usuarioRepo.save(usuario);
		
		emailUtil.enviarMensagem(usuario.getEmail(), "HR Analytics - Nova Senha", "Sua nova senha: " + novaSenha);
		return true;
	}

}
