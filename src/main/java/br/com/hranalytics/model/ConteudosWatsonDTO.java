package br.com.hranalytics.model;

import java.util.ArrayList;
import java.util.List;

public class ConteudosWatsonDTO {
	
	private List<Conteudo> contentItems;

	public ConteudosWatsonDTO() {
		super();
		contentItems = new ArrayList<>();
	}
	
	public void addContentItems(Conteudo c) {
		this.contentItems.add(c);
	}

	public List<Conteudo> getContentItems() {
		return contentItems;
	}

	public void setContentItems(List<Conteudo> contentItems) {
		this.contentItems = contentItems;
	}

}
