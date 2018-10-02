package br.com.hranalytics.HrAnalytics.utils;

import java.util.HashMap;

public class Tradutor {

	public static String traduzir(String palavraIngles) {
		HashMap<String, String> mapWords = new HashMap<>();
		preenche(mapWords);
		
		String palavraPortugues = mapWords.get(palavraIngles);
		return palavraPortugues;
	}

	public static void preenche(HashMap<String, String> words) {

		words.put("big5_openness","Sentimentos");
		words.put("facet_adventurousness", "Aventureiro");
		words.put("facet_artistic_interests", "Interesses Artísticos");
		words.put("facet_emotionality","Emoção");
		words.put("facet_imagination","Imaginação");
		words.put("facet_intellect","Intelecto");
		words.put("facet_liberalism","Liberalismo");

		words.put("big5_conscientiousness","Consciência");
		words.put("facet_achievement_striving","Esforçado");
		words.put("facet_cautiousness","Cuidadoso");
		words.put("facet_dutifulness","Obediência");
		words.put("facet_orderliness","Comportamento");
		words.put("facet_self_discipline","Disciplina");
		words.put("facet_self_efficacy","Eficácia");

		words.put("big5_extraversion","Extroversão");
		words.put("facet_activity_level","Proatividade");
		words.put("facet_assertiveness","Assertividade");
		words.put("facet_cheerfulness","Alegria");
		words.put("facet_excitement_seeking","Procura de desafios");
		words.put("facet_friendliness","Simpatia");
		words.put("facet_gregariousness","Social");

		words.put("big5_agreeableness","Agragabilidade");
		words.put("facet_altruism","Altruismo");
		words.put("facet_cooperation", "Cooperação");
		words.put("facet_modesty","Modestidade");
		words.put("facet_sympathy","Simpaticidade");
		words.put("facet_morality","Moralidade");
		words.put("facet_trust","Confiança");

		words.put("big5_neuroticism","Neuroticismo");
		words.put("facet_anger","Raiva");
		words.put("facet_anxiety","Ansiedade");
		words.put("facet_depression","Depressão");
		words.put("facet_immoderation","Imoderacao");
		words.put("facet_self_consciousness","Auto Conciência");
		words.put("facet_vulnerability","Vulnerabilidade");
	}

}
