package victorRibeiroDaSilva;

public class Moto extends Veiculo {
	private int cilindrada;

	
	public Moto(String marca, String modelo, int ano, double valAvaliado, double valDiaria, String placa,
			int cilindrada) {
		super(marca, modelo, ano, valAvaliado, valDiaria, placa);
		this.cilindrada = cilindrada;
	}

	public double seguro(){
		return (ValorAvaliado*0.11)/365;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}


}
