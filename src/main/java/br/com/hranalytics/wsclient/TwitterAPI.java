package br.com.hranalytics.wsclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TwitterAPI {
	
	@Value("${twitter4j.consumer.key}")
	private String OAuthConsumerKey;
	
	@Value("${twitter4j.consumer.secret}")
	private String OAuthConsumerSecret;
	
	@Value("${twitter4j.access.token}")
	private String OAuthAccessToken;
	
	@Value("${twitter4j.access.token.secret}")
	private String OAuthAccessTokenSecret;

	public List<String> pegaLinhaDoTempo(String usuarioAnalisado) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		configuraChavesTWitter(cb);

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		// Parametros: Paging(Número de Páginas, Número por páginas)
		Paging paging = new Paging(3, 300);
		
		List<Status> statuses = null;
		try {
			statuses = twitter.getUserTimeline(usuarioAnalisado, paging);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		List<String> tweets = new ArrayList<String>();

		for (Status status : statuses) {
			// Filtra a timeline pegando somente os tweets do usuário analisado
			if (validaConteudo(status.getText())) {
				tweets.add(status.getText());
			}
		}

		return tweets;
	}

	public ConfigurationBuilder configuraChavesTWitter(ConfigurationBuilder cb) {
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey(OAuthConsumerKey)
			.setOAuthConsumerSecret(OAuthConsumerSecret)
			.setOAuthAccessToken(OAuthAccessToken)
			.setOAuthAccessTokenSecret(OAuthAccessTokenSecret);
		
		return cb;
	}
	
	public boolean validaConteudo(String conteudo) {
		if (!conteudo.contains("RT @") && !conteudo.contains("//"))
			return true;
		else
			return false;
	}

}
