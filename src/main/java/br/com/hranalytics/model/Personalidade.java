package br.com.hranalytics.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Personalidade {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	private List<Dimensao> bigFive;
	
	@OneToOne
	private Candidato candidato;
	
	public Personalidade() {
		super();
	}
	public Personalidade(Long id, List<Dimensao> bigFive, Candidato candidato) {
		super();
		this.id = id;
		this.bigFive = bigFive;
		this.candidato = candidato;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Dimensao> getBigFive() {
		return bigFive;
	}
	public void setBigFive(List<Dimensao> bigFive) {
		this.bigFive = bigFive;
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	@Override
	public String toString() {
		return "Personalidade [id=" + id + ", bigFive=" + bigFive + ", candidato=" + candidato + "]";
	}
}
