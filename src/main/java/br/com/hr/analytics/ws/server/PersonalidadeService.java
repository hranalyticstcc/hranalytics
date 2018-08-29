package br.com.hr.analytics.ws.server;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hr.analytics.ws.client.AnalisaPerfil;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/buscar")
public class PersonalidadeService {
	
	@RequestMapping(value="/teste/{perfil}", method=RequestMethod.GET)
	@ResponseBody
	public String teste(@PathVariable("perfil") String perfil) {
		String perfilAnalisado = null;
		
		try {
			perfilAnalisado = AnalisaPerfil.analisar(perfil);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		return perfilAnalisado;
	}
	
}
