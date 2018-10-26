package br.com.hranalytics.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.hranalytics.model.Conteudo;
import br.com.hranalytics.model.ConteudosWatsonDTO;
import br.com.hranalytics.model.Dimensao;
import br.com.hranalytics.model.DimensaoFilho;
import br.com.hranalytics.model.Personalidade;
import br.com.hranalytics.utils.Tradutor;
import br.com.hranalytics.wsclient.TwitterAPI;
import br.com.hranalytics.wsclient.WatsonAPI;
import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

@Service
public class AnaliseDePersonalidadeService {

	@Autowired
	private WatsonAPI watsonAPI;
	
	@Autowired
	private TwitterAPI twitterAPI;

	public Personalidade analisarPersonalidade(String perfil) {
		List<String> tweets = null;
		tweets = twitterAPI.pegaLinhaDoTempo(perfil);

		String jsonEntradaWatson = constroiJsonEntradaWatson(tweets);
		String jsonSaidaWatson = watsonAPI.analisarPerfil(jsonEntradaWatson);

		Personalidade personalidade = constroiPersonalidade(jsonSaidaWatson);

		return personalidade;
	}

	public String constroiJsonEntradaWatson(List<String> tweets) {

		ConteudosWatsonDTO cwdto = new ConteudosWatsonDTO();
		for (String tweet : tweets) {
			cwdto.addContentItems(new Conteudo(tweet));
		}
		Gson gson = new Gson();
		return gson.toJson(cwdto);
	}

	public Personalidade constroiPersonalidade(String json) {

		Calendar cal = Calendar.getInstance();
		System.out.println("START TIME " + cal.getTime());

		Personalidade personalidade = new Personalidade();

		try {
			JSONObject jo = new JSONObject(json);
			JSONArray arrayPersonalidade = jo.getJSONArray("personality");

			List<Dimensao> bigFive = new ArrayList<>();

			for (int i = 0; i < arrayPersonalidade.length(); i++) {

				Dimensao dim = new Dimensao();

				JSONObject bigFiveJson = arrayPersonalidade.getJSONObject(i);
				dim.setNome(Tradutor.traduzir(bigFiveJson.getString("trait_id")));
				dim.setPorcentagem(bigFiveJson.getDouble("percentile"));

				JSONArray children = bigFiveJson.getJSONArray("children");
				List<DimensaoFilho> filhos = new ArrayList<>();

				for (int j = 0; j < children.length(); j++) {
					DimensaoFilho df = new DimensaoFilho();

					JSONObject childrenObject = children.getJSONObject(j);
					df.setNome(Tradutor.traduzir(childrenObject.getString("trait_id")));
					df.setPorcentagem(childrenObject.getDouble("percentile"));

					filhos.add(df);
				}

				dim.setFilhos(filhos);
				bigFive.add(dim);
			}

			personalidade.setBigFive(bigFive);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Calendar cal2 = Calendar.getInstance();
		System.out.println("END TIME " + cal2.getTime());

		return personalidade;
	}

}
