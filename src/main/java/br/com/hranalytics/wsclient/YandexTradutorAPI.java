package br.com.hranalytics.wsclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.hranalytics.model.YandexRetornoDTO;

@Component
public class YandexTradutorAPI {
	
	@Value("${yandex.key}")
	private String key;
	
	private String ENDPOINT_YANDEX_TRADUTOR_API = "https://translate.yandex.net/api/v1.5/tr.json/translate";
	
	private String ENDPOINT_YANDEX_DETECTOR_API = "https://translate.yandex.net/api/v1.5/tr.json/detect";
	
	public String traduzirTexto(String texto) {
		RestTemplate restTemplate = new RestTemplate();
		
		String requisicao = inserirParametrosRequisicaoTradutor(texto);
		YandexRetornoDTO retorno = restTemplate.getForObject(requisicao, YandexRetornoDTO.class);
		
		return retorno.getText().get(0);
	}
	
	public boolean precisaTraduzirDePortuguesParaIngles(String texto) {
		RestTemplate restTemplate = new RestTemplate();
		YandexRetornoDTO retorno = restTemplate.getForObject(inserirParametrosRequisicaoDector(texto), YandexRetornoDTO.class);
		
		boolean flag;
		
		if(retorno.getLang().equals("pt")) {
			flag = true;
		}else {
			flag = false;
		}
		
		return flag;
	}
	
	public String inserirParametrosRequisicaoTradutor(String texto) {
		ENDPOINT_YANDEX_TRADUTOR_API += "?key=" + key
				+ "&text=" + texto
				+ "&lang=pt-en";
		
		System.out.println("ENDPOINT: " + ENDPOINT_YANDEX_TRADUTOR_API);
		
		return ENDPOINT_YANDEX_TRADUTOR_API;
	}
	
	public String inserirParametrosRequisicaoDector(String texto) {
		ENDPOINT_YANDEX_DETECTOR_API += "?key=" + key
				+ "&text=" + texto;
		
		return ENDPOINT_YANDEX_DETECTOR_API;
	}

}
