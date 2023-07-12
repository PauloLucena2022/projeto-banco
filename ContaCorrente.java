package At5;

public class ContaCorrente {

	private String numero;
	private double saldo;

	public ContaCorrente(String numConta,double saldoConta)
	{
		numero=numConta;saldo=saldoConta;
	} 	

	public void creditar(double valor)
	{
		saldo=saldo+valor;
	}

	public void debitar(double valor)
	{
		if (saldo >= valor)
		{
			saldo = saldo - valor;
		}
	}

	public double getSaldo()
	{
		return saldo;
	}

	/* M�todo para retornar o N�mero da Conta */
	public String getNumero()
	{
		return numero;
	}

	/*M�todo para atribuir o N�mero da Conta*/

	public void setNumero(String n)
	{
		numero = n;
	}
	/* M�todo para atribuir o Saldo da Conta */
	public void setSaldo(double s)
	{
		saldo = s;
	}
	  
}
