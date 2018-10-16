package br.com.hranalytics.wsclient;

import org.springframework.web.client.RestTemplate;

import br.com.hranalytics.model.UsuarioDTO;
import br.com.hranalytics.utils.ReceitaException;

public class ReceitaWS {
	
	private static final String ENDERECO_RECEITA_WS = "https://www.receitaws.com.br/v1/cnpj/";
	
	public static UsuarioDTO validaCNPJ(String cnpj) throws ReceitaException {
		
		RestTemplate restTemplate = new RestTemplate();
		UsuarioDTO usuario = restTemplate.getForObject(ENDERECO_RECEITA_WS + cnpj, UsuarioDTO.class);
		
		if(usuario.getStatus().equals("OK")) {
			
			if(!usuario.getSituacao().equals("ATIVA")) {
				throw new ReceitaException("A empresa está " + usuario.getSituacao() + 
						". A empresa precisa estar ATIVA");
			}
			
			return usuario;
		} else {
			
			if(usuario.getMessage().equals("CNPJ inválido")) {
				throw new ReceitaException(usuario.getMessage());
			}else if (usuario.getMessage().equals("CNPJ rejeitado pela Receita Federal")){
				throw new ReceitaException(usuario.getMessage());
			}
		}
		
		return usuario;
	}

}
