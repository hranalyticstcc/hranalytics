package br.com.hr.analytics.ws.client;

import java.util.ArrayList;
import java.util.List;

import br.com.hr.analytics.json.MontaJson;
import twitter4j.TwitterException;

public class AnalisaPerfil {

	public static String analisar(String perfil) throws TwitterException {
		List<String> tweets = new ArrayList<String>();

		TwitterAPI apiTwitter = new TwitterAPI();
		tweets = apiTwitter.pegaLinhaDoTempo(perfil);

		String json = new MontaJson().montaJsonStringBuilder(tweets);

		String perfilAnalisado = WatsonPersonalityInsights.analisarPerfil(json);
		
		return perfilAnalisado;
	}

}
