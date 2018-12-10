package br.com.hranalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hranalytics.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
		
	@GetMapping("/cadastro/pendentes")
	public ModelAndView visualizarCadastrosPendentes() {
		return service.consultarTodosUsuarios();
	}
	
	@GetMapping("/cadastro/ativar/{id}")
	public RedirectView ativarCadastroPendente(@PathVariable String id) {
		return service.ativarCadastroPendente(id);
	}
	
}
