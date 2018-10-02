package br.com.hranalytics.HrAnalytics;

public class Teste {
	/*public static void main(String[] args) throws TwitterException {
		List<String> tweets = new ArrayList<String>();

		TwitterAPI apiTwitter = new TwitterAPI();
		tweets = apiTwitter.pegaLinhaDoTempo("realdonaldtrump");

		String json = new MontaJson().montaJsonStringBuffer(tweets);

		WatsonPersonalityInsights insights = new WatsonPersonalityInsights();
		doMagic(insights.analisarPerfil(json));
	}

	public static void doMagic(String json) {

		try {
			JSONObject jo = new JSONObject(json);
			JSONArray arrayPersonalidade = jo.getJSONArray("personality");

			Personalidade personalidade = new Personalidade();
			List<Dimensao> bigFive = new ArrayList<>();

			for (int i = 0; i < arrayPersonalidade.length(); i++) {

				Dimensao dim = new Dimensao();

				JSONObject bigFiveJson = arrayPersonalidade.getJSONObject(i);
				dim.setNome(bigFiveJson.getString("name"));
				dim.setPorcentagem(bigFiveJson.getDouble("percentile"));

				JSONArray children = bigFiveJson.getJSONArray("children");
				List<DimensaoFilho> filhos = new ArrayList<>();

				for (int j = 0; j < children.length(); j++) {
					DimensaoFilho df = new DimensaoFilho();

					JSONObject childrenObject = children.getJSONObject(j);
					df.setNome(childrenObject.getString("name"));
					df.setPorcentagem(childrenObject.getDouble("percentile"));
					
					filhos.add(df);
				}
				
				dim.setFilhos(filhos);
				bigFive.add(dim);
			}
			personalidade.setBigFive(bigFive);


			for (Dimensao dimensao : bigFive) {
				System.out.println("----------------");
				System.out.println(dimensao.getNome());
				System.out.println(dimensao.getPorcentagem());
				for (DimensaoFilho dimensaoF : dimensao.getFilhos()) {
					System.out.println(dimensaoF.getNome());
					System.out.println(dimensaoF.getPorcentagem());
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}*/
}