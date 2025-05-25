import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {
    public static void main(String[] args) {
        SelecionarCategoria selecionarCategoria = new SelecionarCategoria();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, seja bem vindos(as) ao Jogo da forca: ");
        String palavraSorteada = selecionarCategoria.selecionarCategoria();

        String palavraMascarada = selecionarCategoria.converterCharacteres(palavraSorteada);

        String chute;
        int tentativas = 6;

        for(int i = 0; i <= tentativas; i++) {
            System.out.println("Digite uma letra: ");
            chute = scanner.next();



            if(palavraSorteada.contains(chute)){


            }else {
                System.out.println("Letra incorreta");
                tentativas--;

                System.out.println("Tentativas restantes: " + tentativas);
            }

        }

    }

    public static void verificarCaracteres(String palavra, String caracter){

    }
}
