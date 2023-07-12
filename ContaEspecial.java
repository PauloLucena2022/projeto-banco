package At5;

public class ContaEspecial extends ContaCorrente{

	private double LIMITE_CREDITO = 1000;
	
	public ContaEspecial(String n, double s) {
		super(n, s);
	}
	
	public void debitar (double valor) {
		if (valor >= super.getSaldo() + LIMITE_CREDITO)
			System.out.println("Saldo insuficiente !!! ");
		else
			if (super.getSaldo() != 0) {
				super.setSaldo(super.getSaldo() - valor);
			}
			
			else {
				LIMITE_CREDITO = LIMITE_CREDITO - valor;
			}
	}
	
	public double getLimite() {
		return LIMITE_CREDITO;
	}
	
	

}
