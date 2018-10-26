package br.com.hranalytics.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hranalytics.model.Personalidade;
import br.com.hranalytics.service.AnaliseDePersonalidadeService;

@RestController
@RequestMapping("/personalidade")
public class PersonalidadeWS {

	@Autowired
	private AnaliseDePersonalidadeService analise;

	@ResponseBody
	@GetMapping("/analisa/{perfil}")
	public Personalidade analisaPersonalidade(@PathVariable String perfil) {
		Personalidade personalidade = new Personalidade();
		personalidade = analise.analisarPersonalidade(perfil);

		return personalidade;
	}

}
