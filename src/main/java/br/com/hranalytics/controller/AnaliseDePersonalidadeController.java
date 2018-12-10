package br.com.hranalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.hranalytics.service.AnaliseDePersonalidadeService;

@Controller("/controller/personalidade")
public class AnaliseDePersonalidadeController {
	
	@Autowired
	private AnaliseDePersonalidadeService service;
	
	@PostMapping("/enviaform")
	public String enviaFormularioParaCandidato(@RequestParam("email") String emailCandidato){
		return service.enviarFormularioCadastroCandidato(emailCandidato);
	}

}
