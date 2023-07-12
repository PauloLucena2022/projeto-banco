package At5;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

	// Declarar o array dinamico
	public static ArrayList clientes = new ArrayList ();

	public static void main(String[] args) {

		// Declarar variáveis
		String numConta;
		double saldo;
		int escolha;
		int tipoDeConta;
		
		Scanner input = new Scanner(System.in);

		for (;;) {

			System.out.println("Agradedemos por escolher nosso Banco !!!");

			System.out.println();

			System.out.println("Abaixo estao as opcoes do que fazer no sistema:");
			System.out.println("1 - Adiciona uma conta.");
			System.out.println("2 - Obtem uma conta.");
			System.out.println("3 - Remove uma conta.");
			System.out.println("4 - Exibe todas as contas.");
			System.out.println("5 - Sacar");
			System.out.println("6 - Depositar");
			System.out.println("7 - Sai da operacao.");

			System.out.println("Qual a sua escolha? ");
			escolha = input.nextInt();

			if (escolha == 7) {
				System.out.println("Obrigado pela preferencia !!!");
				break;
			}

			else if(escolha == 1) {
				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
				
				System.out.println("Qual o tipo da conta? ");
				System.out.println("1 - Conta Poupanca;");
				System.out.println("2 - Conta Especial;");
				System.out.println("3 - Conta Corrente.");
				System.out.print("Escolha: ");
				tipoDeConta = input.nextInt();
				
				System.out.println("------------------------------------------");
				
				System.out.println("Digite o numero da conta: ");
				numConta = input.next();

				System.out.println("Digite o saldo da conta: ");
				saldo = input.nextDouble();
				
				ContaCorrente conta;
				
				if (tipoDeConta == 1)
					conta = new ContaPoupanca(numConta,saldo);
				else if (tipoDeConta == 2)
					conta = new ContaEspecial(numConta,saldo);
				else
					conta = new ContaCorrente (numConta, saldo);

				adicionarConta(conta);

				System.out.println();

				System.out.println("Conta registrada com sucesso !!!");

				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
			}

			else if(escolha == 2) {
				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");

				System.out.println("Digite o numero da conta que deseja obter: ");
				numConta = input.next();

				System.out.println(obterConta(numConta));

				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
			}

			else if(escolha == 3) {
				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");

				System.out.println("Digite o numero da conta a ser removida");
				numConta = input.next();

				ContaCorrente c = obterConta(numConta);

				removerConta(c);

				System.out.println();

				System.out.println("Contato removido !!!");

				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");

			}

			else if (escolha == 4) {
				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");

				exibirContas();

				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
			}

			else if(escolha == 5) {
				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");

				double valor;

				System.out.println("Digite o numero da conta: ");
				numConta = input.next();

				ContaCorrente c = obterConta(numConta);

				System.out.println("Digite a quantia que deseja sacar: ");
				valor = input.nextDouble();

				c.debitar(valor);

				System.out.println();

				System.out.println("Valor sacado !!!");

				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
			}

			else if(escolha == 6) {
				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");

				double valor;

				System.out.println("Digite o numero da conta: ");
				numConta = input.next();

				ContaCorrente c = obterConta(numConta);

				System.out.println("Digite a quantia que deseja depositar: ");
				valor = input.nextDouble();

				c.creditar(valor);

				System.out.println();

				System.out.println("Valor depositado !!!");

				System.out.println("-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-");
			}

		}

	}
	//------------------------------------------------------------------------------------------------
	private static void adicionarConta(ContaCorrente c) {
		clientes.add(c);
	}

	//------------------------------------------------------------------------------------------------
	private static ContaCorrente obterConta(String numConta) {
		int local = 0;
		ContaCorrente erro = new ContaCorrente("0",0);

		int i;

		for (i = 0; i < clientes.size(); i++) {
			if (((ContaCorrente)clientes.get(i)).getNumero().equals(numConta)) {
				local = i;
				break;
			}

		}

		if (i == clientes.size()) {
			System.out.println("Conta nao encontrada");
			return erro;
		}

		else {
			System.out.println();
			
			System.out.println("Numero da conta: " + ((ContaCorrente) clientes.get(local)).getNumero());
			System.out.println("Saldo da conta: " + ((ContaCorrente) clientes.get(local)).getSaldo());
			
			if (clientes.get(i) instanceof ContaPoupanca) {
				System.out.print("Rendimento da conta: ");
				((ContaPoupanca) clientes.get(i)).renderJuros();
				System.out.println("Tipo de Conta: Conta Poupanca.");
			}
			
			else if (clientes.get(i) instanceof ContaEspecial) {
				System.out.println("Limite de credito disponivel: " + ((ContaEspecial) clientes.get(i)).getLimite());
				System.out.println("Tipo de Conta: Conta Especial.");
			}
			
			else
				System.out.println("Tipo de Conta: Conta Corrente");

			System.out.println();

			System.out.println("Conta obtida !!!");
			
			System.out.println("-------------------------------------------------");

			return (ContaCorrente) clientes.get(local);
		}

	}
	//------------------------------------------------------------------------------------------------
	private static void removerConta(ContaCorrente c) {

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) == c) {
				clientes.remove(i);
				break;
			}
		}
	}
	//------------------------------------------------------------------------------------------------
	private static void exibirContas() {
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println("--------------------------------------------");
			
			System.out.println("Conta " + (i + 1) + ": ");
			System.out.println("Numero da conta: " + ((ContaCorrente) clientes.get(i)).getNumero());
			System.out.println("Saldo da conta: " + ((ContaCorrente) clientes.get(i)).getSaldo());
			
			if (clientes.get(i) instanceof ContaPoupanca) {
				System.out.print("Rendimento da conta: ");
				((ContaPoupanca) clientes.get(i)).renderJuros();
				System.out.println("Tipo de Conta: Conta Poupanca.");
			}
			
			else if (clientes.get(i) instanceof ContaEspecial) {
				System.out.println("Limite de credito disponivel: " + ((ContaEspecial) clientes.get(i)).getLimite());
				System.out.println("Tipo de Conta: Conta Especial.");
			}
			
			else
				System.out.println("Tipo de Conta: Conta Corrente");
			
			
			System.out.println("--------------------------------------------");

		}
	}
	//------------------------------------------------------------------------------------------------

}
