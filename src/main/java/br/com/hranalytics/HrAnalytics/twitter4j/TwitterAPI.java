package br.com.hranalytics.HrAnalytics.twitter4j;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPI {

	private String OAuthConsumerKey;
	private String OAuthConsumerSecret;
	private String OAuthAccessToken;
	private String OAuthAccessTokenSecret;

	public TwitterAPI() {
		super();
		OAuthConsumerKey = "Xu8kVMGOrJa4tSb4wriTjiqZM";
		OAuthConsumerSecret = "JiYGeoQOqffvSrv46Dp5DSSFHx5nRbQXZMgELSE47yRfCBN5ng";
		OAuthAccessToken = "986953513090547713-3vJz2PiktjcOHpbmcK1erYmCIAhE3Pr";
		OAuthAccessTokenSecret = "fbzhhteBXpOIqevj8ZpbVZzGoNtNFkRwMaM9xmT8d2tng";
	}

	public List<String> pegaLinhaDoTempo(String usuarioAnalisado) throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		configuraChavesTWitter(cb);

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		// Parametros: Paging(Número de Páginas, Número por páginas)
		Paging paging = new Paging(3, 300);
		List<Status> statuses = twitter.getUserTimeline(usuarioAnalisado, paging);
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
