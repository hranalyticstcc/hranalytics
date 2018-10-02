package br.com.hranalytics.HrAnalytics.model;

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
	private Usuario usuario;
	
	public Personalidade() {
		super();
	}
	public Personalidade(Long id, List<Dimensao> bigFive, Usuario usuario) {
		super();
		this.id = id;
		this.bigFive = bigFive;
		this.usuario = usuario;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Personalidade [id=" + id + ", bigFive=" + bigFive + ", usuario=" + usuario + "]";
	}
}
