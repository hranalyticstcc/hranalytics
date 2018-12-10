package br.com.hranalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hranalytics.model.Candidato;
import br.com.hranalytics.service.AnaliseDePersonalidadeService;
import br.com.hranalytics.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private AnaliseDePersonalidadeService analiseService;
	
	@GetMapping("/formcandidato")
	public ModelAndView enviarFormularioCadidato(@RequestParam("nomeCandidato") String nome,
											@RequestParam("emailCandidato") String email) {
		return service.enviaFormularioCandidato(nome, email);
	}
	
	@PostMapping("/atualizarstatus")
	public RedirectView atualizarStatus(@RequestParam("status") String status,
										@RequestParam("id") String id) {
		return service.atualizarStatusAnaliseCandidato
				(Long.parseLong(id), Integer.parseInt(status));
	}
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard() {
		return service.carregaCandidatos();
	}
	
	@GetMapping("/analisar/{id}")
	public ModelAndView analisarPerfil(@PathVariable String id) {
		return service.getCandidatoPorId(Long.parseLong(id));
	}
	
	@GetMapping("/pagesendformcandidato")
	public String redirectSendFormCandidato() {
		return "enviar-formulario";
	}
	
	@PostMapping("/comparar")
	public ModelAndView compararPefil(@RequestParam("id1") String perfil1,
										@RequestParam("id2") String perfil2){
		
		Candidato c1 = analiseService.consultaCandidato(Long.parseLong(perfil1));
		Candidato c2 = analiseService.consultaCandidato(Long.parseLong(perfil2));
		
		ModelAndView mv = new ModelAndView("comparar-perfil");
		mv.addObject("perfil1",c1);
		mv.addObject("perfil2",c2);
		
		return mv;
	}

}
