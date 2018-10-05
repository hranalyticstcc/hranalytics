package br.com.hranalytics.HrAnalytics.model;

import java.util.ArrayList;
import java.util.List;

public class ConteudosWatsonDTO {
	
	private List<Content> contentItems;

	public ConteudosWatsonDTO() {
		super();
		contentItems = new ArrayList<>();
	}
	
	public void addContentItems(Content c) {
		this.contentItems.add(c);
	}

	public List<Content> getContentItems() {
		return contentItems;
	}

	public void setContentItems(List<Content> contentItems) {
		this.contentItems = contentItems;
	}

}
