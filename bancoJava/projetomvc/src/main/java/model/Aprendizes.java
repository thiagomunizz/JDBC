package model;


public class Aprendizes {
    
	private Integer id;
	private String nome = "";
	private String endereco = "";	
	private String bairro = "";
    private String cpf ="";
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
}
