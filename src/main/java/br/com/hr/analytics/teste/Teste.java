package br.com.hr.analytics.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.hr.analytics.json.MontaJson;
import br.com.hr.analytics.ws.client.TwitterAPI;
import br.com.hr.analytics.ws.client.WatsonPersonalityInsights;
import twitter4j.TwitterException;

public class Teste {
	/*
	public static void main(String[] args) throws TwitterException {		
		List<String> tweets = new ArrayList<String>();
		
		TwitterAPI apiTwitter = new TwitterAPI();
		tweets = apiTwitter.pegaLinhaDoTempo("realdonaldtrump");
		
		String json = new MontaJson().montaJsonStringBuilder(tweets);
				
		WatsonPersonalityInsights insights = new WatsonPersonalityInsights();		
		insights.analisarPerfil(json);
	}
	*/
}