import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int pontuacaoTotal = 0;
        String jogarNovamente;

        do {
            int pontuacaoRodada = 0;

            System.out.println("-------------- GUESS THE NUMBER -------------");
            System.out.println("Bem-vindo ao joguinho Guess the Number.");
            System.out.println("1 - Jogar");
            System.out.println("2 - Ver pontuação total");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                // Inicia jogo
                for (int tentativas = 1; tentativas <= 5; tentativas++) {
                    int numero1 = random.nextInt(100) + 1;
                    System.out.println("\nRodada " + tentativas);
                    System.out.println("Número atual: " + numero1);
                    System.out.print("O próximo número será 'maior' ou 'menor'? ");
                    String resposta = scanner.next().toLowerCase();

                    int numero2 = random.nextInt(100) + 1;
                    System.out.println("Próximo número: " + numero2);

                    if (resposta.equals("maior") && numero2 > numero1) {
                        System.out.println("Você acertou!");
                        pontuacaoRodada++;
                    } else if (resposta.equals("menor") && numero2 < numero1) {
                        System.out.println("Você acertou!");
                        pontuacaoRodada++;
                    } else if (resposta.equals("maior") || resposta.equals("menor")) {
                        System.out.println("Você errou!");
                    } else {
                        System.out.println("Resposta inválida. Tente novamente.");
                        tentativas--; // não conta essa tentativa
                    }
                }

                pontuacaoTotal += pontuacaoRodada;
                System.out.println("Pontuação nesta rodada: " + pontuacaoRodada);
            }
            else if (opcao == 2) {
                System.out.println("Pontuação total acumulada: " + pontuacaoTotal);
            }
            else if (opcao == 3) {
                System.out.println("Saindo do jogo...");
                break;
            }
            else {
                System.out.println("Opção inválida.");
            }

            System.out.print("\nDeseja jogar novamente? (s/n): ");
            jogarNovamente = scanner.next().toLowerCase();

        } while (jogarNovamente.equals("s"));

        System.out.println("Obrigado por jogar! Pontuação final: " + pontuacaoTotal);
        scanner.close();
    }
}
