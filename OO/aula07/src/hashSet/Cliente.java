package hashSet;

public class Cliente  {

	private String cpf;
	private String nome;
	private String rg;

	public Cliente() {

	}

	public Cliente( String nome ) {

		this.nome = nome;
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf(String cpf) {

		this.cpf = cpf;
	}

	public String getRg() {

		return rg;
	}

	public void setRg(String rg) {

		this.rg = rg;
	}

	@Override
	public String toString() {

		return "Cliente [nome=" + getNome() + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
