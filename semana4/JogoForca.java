import java.util.Scanner;

public class JogoForca {
    public static void main(String[] args) {
        SelecionarCategoria selecionarCategoria = new SelecionarCategoria();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, seja bem vindos(as) ao Jogo da forca: ");
        String palavraSorteada = selecionarCategoria.selecionarCategoria();

        String palavraMascarada = selecionarCategoria.converterCharacteres(palavraSorteada);


        int tentativas = 6;



        do {
            System.out.println("Digite uma letra: ");
            char chute = scanner.next().charAt(0);

            if(palavraSorteada.contains(String.valueOf(chute))){
                System.out.println("Letra correta!");
                palavraMascarada = verificarCaracteres(palavraSorteada, palavraMascarada, chute);

            } else {
                System.out.println("Letra incorreta");

                System.out.println(palavraMascarada);
                System.out.println("Tentativas restantes: " + tentativas);
                tentativas--;
            }
        } while(tentativas!=0);

    }

    public static String verificarCaracteres(String palavraSorteada, String palavraMascarada, char chute){
        char[] arrayPalavraSortaeada = palavraSorteada.toCharArray();
        char[] arrayPalavraMascarada = palavraMascarada.replace(" ", "").toCharArray();

        for (int i = 0; i < arrayPalavraSortaeada.length; i++) {
            if (arrayPalavraSortaeada[i] == chute) {
                arrayPalavraMascarada[i] = chute;
            }
        }

        StringBuilder novaOculta = new StringBuilder();
        for (char c : arrayPalavraMascarada) {
              novaOculta.append(c).append(" ");
        }


        String resultado = novaOculta.toString().trim();
        System.out.println("Resultado: " + resultado );
        return resultado;
    }
}
