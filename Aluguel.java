package victorRibeiroDaSilva;
import java.util.Date;

public class Aluguel {
	private Veiculo Veiculo;
	private int cpf;
	private int dias;
	private double valor;
	private Date inicio;
	private Date fim;
	
	
	public Veiculo getVeiculo() {
		return Veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		Veiculo = veiculo;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	
	
	
	
	

}
