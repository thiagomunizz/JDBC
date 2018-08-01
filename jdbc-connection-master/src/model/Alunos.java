package model;

//modelagem : são classes que serão modeladas baseando-se na entidade no nosso banco de dados.

public class Alunos {
	//atributos principais de aluno
	private String nome = "";
	private String endereco = "";	
	private String bairro = "";
	private int cep = 0;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
}
