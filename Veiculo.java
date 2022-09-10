package victorRibeiroDaSilva;

public abstract class Veiculo {
	protected String Marca;
	protected String Modelo;
	protected int AnoDeFabricacao;
	protected String Placa;
	protected double ValorAvaliado;
	protected double ValorDiaria;
	/**
	 * 
	 * moto = 1
	 * carro = 2
	 * onibus = 3
	 * caminhao = 4
	 * 
	 */
	public Veiculo(String marca, String modelo, int ano, double valAvaliado, double valDiaria, String placa) {
		this.Marca = marca;
		this.Modelo = modelo;
		this.AnoDeFabricacao = ano;
		this.ValorAvaliado = valAvaliado;
		this.ValorDiaria = valDiaria;
		this.Placa = placa;
	}
	
	
	public abstract double seguro();
	
	public double aluguel(int dias) {
		return (ValorDiaria + seguro())*dias;
	}
	
	
	public void AlterarValDiaria(double val) {
		ValorDiaria = val;
}
	
	public void AlterarValAvaliado(double val) {
		ValorAvaliado = val;
}
	

	public String getMarca() {
		return Marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public int getAnoDeFabricacao() {
		return AnoDeFabricacao;
	}

	public String getPlaca() {
		return Placa;
	}

	public double getValorDiaria() {
		return ValorDiaria;
	}

	public double getValorAvaliado() {
		return ValorAvaliado;
	}
	
	
	

}
