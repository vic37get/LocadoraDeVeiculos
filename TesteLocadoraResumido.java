package victorRibeiroDaSilva;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TesteLocadoraResumido {

	@Test

	void testeInserirVeiculo() {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 3);

	locadora.inserir(carro1);

	assertFalse(locadora.inserir(carro1));

	Veiculo recuperado = locadora.pesquisar("LVF-1000");

	assertEquals("Ford", recuperado.getMarca());

	assertEquals("F-1000", recuperado.getModelo());

	assertEquals(1980, recuperado.getAnoDeFabricacao());

	assertEquals(10000, recuperado.getValorAvaliado(), 0.0001);

	assertEquals(50, recuperado.getValorDiaria());

	assertEquals(3, ((Carro) recuperado).getTipo());

	}

	 

	@Test

	void testeInserirCliente() {

	MinhaLocadora locadora = new MinhaLocadora();

	Cliente cli1 = new Cliente(1234, "Z� Carlos");

	locadora.inserir(cli1);

	assertFalse(locadora.inserir(cli1));

	Cliente cli2 = locadora.pesquisarCliente(1234);

	assertEquals("Z� Carlos", cli2.getNome());

	}

	 

	@Test

	void testePesquisarVeiculo() {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 3);

	Veiculo carro2 = new Carro("Ford", "KA", 2010, 30000, 100, "LVF-3000", 1);

	 

	locadora.inserir(carro1);

	locadora.inserir(carro2);

	Veiculo pesquisa = locadora.pesquisar("LVF-3000");

	// Teste para saber se a pesquisa deu certo

	assertEquals("KA", pesquisa.getModelo());

	Veiculo pesquisa2 = locadora.pesquisar("LVF-1111");

	// Teste para saber se a pesquisa nao encontrou nada

	assertNull(pesquisa2);

	}

	 

	@Test

	void testePesquisarOnibus() {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo onibus1 = new Onibus("Estrela", "Aldebar�", 1975, 30000, 60, "X-911", 49);

	Veiculo onibus2 = new Onibus("Joca Motores", "Kall'anggo", 1978, 40000, 70, "Q-123", 50);

	Veiculo onibus3 = new Onibus("C�lcio Motores", "Bicusp", 1985, 50000, 85, "W-321", 70);

	 

	locadora.inserir(onibus1);

	locadora.inserir(onibus2);

	locadora.inserir(onibus3);

	 

	ArrayList<Veiculo> onibus50p = locadora.pesquisarOnibus(50);

	 

	// Confirmando numero de onibus com 50 passageiros

	assertEquals(2, onibus50p.size());

	}

	 

	@Test

	void testeCalcularAluguel(){

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

	locadora.inserir(moto1);

	 

	double aluguelMoto = locadora.calcularAluguel("X-911", 5);

	 

	// Confirmando valor do aluguel da moto: (40(diaria) + 4.52(seguro diario)) * 5 dias = 222.6

	assertEquals(222.6, aluguelMoto, 0.01);

	 

	}

	 

	@Test

	void testeRegistrarAluguel() {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100", 1);

	Cliente cli1 = new Cliente(1234, "Z� Carlos");

	locadora.inserir(carro1);

	locadora.inserir(cli1);

	 

	Date hoje = new Date();

	locadora.registrarAluguel("A-100", hoje, 5, 1234);

	// Registrar aluguel de veiculo j� registrado

	assertFalse(locadora.registrarAluguel("A-100", hoje, 5, 1234));

	// Registrar aluguel de veiculo inexistente

	assertFalse(locadora.registrarAluguel("A-111", hoje, 5, 1234));

	// Registrar aluguel de cliente inexistente

	assertFalse(locadora.registrarAluguel("A-111", hoje, 5, 1111));

	}

	 

	@Test

	void testeRegistrarDevolucao() {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100", 1);

	Cliente cli1 = new Cliente(1234, "Z� Carlos");

	locadora.inserir(carro1);

	locadora.inserir(cli1);

	 

	Date hoje = new Date();

	assertTrue(locadora.registrarAluguel("A-100", hoje, 5, 1234));

	assertTrue(locadora.registrarDevolucao("A-100"));

	 

	// Tentar devolu��o de veiculo n�o alugado

	assertFalse(locadora.registrarDevolucao("A-100"));

	 

	// Tentar devolu��o de veiculo de veiculo n�o existente

	assertFalse(locadora.registrarDevolucao("A-111"));

	}

	 

	@Test

	void testeAumentarDiaria() {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

	locadora.inserir(moto1);

	 

	locadora.aumentarDiaria(1, 0.1);// Aumentando di�ria de motos em 10%

	 

	assertEquals(44, locadora.pesquisar("X-911").getValorDiaria(), 0.01);

	 

	}

	 

	@Test

	void testeFaturamentoTotal()  {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

	locadora.inserir(moto1);

	 

	Cliente cli1 = new Cliente(1234, "Z� Carlos");

	locadora.inserir(cli1);

	Date hoje = new Date();

	Date ontem = new Date(hoje.getTime() - 1);

	Date amanha = new Date(hoje.getTime() + 1);

	 

	locadora.registrarAluguel("X-911", hoje, 5, 1234);// Valor do aluguel = 222.6  (moto)

	locadora.registrarDevolucao("X-911");

	 

	assertEquals(222.6, locadora.faturamentoTotal(1, ontem, amanha), 0.01);// Faturamento total de motos

	}

	 

	@Test

	void testeQuantidadeTotalDeDiarias() {

	MinhaLocadora locadora = new MinhaLocadora();

	Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

	locadora.inserir(moto1);

	 

	Cliente cli1 = new Cliente(1234, "Z� Carlos");

	locadora.inserir(cli1);

	 

	Date hoje = new Date();

	Date ontem = new Date(hoje.getTime() - 1);

	Date amanha = new Date(hoje.getTime() + 1);

	 

	locadora.registrarAluguel("X-911", hoje, 5, 1234);// 5 di�rias de moto

	locadora.registrarDevolucao("X-911");

	 

	assertEquals(5, locadora.quantidadeTotalDeDiarias(1, ontem, amanha));// Quantidade de di�rias de moto

	}
}