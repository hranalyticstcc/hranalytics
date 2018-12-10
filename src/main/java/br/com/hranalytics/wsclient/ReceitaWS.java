package br.com.hranalytics.wsclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.hranalytics.model.UsuarioDTO;
import br.com.hranalytics.utils.ReceitaException;

@Component
public class ReceitaWS {

	private String ENDPOINT_RECEITA_WS = "https://www.receitaws.com.br/v1/cnpj/";

	public UsuarioDTO validaCNPJ(String cnpj) throws ReceitaException {

		RestTemplate restTemplate = new RestTemplate();
		UsuarioDTO usuario = 
				restTemplate.getForObject(ENDPOINT_RECEITA_WS + cnpj, UsuarioDTO.class);
		
		validaStatusCnpj(usuario);

		return usuario;
	}

	public void validaStatusCnpj(UsuarioDTO usuario) throws ReceitaException {

		if (usuario.getStatus().equals("OK")) {
			if (!usuario.getSituacao().equals("ATIVA")) {
				throw new ReceitaException(
						"A empresa está " + usuario.getSituacao() + ". A empresa precisa estar ATIVA");
			}
		} else {
			if (usuario.getMessage().equals("CNPJ inválido")) {
				throw new ReceitaException(usuario.getMessage());
			} else if (usuario.getMessage().equals("CNPJ rejeitado pela Receita Federal")) {
				throw new ReceitaException(usuario.getMessage());
			}
		}
	}

}
