package victorRibeiroDaSilva;

import java.util.ArrayList;


public class RepDeVeiculos {
	public ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	
	public void inserir(Veiculo v) {
		if (procurar(v.getPlaca()) != null) {
			System.out.println("Placa já existente");
		}
		else {
			veiculos.add(v);
		}
		
	}
	
	public RepDeVeiculos() {
	}


	public Veiculo procurar(String placa) {
		for(Veiculo v: veiculos) {
			if(v.getPlaca() == placa) {
				return v;
			}
		}
		return null;
	}
}
	
	