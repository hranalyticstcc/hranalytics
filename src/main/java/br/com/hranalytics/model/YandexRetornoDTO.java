package br.com.hranalytics.model;

import java.util.List;

public class YandexRetornoDTO {
	
	private List<String> text;
	
	private String lang;

	public YandexRetornoDTO() {
		super();
	}
	public List<String> getText() {
		return text;
	}
	public void setText(List<String> text) {
		this.text = text;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
}
