package br.com.hranalytics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import br.com.hranalytics.model.RoleEnum;
import br.com.hranalytics.model.Usuario;
import br.com.hranalytics.model.UsuarioDTO;
import br.com.hranalytics.repository.UsuarioRepository;
import br.com.hranalytics.utils.ReceitaException;
import br.com.hranalytics.wsclient.ReceitaWS;

@Service
public class CadastroService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private ReceitaWS receita;

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
			mv.addObject("mensagem", e.getMessage() + 
					". AGUARDE ALGUNS INSTANTE E DEPOIS TENTE NOVAMENTE");
		}catch (Exception e) {
			
			mv = new ModelAndView("erros/erro-cnpj");
			mv.addObject("mensagem", e.getMessage());
		}
		
		return mv;
	}

}
