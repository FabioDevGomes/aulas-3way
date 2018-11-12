package lab07;


public class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	public Pessoa() {}
	
	public Pessoa( String nome ) {
		this.nome = nome;
	}
	
	//get e set
	public void ImprimeNome() {
		System.out.println("O nome da pessoa é : " + nome);
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public String getNome() {
		return nome;
	}
}