package br.com.hranalytics.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapeamentoPaginasController {
	
	@GetMapping("/")
	public String home() {
		if(estaLogado())
			return "/index";
		
		return "/home";
	}

	@GetMapping("/home")
	public String paginaHome() {
		if(estaLogado()) 
			return "/index";
		
		return "/home";
	}

	@GetMapping("/index")
	public String index() {
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		if(estaLogado())
			return "/index";
		
		return "/login";
	}

	@GetMapping("/cadastro")
	public String cadastrar() {
		if(estaLogado())
			return "/index";
		
		return "/cadastro-primeiro-passo";
	}

	@GetMapping("/403")
	public String erro403() {
		return "/erros/403";
	}

	@GetMapping("/user")
	public String user() {
		return "/user";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "/dash";
	}

	@GetMapping("/comparar")
	public String compararPerfil() {
		return "/comparar-perfil";
	}
	
	public boolean estaLogado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return true;
		}
		return false;
	} 

}