package br.com.hranalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import br.com.hranalytics.model.UsuarioDTO;
import br.com.hranalytics.utils.ReceitaException;
import br.com.hranalytics.wsclient.ReceitaWS;

@Controller
@RequestMapping("/cadastro")
public class ControllerCadastro {
	
	@RequestMapping("/cnpj")
	public ModelAndView validarCnpj(@RequestParam("cnpj") String cnpj) {
		
		UsuarioDTO usuario = null;
		ModelAndView mv = null;
		
		try {
			usuario = ReceitaWS.validaCNPJ(cnpj);
			mv = new ModelAndView("cadastro-usuario");
			mv.addObject("usuario", usuario);
			
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
