import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Persistencia p = new Persistencia();
		
		CentralDeInformacoes central = p.recuperarCentral();
		
		while (true) {
			System.out.println("=".repeat(40));
			System.out.print("""
					[ 1 ] - Novo jogador
					[ 2 ] - Listar todos os jogadores
					[ 3 ] - Exibir as informações de um jogador 
					[ 4 ] - Salvar palavras a partir de um arquivo CSV
					[ 5 ] - Listar todas as palavras
					[ 6 ] - Relatório em PDF
					[ 7 ] - Enviar email à todos os jogadores
					[ "S" ] - Sair
					>>> """);
			String choice = input.nextLine().trim().toUpperCase();
			
			if (choice.equals("1")) {
				System.out.println("=".repeat(40));
				
				System.out.print("Digite o seu nome: ");
				String nome = input.nextLine();
				System.out.print("Digite o seu email: ");
				String email = input.nextLine();
				System.out.print("Digite o seu sexo: ");
				Sexo sexo = Sexo.valueOf(input.nextLine().trim().toUpperCase());
				System.out.print("Digite o seu CPF: ");
				String cpf = input.nextLine();
				
				boolean deuCerto = central.addJogador(new Jogador(nome, email, sexo, cpf));
				p.salvarCentral(central);
				
				System.out.println(deuCerto ? "O jogador foi adicionado com sucesso!" : "O jogador já foi cadastrado!");
			} else if (choice.equals("2")) {
				System.out.println("=".repeat(40));
				
				ArrayList<Jogador> jogadores = central.getTodosJogadores();
				
				System.out.printf("""
						%s LISTA ATUAL DE JOGADORES %s %n""", "=".repeat(7), "=".repeat(7));
				
				for (Jogador j: jogadores) {
					System.out.printf("%s%n", j.getNome());
				}
			} else if (choice.equals("3")) {
				System.out.println("=".repeat(40));

				while(true) {
					System.out.print("""
							[ 1 ] - Pesquisar por CPF
							[ 2 ] - Pesquisar por email 
							[ "S" ] - Voltar pro menu Principal
							>>> """);
					String choiceReadJogador = input.nextLine().trim().toUpperCase();
					
					if (choiceReadJogador.equals("1")) {
						System.out.print("Informe o CPF do jogador que deseja buscar: ");
						String cpfBusca = input.nextLine().trim();
						Jogador j = central.readCPF(cpfBusca);
						System.out.println(j != null ? j.toString() : "O jogador não foi encontrado!");
					} else if (choiceReadJogador.equals("2")) {
						System.out.print("Informe o email do jogador que deseja buscar: ");
						String emailBusca = input.nextLine().trim();
						Jogador j = central.readEmail(emailBusca);
						System.out.println(j != null ? j.toString() : "O jogador não foi encontrado!");
					} else if (choiceReadJogador.equals("S")){
						break;
					} else {
						System.out.println("OPÇÃO INVÁLIDA!");
					}
				}
			} else if (choice.equals("4")) {
				System.out.println("=".repeat(40));
				
				System.out.print("Digite o nome do arquivo CSV que você deseja ler: ");
				String csvNome = input.nextLine().trim();
				
				ArrayList<Palavra> palavras = ExtratorPalavrasCSV.extrairPalavras(csvNome);
				
				while (palavras == null) {
					System.out.print("""
							O nome do arquivo que você informou não foi encontrado!
							Digite NOVAMENTE o nome do arquivo CSV que você deseja ler: """);
					csvNome = input.nextLine().trim();
					palavras = ExtratorPalavrasCSV.extrairPalavras(csvNome);
				}
				
				for (Palavra palavra: palavras) {
					central.addPalavra(palavra);
				}
				
				System.out.println("Palavras salvas com sucesso!");
			} else if (choice.equals("5")) {
				System.out.println("=".repeat(40));
				
				ArrayList<Palavra> palavras = central.getPalavras();
				
				System.out.printf("""
						%s LISTA ATUAL DE PALAVRAS %s %n""", "=".repeat(7), "=".repeat(7));
				
				for (Palavra palavra: palavras) {
					System.out.printf("%s%n", palavra.toString());
				}
			} else if (choice.equals("6")) {
				System.out.println("=".repeat(40));
				
				GeradorDeRelatorios.gerarRelatorio(central);
			} else if (choice.equals("7")) {
				System.out.println("=".repeat(40));
				
			} else if (choice.equals("S")) {
				System.out.println("=".repeat(40));

				System.out.println("Até mais!");
				break;
			} else {
				System.out.println("=".repeat(40));

				System.out.println("OPÇÃO INVÁLIDA!");
			}
		}
		
		input.close();
	}
}
