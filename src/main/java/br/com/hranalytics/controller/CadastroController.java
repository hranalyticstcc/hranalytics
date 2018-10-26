package br.com.hranalytics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.hranalytics.model.Usuario;
import br.com.hranalytics.service.CadastroService;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private CadastroService service;
	
	@PostMapping
	public ModelAndView cadastrarEmpresaPendente(@Valid Usuario usuario, BindingResult bindingResult) {
		return service.cadastrarEmpresaPendente(usuario, bindingResult);		
	}
	
	@RequestMapping("/cnpj")
	public ModelAndView validarCnpj(@RequestParam String cnpj) {
		return service.validarCnpj(cnpj);
	}
}
