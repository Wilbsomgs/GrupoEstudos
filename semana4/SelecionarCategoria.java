
import java.util.Random;
import java.util.Scanner;

public class SelecionarCategoria {
    public  String selecionarCategoria(){


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] animais = new String[]{"Gato", "Peixe", "Ganso", "Formiga", "Cachorro"};
        String[] frutas = new String[]{"Morango", "Uva", "Banana", "Laranja", "Manga"};
        String[] paises = new String[]{"Brasil", "Portugal", "Argentina", "Venezuela", "Colombia"};


        String opcao;

        System.out.println("Selecione a categoria");
        opcao = scanner.nextLine();

        String palavraSorteada = null;

        switch (opcao){
            case "animais":
                palavraSorteada = sortear(animais);
                break;
            case "frutas":
                palavraSorteada = sortear(frutas);
                break;
            case "paises":
                palavraSorteada = sortear(paises);
                break;
            default:
                System.out.println("Opção inválida, reinicie o programa.");
        }
        return palavraSorteada;
    }

    public String sortear(String[] palavra){
        Random random = new Random();

        int indice = random.nextInt(palavra.length);

        return palavra[indice];
    }

    public String converterCharacteres(String palavra){
        int qntCaracteres = palavra.length();

        String palavraMascarada = "_".repeat(qntCaracteres);
        System.out.println( palavraMascarada + qntCaracteres + " letras");

        return palavraMascarada;
    }
}
