package lab11;


public class Pessoa extends EntidadeBanco{
	private String nome;
	private String telefone;
	private String endereco;
	private Long identificador;
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
	
	@Override
	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
}