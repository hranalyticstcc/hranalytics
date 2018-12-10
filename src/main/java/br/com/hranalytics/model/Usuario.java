package br.com.hranalytics.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@NotEmpty(message = "Preencha o campo obrigatório: CPF")
	private String cpf;
	
	private String telefone;
	
	private String celular;
	
	private String cnpj;
	
	@Column(name = "situacao_cnpj")
	private String situacao;
	
	@NotEmpty(message = "Preencha o campo obrigatório: Nome")
	private String nomePessoaFisica;
	
	private String logradouro;
	
	private String cep;
	
	private String numero;
	
	@NotEmpty(message = "Preencha o campo obrigatório: Usuário")
	@Column(unique=true) 
	private String nomeUsuario;
	
	@NotEmpty(message = "Preencha o campo obrigatório: Senha")
	@JsonIgnore 
	private String senha;
	
	@NotEmpty(message = "Preencha o campo obrigatório: E-mail")
	private String email;
	
	private RoleEnum role;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Candidato> candidatos;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval = false)
	private List<Pagamento> pagamentos;
	
	public Usuario() {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNomePessoaFisica() {
		return nomePessoaFisica;
	}

	public void setNomePessoaFisica(String nomePessoaFisica) {
		this.nomePessoaFisica = nomePessoaFisica;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
	public void addCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", celular="
				+ celular + ", cnpj=" + cnpj + ", situacao=" + situacao + ", nomePessoaFisica=" + nomePessoaFisica
				+ ", logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", nomeUsuario=" + nomeUsuario
				+ ", senha=" + senha + ", email=" + email + ", role=" + role + ", candidatos=" + candidatos
				+ ", pagamentos=" + pagamentos + "]";
	}
}
