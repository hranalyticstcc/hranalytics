package br.com.hranalytics.HrAnalytics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DimensaoFilho {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private double porcentagem;
	
	@ManyToOne
	private Dimensao dimensao;
	
	public DimensaoFilho() {
		super();
	}
	public DimensaoFilho(Long id, String nome, double porcentagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.porcentagem = porcentagem;
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
	@Override
	public String toString() {
		return "DimensaoFilho [id=" + id + ", nome=" + nome + ", porcentagem=" + porcentagem + "]";
	}
}
