package victorRibeiroDaSilva;

import java.util.ArrayList;

public class Loc {
	RepDeVeiculos rep = new  RepDeVeiculos();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private Veiculo v;
	
	
	
	public void CadastrarVeiculo(Veiculo v) {
		rep.inserir(v);
	}
	
	public void CadastrarCliente(Cliente c) {
		if(pesquisarCliente(c.getCpf())) {
			System.out.println("Cliente ja cadastrado");
		}
		else {
			clientes.add(c);	
}
		
		
}
	
	public boolean pesquisarCliente(int cpf) {
		for (Cliente c : clientes) {
			if(c.getCpf() == cpf) {
				return true;
			}
		
		}
		return false;
	}
	
	public double ConsultarAluguel(int tipo, int dias) {
		return v.aluguel(dias);
		
	}
	
	public double ConsultarSeguro(int tipo) {
		return v.seguro();
		
	}
	
	public void AlterarDiaria(int tipo, double val) {
		v.AlterarValDiaria(val);
		
	}
	
	public void AlterarValAvaliado(int tipo, double val) {
		v.AlterarValAvaliado(val);
		
	}
	
	/*public void ConsultarFrota(int tipo) {
		for (Veiculo p : rep.veiculos) {
			if(p.getTipo() == tipo) {
				System.out.println("Marca: "+p.getMarca());
				System.out.println("Modelo: "+p.getModelo());
				System.out.println("Ano: "+p.getAno());
				System.out.println("Placa: "+p.getPlaca());
				System.out.println("Valor da diária: "+p.getValDiaria());
				System.out.println("Valor do bem: "+p.getValAvaliado());
				System.out.println("");
			}
			}
			
		}
		*/
}
