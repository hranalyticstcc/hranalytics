package br.com.hranalytics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.hranalytics.model.Candidato;
import br.com.hranalytics.model.Conteudo;
import br.com.hranalytics.model.ConteudosWatsonDTO;
import br.com.hranalytics.model.Dimensao;
import br.com.hranalytics.model.Fator;
import br.com.hranalytics.model.Personalidade;
import br.com.hranalytics.repository.CandidatoRepository;
import br.com.hranalytics.repository.PersonalidadeRepository;
import br.com.hranalytics.utils.EmailUtil;
import br.com.hranalytics.utils.Tradutor;
import br.com.hranalytics.wsclient.TwitterAPI;
import br.com.hranalytics.wsclient.WatsonAPI;
import br.com.hranalytics.wsclient.YandexTradutorAPI;
import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

@Service
public class AnaliseDePersonalidadeService {

	@Autowired
	private WatsonAPI watsonAPI;

	@Autowired
	private TwitterAPI twitterAPI;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private PersonalidadeRepository personalidadeRepo;

	@Autowired
	private CandidatoRepository candidatoRepo;

	@Autowired
	private YandexTradutorAPI tradutorAPI;

	public String enviarFormularioCadastroCandidato(String emailCandidato) {
		emailUtil.enviarHtml(emailCandidato, "HR Analytics - Cadastro candidato",
				emailUtil.constroiEmailConfirmacaoCadastroUsuario());

		return "";
	}

	public Personalidade consultaPersonalidadeBd(String candidato) {
		Personalidade personalidade = null;

		Candidato candidatoBO = candidatoRepo.findByPerfilTwitter(candidato);
		personalidade = personalidadeRepo.findByCandidato(candidatoBO);

		if (personalidade == null)
			personalidade = analisarPersonalidade(candidato, null);

		return personalidade;
	}

	public List<String> traducaoParaIngles(List<String> lista) {

		boolean precisaTraduzir = false;
		List<String> listaTraduzida = null;

		if (lista != null && !lista.isEmpty()) {
			precisaTraduzir = tradutorAPI.precisaTraduzirDePortuguesParaIngles(lista.get(0));
		}

		if (precisaTraduzir) {			
			listaTraduzida = new ArrayList<>();
			
			for (String texto : lista) {
				listaTraduzida.add(tradutorAPI.traduzirTexto(texto));
			}
			
			return listaTraduzida;
		}
		
		return lista;
	}

	public Personalidade analisarPersonalidade(String perfil, List<String> listaRespostasQuestionario) {
		List<String> textos = null;
		textos = twitterAPI.pegaLinhaDoTempo(perfil);
		
		if(listaRespostasQuestionario != null && !listaRespostasQuestionario.isEmpty()) {
			for (String txt : listaRespostasQuestionario) {
				textos.add(txt);
			}
		}
		
		textos = traducaoParaIngles(textos);

		String jsonEntradaWatson = constroiJsonEntradaWatson(textos);
		String jsonSaidaWatson = watsonAPI.analisarPerfil(jsonEntradaWatson);

		Personalidade personalidade = constroiPersonalidade(jsonSaidaWatson);

		return personalidade;
	}

	public String constroiJsonEntradaWatson(List<String> textos) {

		ConteudosWatsonDTO cw = new ConteudosWatsonDTO();
		for (String texto : textos) {
			cw.addContentItems(new Conteudo(texto));
		}
		Gson gson = new Gson();
		return gson.toJson(cw);
	}

	public Personalidade constroiPersonalidade(String json) {

		Personalidade personalidade = new Personalidade();

		try {
			JSONObject jo = new JSONObject(json);
			JSONArray arrayPersonalidade = jo.getJSONArray("personality");

			List<Fator> bigFive = new ArrayList<>();

			for (int i = 0; i < arrayPersonalidade.length(); i++) {

				Fator dim = new Fator();

				JSONObject bigFiveJson = arrayPersonalidade.getJSONObject(i);
				dim.setNome(Tradutor.traduzir(bigFiveJson.getString("trait_id")));
				dim.setPorcentagem(bigFiveJson.getDouble("percentile"));

				JSONArray children = bigFiveJson.getJSONArray("children");
				List<Dimensao> filhos = new ArrayList<>();

				for (int j = 0; j < children.length(); j++) {
					Dimensao df = new Dimensao();

					JSONObject childrenObject = children.getJSONObject(j);
					df.setNome(Tradutor.traduzir(childrenObject.getString("trait_id")));
					df.setPorcentagem(childrenObject.getDouble("percentile"));

					filhos.add(df);
				}

				dim.setDimensoes(filhos);
				bigFive.add(dim);
			}

			personalidade.setFatores(bigFive);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return personalidade;
	}
	
	public Candidato consultaCandidato(Long id) {
		return candidatoRepo.findById(id).get();
	}

}
