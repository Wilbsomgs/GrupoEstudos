
import java.util.Scanner;
import java.util.Random;

public class CacaAoNumero2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        OutrasFuncionalidades numeroMaiorMenor = new OutrasFuncionalidades();
        int secretNumber, userNumber, pontuacao, opcao;

        int[] palpites = new int[10];
        String opcaoJogarNovamente;

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

        secretNumber = numeroMaiorMenor.numeroAleatorio();
        System.out.println("numeroAleatorio" + secretNumber);

        for(int i=1; i< palpites.length; i++){
            pontuacao = 0;

            System.out.println("Qual seu palpite? ");
            userNumber = scanner.nextInt();
            scanner.nextLine();

            palpites[i] = userNumber;

            numeroMaiorMenor.MaiorMenor(userNumber,secretNumber);


            System.out.println("Você deseja continuar jogando? S/N");
            opcaoJogarNovamente = scanner.nextLine();
            opcaoJogarNovamente = opcaoJogarNovamente.toLowerCase();

            numeroMaiorMenor.EncerrarPrograma(opcaoJogarNovamente);

        }

        for(int i =0; i< palpites.length; i++){
            System.out.println("Palpites " +i + palpites[i]);
        }

        System.out.println("O número secreto foi: " + secretNumber);
    }
}