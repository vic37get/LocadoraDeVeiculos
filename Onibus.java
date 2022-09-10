package victorRibeiroDaSilva;

public class Onibus extends Veiculo {
	private int capPassageiros;

	
	public Onibus(String marca, String modelo, int ano, double valAvaliado, double valDiaria, String placa,
			int capPassageiros) {
		super(marca, modelo, ano, valAvaliado, valDiaria, placa);
		this.capPassageiros = capPassageiros;
	}

	public double seguro() {
		return (ValorAvaliado*0.20)/365;
	}

	public int getCapPassageiros() {
		return capPassageiros;
	}

	public void setCapPassageiros(int capPassageiros) {
		this.capPassageiros = capPassageiros;
	}
	

}
