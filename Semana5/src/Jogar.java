import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Jogar {

    public static class Palavras {
        public String categoria;
        public String resposta;
        public Map<String, String> dicas;
    }

    public void jogo() {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        try{
            FileReader reader = new FileReader("C:\\Users\\wills\\Github\\IdeaProjects\\GrupoEstudos\\Semana5\\src\\palavrasDicas.json");
            Gson gson = new Gson();
            Map<String, Palavras> mapa = gson.fromJson(reader, new TypeToken<Map<String, Palavras>>() {}.getType());


            String objetoSorteado = sortearObjeto();


            Palavras p2 = mapa.get(objetoSorteado);

            menu.newChallenge();

            System.out.println("Categoria: " + p2.categoria);
            System.out.println("Pressione ENTER para mostrar a dica 1.");
            String palpite = scanner.nextLine();

            if(palpite.isEmpty()){
                return;
            } else {
                System.out.println("opção inválida! tente novamente.");
            }

            String dica1 = p2.dicas.get("dica1");
            System.out.println(dica1);

        } catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        }
        public static String sortearObjeto(){
            Random random = new Random();

            String[] sorteioObjeto = {"objeto1","objeto2","objeto3","objeto4","objeto5"};

            int indiceSorteado = random.nextInt(sorteioObjeto.length);

            return sorteioObjeto[indiceSorteado];
        }
    }

