package victorRibeiroDaSilva;

import java.util.ArrayList;
import java.util.Date;

public class MinhaLocadora extends Locadora {
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	ArrayList<Aluguel> registro = new ArrayList<Aluguel>();
	Loc l = new Loc();
	
	
	public boolean inserir(Veiculo v) {
		Veiculo veiculo = pesquisar(v.getPlaca());
		if(veiculo == null) { 
			l.rep.veiculos.add(v);
			return true;
		}
		return false;
	}
	
	public Veiculo pesquisar(String placa) {
		return l.rep.procurar(placa);
	}
	
	
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada){
		ArrayList<Veiculo> motos = new ArrayList<Veiculo>();
		for (Veiculo m : l.rep.veiculos) {
			if(m instanceof Moto) {
				if(((Moto) m).getCilindrada()>= cilindrada) {
				motos.add(m);
				}
			}
		}
		return motos;
	}
	
	
	// tipo de carro
	// 1 (passeio), 2 (SUV), 3 (pickup)
	public ArrayList<Veiculo> pesquisarCarro(int categoria){
		ArrayList<Veiculo> carros = new ArrayList<Veiculo>();
		for (Veiculo c : l.rep.veiculos) {
			if(c instanceof Carro) {
				if(((Carro) c).getTipo() == categoria) {
					carros.add(c);
				}
			}
			
		}
		return carros;
	}
	
	
	public ArrayList<Veiculo> pesquisarCaminhao(int carga){
		ArrayList<Veiculo> caminhoes = new ArrayList<Veiculo>();
		for (Veiculo ca : l.rep.veiculos) {
			if(ca instanceof Caminhao) {
				if(((Caminhao) ca).getCapCarga() == carga) {
					caminhoes.add(ca);
				}
			}

		
	}
	return caminhoes;
}
	

	public ArrayList<Veiculo> pesquisarOnibus(int passageiros){
		ArrayList<Veiculo> onibus = new ArrayList<Veiculo>();
		for (Veiculo o : l.rep.veiculos) {
			if(o instanceof Onibus) {
				if(((Onibus) o).getCapPassageiros()>= passageiros) {
					onibus.add(o);
				}
			}
		}
		return onibus;
}
	
	//Seguro Moto = (valor do bem * 11%)/365
	//Seguro Carro = (valor do bem * 3%)/365
	//Seguro Caminhão = (valor do bem * 8%)/365
	//Seguro Ônibus = (valor do bem * 20%)/365
	//Aluguel = (valor da diária + seguro) * quantidade de dias
	public double calcularAluguel(String placa, int dias) {
		Veiculo v = pesquisar(placa);
		if (v != null) {
			return v.aluguel(dias);
			
		}
	return -1;
	}
	
	public Aluguel pesquisarAluguel(String placa) {
		for(Aluguel a: alugueis) {
			if(a.getVeiculo().getPlaca().equals(placa)) {
				return a;
			}
		}
		return null;
	}
	
	
	public boolean registrarAluguel(String placa, Date data, int dias, int cpf) {
		Veiculo v = pesquisar(placa);
		if(v != null) {
			if(pesquisarAluguel(placa)!=null || pesquisarCliente(cpf)== null) {
				return false;
			}else{
				Aluguel a = new Aluguel();
				a.setCpf(cpf);
				a.setDias(dias);
				a.setInicio(data);
				a.setVeiculo(v);
				a.setValor(v.aluguel(dias));
				v.aluguel(dias);
				alugueis.add(a);
				return true;
			}
		}
		return false;
	}
	
	
	public boolean registrarDevolucao(String placa) {
		Aluguel a = pesquisarAluguel(placa);
		if(a!=null) {
			alugueis.remove(a);
			registro.add(a);
			return true;
		}

		return false;
	}
	
	
	// tipo de veiculo
	// 0 (todos), 1 (moto), 2 (carro), 3 (caminhão), 4 (ônibus)
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
		for (Veiculo v : l.rep.veiculos) {
			switch(tipo) {
			case 0:
				v.AlterarValAvaliado(v.getValorAvaliado()*(1-taxaDepreciacao));
				break;
			case 1:
				if(v instanceof Moto) {
					v.AlterarValAvaliado(v.getValorAvaliado()*(1-taxaDepreciacao));
				}
				break;
			case 2:
				if(v instanceof Carro) {
					v.AlterarValAvaliado(v.getValorAvaliado()*(1-taxaDepreciacao));
				}
				break;
			case 3:
				if(v instanceof Caminhao) {
					v.AlterarValAvaliado(v.getValorAvaliado()*(1-taxaDepreciacao));
				}
				break;
			case 4:
				if(v instanceof Onibus) {
					v.AlterarValAvaliado(v.getValorAvaliado()*(1-taxaDepreciacao));
				}
				break;
			default:
				break;
			}
		}
	}
	
	
	public void aumentarDiaria(int tipo, double taxaAumento) {
		for (Veiculo v : l.rep.veiculos) {
			switch(tipo) {
			case 0:
				v.AlterarValDiaria(v.getValorDiaria()*(1+taxaAumento));
				break;
			case 1:
				if(v instanceof Moto) {
					v.AlterarValDiaria(v.getValorDiaria()*(1+taxaAumento));
				}
				break;
			case 2:
				if(v instanceof Carro) {
					v.AlterarValDiaria(v.getValorDiaria()*(1+taxaAumento));
				}
				break;
			case 3:
				if(v instanceof Caminhao) {
					v.AlterarValDiaria(v.getValorDiaria()*(1+taxaAumento));
				}
				break;
			case 4:
				if(v instanceof Onibus) {
					v.AlterarValDiaria(v.getValorDiaria()*(1+taxaAumento));
				}
				break;
			default:
				break;
			}
		}
	}
	
	@Override
	public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim) {
		int total = 0;
		for(Aluguel a : registro) {
			switch(tipo) {
				case 0:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						total+=a.getDias();
					}
					break;
				case 1:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Moto) {
							total+=a.getDias();
						}
					}
					break;
				case 2:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Carro) {
							total+=a.getDias();
						}
					}
					break;
				case 3:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Caminhao) {
							total+=a.getDias();
						}
					}
					break;
				case 4:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Onibus) {
							total+=a.getDias();
						}
					}
					break;
			}
		}
		return total;
	}


	@Override
	public double faturamentoTotal(int tipo, Date inicio, Date fim) {
		double total = 0;
		for(Aluguel a : registro) {
			switch(tipo) {
				case 0:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						total+=a.getValor();
					}
					break;
				case 1:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Moto) {
							total+=a.getValor();
						}
					}
					break;
				case 2:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Carro) {
							total+=a.getValor();
						}
					}
					break;
				case 3:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Caminhao) {
							total+=a.getValor();
						}
					}
					break;
				case 4:
					if(inicio.compareTo(a.getInicio())<= 0 && fim.compareTo(a.getInicio())>=0) {
						if(a.getVeiculo() instanceof Onibus) {
							total+=a.getValor();
						}
					}
					break;
			}
		}
		return total;
	}


}
