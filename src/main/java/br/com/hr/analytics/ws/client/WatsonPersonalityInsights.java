package br.com.hr.analytics.ws.client;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class WatsonPersonalityInsights {

	private final static String user = "8287be2e-3a4e-415f-ae38-50c09af429d0";
	private final static String senha = "mthsgw3c6yfa";
	private final static String version = "2017-10-13";

	public static String analisarPerfil(String json) {
		PersonalityInsights service = new PersonalityInsights(version);
		service.setUsernameAndPassword(user, senha);
		Content content = GsonSingleton.getGson().fromJson(json, Content.class);

		ProfileOptions options = new ProfileOptions.Builder()
				.content(content)
				.consumptionPreferences(true)
				.rawScores(true)
				.build();

		Profile profile = service.profile(options).execute();
		return profile.toString();
	}
}
