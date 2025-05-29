import java.util.Random;
import java.util.Scanner;

public class JogoForca {

    public static String menu(){
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        String[] animais = new String[]{"Gato", "Peixe", "Ganso", "Formiga", "Cachorro"};
        String[] frutas = new String[]{"Morango", "Uva", "Banana", "Laranja", "Manga"};
        String[] paises = new String[]{"Brasil", "Portugal", "Argentina", "Venezuela", "Colombia"};

        System.out.println("----------------------------------------------------------");
        System.out.println("Olá, seja bem vindos(as) ao Jogo da forca: ");
        System.out.println("Selecione uma categoria: [1]Animais [2]Frutas [3]Paises");
        System.out.println("-----------------------------------------------------------");

        int opcao = scanner.nextInt();

        String palavraSorteada = null;

        switch (opcao){
            case 1:
                System.out.println("----- ANIMAIS ------");
                palavraSorteada = sortear(animais);
                break;
            case 2:
                System.out.println("------ FRUTAS -------");
                palavraSorteada = sortear(frutas);
                break;
            case 3:
                System.out.println("------ PAISES ---------");
                palavraSorteada = sortear(paises);
                break;
            default:
                System.out.println("Opção inválida, reinicie o programa.");
        }
        return palavraSorteada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String randomWord = menu();

        String censoredWord = converterCharacteres(randomWord);

        int attempts = 6;

        do {
            System.out.println("Digite uma letra: ");
            char chute = scanner.next().charAt(0);

            if(randomWord.contains(String.valueOf(chute))){
                System.out.println("Letra correta!");
                censoredWord = verificarCaracteres(randomWord, censoredWord, chute);

            } else {
                System.out.println("Letra incorreta");

                System.out.println(censoredWord);
                System.out.println("Tentativas restantes: " + attempts);
                attempts--;
            }
        } while(attempts !=0);

    }

    public static String verificarCaracteres(String palavraSorteada, String palavraMascarada, char chute){
        char[] arrayPalavraSortaeada = palavraSorteada.toCharArray();

        String resultado = "".trim();
        System.out.println("Resultado: " + resultado );
        return resultado;
    }

    public static String sortear(String[] palavra){
        Random random = new Random();

        int indice = random.nextInt(palavra.length);

        return palavra[indice];
    }

    public static String converterCharacteres(String palavra){
        int qntCaracteres = palavra.length();

        String censoredWord = "_".repeat(qntCaracteres);
        System.out.println( censoredWord + qntCaracteres + " " + " letras");

        return censoredWord;
    }
}


