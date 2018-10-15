package br.com.hranalytics.utils;

import java.util.List;

import com.google.gson.Gson;

import br.com.hranalytics.model.Content;
import br.com.hranalytics.model.ConteudosWatsonDTO;

public class MontaJson {

	public String montaJsonStringBind(List<String> tweets) {
		
		ConteudosWatsonDTO cwdto = new ConteudosWatsonDTO();
		
		for (String tweet : tweets) {
			cwdto.addContentItems(new Content(tweet));
		}
		
		Gson gson = new Gson();
		
		return gson.toJson(cwdto);
	}
}
