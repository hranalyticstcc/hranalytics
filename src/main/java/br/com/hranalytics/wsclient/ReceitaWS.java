package br.com.hranalytics.wsclient;

import org.springframework.web.client.RestTemplate;

import br.com.hranalytics.model.Usuario;

public class ReceitaWS {
	
	private static final String ENDERECO_RECEITA_WS = "https://www.receitaws.com.br/v1/cnpj/";
	
	public static void main(String[] args) {
		System.out.println(validaCNPJ("15803817000175").getNome());
	}
	
	public static Usuario validaCNPJ(String cnpj) {
		
		RestTemplate restTemplate = new RestTemplate();
		Usuario usuario = restTemplate.getForObject(ENDERECO_RECEITA_WS + cnpj, Usuario.class);
		
		return usuario;
		
	}

}
