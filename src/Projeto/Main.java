package Projeto;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Testando TabelaHash
		TabelaHash<String, String> tabelaHash = new TabelaHash<>(10);
		tabelaHash.inserir("Alice", "1234-5678");
		tabelaHash.inserir("Bob", "2345-6789");
		tabelaHash.inserir("Charlie", "3456-7890");
		tabelaHash.inserir("David", "4567-8901");

		System.out.println("Conteúdo da Tabela Hash:");
		tabelaHash.imprimirTabela();
		System.out.println("--------------------------------------------");

		System.out.println("Buscar Números de Telefone:");
		System.out.println("Alice: " + tabelaHash.buscar("Alice"));
		System.out.println("Bob: " + tabelaHash.buscar("Bob"));
		System.out.println("Charlie: " + tabelaHash.buscar("Charlie"));

		tabelaHash.remover("Bob");

		System.out.println("Conteúdo da Tabela Hash após remover Bob:");
		tabelaHash.imprimirTabela();
		System.out.println("Bob: " + tabelaHash.buscar("Bob"));


		
		
		
		Scanner scanner = new Scanner(System.in);
		CacheLRU<String, String> cacheLRU = new CacheLRU<>(3);

		while (true) {
			exibirMenu();

			int escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
			case 1:
				System.out.print("Digite a chave: ");
				String chaveInserir = scanner.nextLine();
				System.out.print("Digite o valor: ");
				String valorInserir = scanner.nextLine();
				cacheLRU.inserir(chaveInserir, valorInserir);
				System.out.println("Chave-valor inseridos no cache.");
				break;
			case 2:
				System.out.print("Digite a chave para buscar: ");
				String chaveBuscar = scanner.nextLine();
				String valor = cacheLRU.buscar(chaveBuscar);
				if (valor != null) {
					System.out.println("Valor encontrado: " + valor);
				} else {
					System.out.println("Chave não encontrada no cache.");
				}
				break;
			case 3:
			    System.out.print("Digite a chave para remover: ");
			    String chaveRemover = scanner.nextLine();
			    cacheLRU.remover(chaveRemover);
			    break;

			case 4:
				System.out.println("\nConteúdo do cache:");
				cacheLRU.imprimirCache();
				break;
			case 5:
				System.out.println("Saindo...");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}

	private static void exibirMenu() {
		System.out.println("\nEscolha uma operação:");
		System.out.println("1. Inserir chave-valor");
		System.out.println("2. Buscar valor por chave");
		System.out.println("3. Remover chave");
		System.out.println("4. Mostrar conteúdo do cache");
		System.out.println("5. Sair");
		System.out.print("Opção: ");
	}
}
