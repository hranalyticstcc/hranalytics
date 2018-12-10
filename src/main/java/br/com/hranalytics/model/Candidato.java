package br.com.hranalytics.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	private StatusAnaliseEnum statusAnalise;
	
	private String email;
	
	private String perfilTwitter;
	
	@Column(name="termos_e_condicoes")
	private boolean aceitaTermosECondicoes;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	private Personalidade personalidade;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public Candidato() {
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

	public StatusAnaliseEnum getStatusAnalise() {
		return statusAnalise;
	}

	public void setStatusAnalise(StatusAnaliseEnum statusAnalise) {
		this.statusAnalise = statusAnalise;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfilTwitter() {
		return perfilTwitter;
	}

	public void setPerfilTwitter(String perfilTwitter) {
		this.perfilTwitter = perfilTwitter;
	}

	public boolean isAceitaTermosECondicoes() {
		return aceitaTermosECondicoes;
	}

	public void setAceitaTermosECondicoes(boolean aceitaTermosECondicoes) {
		this.aceitaTermosECondicoes = aceitaTermosECondicoes;
	}

	public Personalidade getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(Personalidade personalidade) {
		this.personalidade = personalidade;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", statusAnalise=" + statusAnalise + ", email=" + email
				+ ", perfilTwitter=" + perfilTwitter + ", aceitaTermosECondicoes=" + aceitaTermosECondicoes
				+ ", usuario=" + usuario + ", personalidade=" + personalidade + ", dataNascimento=" + dataNascimento
				+ "]";
	}
}
