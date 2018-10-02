package br.com.hranalytics.HrAnalytics.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private String usuarioTwitter;
	
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	public Usuario() {
		super();
	}
	public Usuario(Long id, String nome, String usuarioTwitter, String email, Calendar dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuarioTwitter = usuarioTwitter;
		this.email = email;
		this.dataNascimento = dataNascimento;
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
	public String getUsuarioTwitter() {
		return usuarioTwitter;
	}
	public void setUsuarioTwitter(String usuarioTwitter) {
		this.usuarioTwitter = usuarioTwitter;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", usuarioTwitter=" + usuarioTwitter + ", email=" + email
				+ ", dataNascimento=" + dataNascimento + "]";
	}
}
