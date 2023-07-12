package At5;

public class ContaPoupanca extends ContaCorrente{

	private double TAXA_JUROS = 0.01;
	
	public ContaPoupanca(String n, double s) {
		super(n,s);
	}
	
	public void renderJuros() {
		double rendimento;
		
		rendimento = TAXA_JUROS * super.getSaldo();
		System.out.println("R$" + rendimento);
	}
}
