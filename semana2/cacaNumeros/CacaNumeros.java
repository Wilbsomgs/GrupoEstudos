/*
1 - Gerar número aleatório
2 - Jogador dá palpite
3 - Sistema informa se é maior ou menor
4 - Contagem de pontos
5 - Sistema armazena os palpites em array
6 - A cada jogada jogador escolhe se continua jogando ou não
7 - Sistema informa quais foram os palpites

 */

import java.util.Scanner;
import java.util.Random;

public class CacaNumeros {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Random random = new Random();

       int secretNumber, userNumber, pontuacao, opcao;

       int[] palpites = new int[10];

       secretNumber = random.nextInt(100) + 1;

       // Menu
        System.out.println("-------- Caça Ao número --------");
        System.out.println("Selecione uma opção: ");
        System.out.println("1- Jogar ");
        System.out.println("2- Sair ");
        opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Iniciando jogo");
                break;
            case 2:
                System.out.println("Encerrando jogo");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                break;
        }

        System.out.println("\nVocê X Máquina\n");
        System.out.println("O computador irá gerar um número aleatório e você deverá adivinhar qual número foi gerado.");
        System.out.println("Topa o desafio? Bem o jogo começou!\n");

        for(int i=1; i< palpites.length; i++){
           pontuacao = 0;

           System.out.println("Qual seu palpite? ");
           userNumber = scanner.nextInt();
           scanner.nextLine();

           palpites[i] = userNumber;

           if(userNumber < secretNumber){
               System.out.println("O seu palpite é menor que o número aleatório.");
           }
           else if(userNumber > secretNumber){
               System.out.println("O seu palpite é maior que o número aleatório.");
           } else {
               System.out.println("Parabéns você acertou o número secreto!!");
               pontuacao++;
           }

           System.out.println("Você deseja continuar jogando? s/n");
           String jogarNovamente = scanner.nextLine();
           jogarNovamente = jogarNovamente.toLowerCase();

           if (jogarNovamente.equals("n")) {
               System.out.println("Saindo...");
               break;
           }

       }

       for(int i =0; i< palpites.length; i++){
           System.out.println("Palpites " +i + palpites[i]);
       }

       System.out.println("O número secreto foi: " + secretNumber);
    }
}