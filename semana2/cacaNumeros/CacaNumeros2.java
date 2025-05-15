
import java.util.Scanner;
import java.util.Random;

public class CacaNumeros2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        VerificacaoResposta verificacao = new VerificacaoResposta();
        NumeroAleatorio numeroAleatorio = new NumeroAleatorio();
        EncerrarPrograma encerrarPrograma = new EncerrarPrograma();
        Menu menu = new Menu();

        menu.ExibirMenu();


        int secretNumber, userNumber, points, option;

        int[] palpites = new int[10];

        String opcaoJogarNovamente;

        option = scanner.nextInt();

        menu.ComecarJogo(option);
        

        System.out.println("\nVocê VS Máquina\n");
        System.out.println("O computador irá gerar um número aleatório e você deverá adivinhar qual número foi gerado.\n");


        secretNumber = numeroAleatorio.GerarNumeroAleatorio();


        for(int i=1; i< palpites.length; i++){
            points = 0;

            System.out.println("Qual seu palpite? ");
            userNumber = scanner.nextInt();
            scanner.nextLine();

            palpites[i] = userNumber;

            verificacao.Verificador(userNumber,secretNumber);


            System.out.println("Você deseja continuar jogando? S/N");
            opcaoJogarNovamente = scanner.nextLine();
            opcaoJogarNovamente = opcaoJogarNovamente.toLowerCase();

            encerrarPrograma.EncerrarPrograma(opcaoJogarNovamente);
        }

        for(int i =0; i< palpites.length; i++){
            System.out.println("Palpites " +i + palpites[i]);
        }

        System.out.println("O número secreto foi: " + secretNumber);
    }
}