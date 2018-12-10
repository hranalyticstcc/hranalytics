package br.com.hranalytics.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Fator {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private double porcentagem;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "fator")
	private List<Dimensao> dimensoes;
	
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="fatores")
	private Personalidade personalidade;
	
	public Fator() {
		super();
	}
	public Fator(Long id, String nome, double porcentagem, List<Dimensao> filhos) {
		super();
		this.id = id;
		this.nome = nome;
		this.porcentagem = porcentagem;
		this.dimensoes = filhos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}
	public List<Dimensao> getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(List<Dimensao> dimensoes) {
		this.dimensoes = dimensoes;
	}
	@Override
	public String toString() {
		return "Dimensao [id=" + id + ", nome=" + nome + ", porcentagem=" + porcentagem + ", filhos=" + dimensoes + "]";
	}
}
