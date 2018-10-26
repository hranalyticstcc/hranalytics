package br.com.hranalytics.wsclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

@Service
public class WatsonAPI {

	@Value("${ibm.cloud.usuario}")
	private String user;
	
	@Value("${ibm.cloud.senha}")
	private String senha;
	
	@Value("${ibm.cloud.versao}")
	private String version;

	public String analisarPerfil(String json) {
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
