package br.com.hranalytics.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Personalidade {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name = "personalidade")
	private List<Fator> fatores;
	
	@OneToOne(mappedBy="personalidade")
	private Candidato candidato;
	
	public Personalidade() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Fator> getFatores() {
		return fatores;
	}
	public void setFatores(List<Fator> fatores) {
		this.fatores = fatores;
	}
	@Override
	public String toString() {
		return "Personalidade [id=" + id + ", bigFive=" + fatores + ", candidato=" + candidato + "]";
	}
}
