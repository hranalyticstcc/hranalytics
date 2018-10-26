package br.com.hranalytics.model;

public class UsuarioDTO {
	
	private String nome;
	private String situacao;
	private String cep;
	private String numero;
	private String status;
	private String message;
	private String cnpj;
	private String cpf;
	private String telefone;
	private String celular;
	private String nomePessoaFisica;
	private String nomeUsuario;
	private String senha;
	private String email;
	
	public UsuarioDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getNomePessoaFisica() {
		return nomePessoaFisica;
	}

	public void setNnomePessoaFisica(String nomePessoaFisica) {
		this.nomePessoaFisica = nomePessoaFisica;
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

	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", situacao=" + situacao + ", cep=" + cep + ", numero=" + numero
				+ ", status=" + status + ", message=" + message + ", cnpj=" + cnpj + ", cpf=" + cpf + ", telefone="
				+ telefone + ", celular=" + celular + ", nomeFantasia=" + nomePessoaFisica + ", usuario=" + nomeUsuario
				+ ", senha=" + senha + ", email=" + email + "]";
	}
}
