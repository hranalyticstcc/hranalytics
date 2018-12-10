package br.com.hranalytics.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CadastroTemporario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique=true)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	Calendar dataHoraInicial;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHoraFinal;

	public CadastroTemporario() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataHoraInicial() {
		return dataHoraInicial;
	}

	public void setDataHoraInicial(Calendar dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	public Calendar getDataHoraFinal() {
		return dataHoraFinal;
	}

	public void setDataHoraFinal(Calendar dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}
}
