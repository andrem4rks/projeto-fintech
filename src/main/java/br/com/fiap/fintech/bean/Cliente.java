package br.com.fiap.fintech.bean;

public class Cliente {
	private int id;
	
	private String nome;
	
	private String cpf;
	
	private String numeroContato;
	
	public Cliente() {
		super();
		
	}

	public Cliente(int id, String nome, String cpf, String numeroContato) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.numeroContato = numeroContato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}
}
