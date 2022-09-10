package victorRibeiroDaSilva;

public class Caminhao extends Veiculo {
	private int capCarga;

	public Caminhao(String marca, String modelo, int ano, double valAvaliado, double valDiaria, String placa,
			int capCarga) {
		super(marca, modelo, ano, valAvaliado, valDiaria, placa);
		this.capCarga = capCarga;
	}

	public double seguro() {
		return (ValorAvaliado*0.08)/365;
	}

	public int getCapCarga() {
		return capCarga;
	}

	public void setCapCarga(int capCarga) {
		this.capCarga = capCarga;
	}
	
	

}
