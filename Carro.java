package victorRibeiroDaSilva;

public class Carro extends Veiculo {
	private int Tipo;

	public Carro(String marca, String modelo, int ano, double valAvaliado, double valDiaria, String placa, int tipo) {
		super(marca, modelo, ano, valAvaliado, valDiaria, placa);
		Tipo = tipo;
	}

	public double seguro() {
		return (ValorAvaliado*0.03)/365;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		this.Tipo = tipo;
	}
	
}
