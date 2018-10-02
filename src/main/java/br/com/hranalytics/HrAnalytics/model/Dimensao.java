package br.com.hranalytics.HrAnalytics.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dimensao {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private double porcentagem;
	
	@OneToMany
	private List<DimensaoFilho> filhos;
	
	@ManyToOne
	private Personalidade personalidade;
	
	public Dimensao() {
		super();
	}
	public Dimensao(Long id, String nome, double porcentagem, List<DimensaoFilho> filhos) {
		super();
		this.id = id;
		this.nome = nome;
		this.porcentagem = porcentagem;
		this.filhos = filhos;
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
	public List<DimensaoFilho> getFilhos() {
		return filhos;
	}
	public void setFilhos(List<DimensaoFilho> filhos) {
		this.filhos = filhos;
	}
	@Override
	public String toString() {
		return "Dimensao [id=" + id + ", nome=" + nome + ", porcentagem=" + porcentagem + ", filhos=" + filhos + "]";
	}
}
