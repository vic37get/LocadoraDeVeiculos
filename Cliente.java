package victorRibeiroDaSilva;

public class Cliente {
	private int cpf;
	private String nome;
	

	public Cliente(int cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
	

}
