package br.com.hranalytics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerAplication {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
	@GetMapping("/home")
	public String toHome() {
		return "/home";
	}
	
	@GetMapping("/index")
	public String paginaInicial() {
		return "/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar() {
		return "/cadastro-usuario";
	}
	
	@GetMapping("/403")
    public String error403() {
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

}
