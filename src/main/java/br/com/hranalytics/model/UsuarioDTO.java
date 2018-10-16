package br.com.hranalytics.model;

public class UsuarioDTO {
	
	private String nome;
	private String situacao;
	private String cep;
	private String numero;
	private String status;
	private String message;
	private String cnpj;
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
	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", situacao=" + situacao + ", cep=" + cep + ", numero=" + numero
				+ ", status=" + status + ", message=" + message + ", cnpj=" + cnpj + "]";
	}
}
