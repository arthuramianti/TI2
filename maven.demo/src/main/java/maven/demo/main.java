package maven.demo;

import java.util.*;

public class main {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[])
	{
		DAO dao = new DAO();
		dao.conectar();
		
		int opcao;
		int identificador;
		String nome;
		String cor;
		char tamanho;
		
		System.out.println("Bem vindo ao nosso sistema de cadastro!");
		System.out.println("Por favor escolha a opção desejada (1 - Listar produtos, 2 - Inserir produto, 3 - Atualizar produto, 4 - Excluir produto):");
		opcao = scan.nextInt();
		
		switch (opcao) {
		case 1:
			Product[] prods = dao.getProducts();
			System.out.println("Segue a lista dos produtos -> ");
			System.out.println("\n");
			for (int i = 0; i < prods.length; i++) {
				prods[i].productToString();
			}
			main(args);
			
			break;
		case 2:
			System.out.println("Insira em sequencia, o identificador numeral do produto, nome, cor e tamanho, respectivamente");
			System.out.println("Identificador: ");
			identificador = scan.nextInt();
			System.out.println("Nome do Produto: ");
			nome = scan.next();
			System.out.println("Cor do Produto: ");
			cor = scan.next();
			System.out.println("Tamanho do Produto (P, M, G): ");
			tamanho = scan.next().charAt(0);
			
			Product prod = new Product(identificador, nome, cor, tamanho);
			boolean response = dao.insertProduct(prod);
			
			if (response == true) {
				System.out.println("Produto inserido com sucesso -> " + prod.getProdName());
				main(args);
			} else {
				System.out.println("Produto não pode ser inserido, tente novamente!");
				main(args);
			}
			
			break;
		case 3:
			System.out.println("Você está na tela de edição de dados, por favor insira os dados a serem alterados");
			
			Product[] prodsToUpdate = dao.getProducts();
			System.out.println("Segue a lista dos produtos -> ");
			for (int i = 0; i < prodsToUpdate.length; i++) {
				prodsToUpdate[i].productToString();
			}
			
			System.out.println("Escreva o id do produto que será alterado -> ");
			identificador = scan.nextInt();
			System.out.println("Nome do Produto: ");
			nome = scan.next();
			System.out.println("Cor do Produto: ");
			cor = scan.next();
			System.out.println("Tamanho do Produto (P, M, G): ");
			tamanho = scan.next().charAt(0);
			Product prodChosen = new Product(identificador, nome, cor, tamanho);
			boolean hasBeenUpdated = dao.updateProduct(prodChosen);
			
			if (hasBeenUpdated == true) {
				System.out.println("Produto alterado com sucesso -> " + prodChosen.getProdName());
				main(args);
			} else {
				System.out.println("Produto não pode ser atualizado, tente novamente!");
				main(args);
			}
			
			break;
		case 4:
			System.out.println("Você está na tela de exclusão de conteudo.");
			
			Product[] prodsToDelete = dao.getProducts();
			System.out.println("Segue a lista dos produtos -> ");
			for (int i = 0; i < prodsToDelete.length; i++) {
				prodsToDelete[i].productToString();
			}
			
			System.out.println("Escreva o id do produto que será excluído -> ");
			identificador = scan.nextInt();
			
			boolean hasBeenDeleted = dao.deleteProduct(identificador);
			
			if (hasBeenDeleted == true) {
				System.out.println("Produto excluído com sucesso");
				main(args);
			} else {
				System.out.println("Produto não pode ser excluído, tente novamente!");
				main(args);
			}
			
			break;
		}
	}
	
	
}
