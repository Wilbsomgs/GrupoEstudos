import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
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
        try {
            FileReader reader = new FileReader("C:\\Users\\wills\\Github\\IdeaProjects\\GrupoEstudos\\Semana5\\src\\palavrasDicas.json");
            Gson gson = new Gson();
            Map<String, Palavras> mapa = gson.fromJson(reader, new TypeToken<Map<String, Palavras>>() {
            }.getType());


            String objetoSorteado = sortearObjeto();

            Palavras p2 = mapa.get(objetoSorteado);

            boolean sair = false;
            String resposta = null;
            int totalDicas = 11;
            int contagemDicas = 0;
            int pontuacao = 100;

            ArrayList<String> dicasValue = new ArrayList<>();

            for (Map.Entry<String, String> entry : p2.dicas.entrySet()) {
                dicasValue.add(entry.getValue());
            }

            resposta = String.valueOf(p2.resposta);

            do {
                System.out.println("""
                        +-----------------------------+
                        |        NOVO DESAFIO         |
                        +-----------------------------+
                        """);

                System.out.println("Categoria: " + p2.categoria);

                for(int i = 0; i < totalDicas; i++){
                    System.out.println("Pressione ENTER para mostrar a dica "  +(i +1)+ ".");

                    System.out.println("+-----------------------------+");
                    System.out.println("|           DICA "  + (i + 1) + "            |");
                    System.out.println("+-----------------------------+");

                    String dica = dicasValue.get(i);
                    System.out.println(dica);

                    System.out.println("Digite a sua resposta ou pressione ENTER para próxima.");
                    String palpite = scanner.nextLine().toLowerCase();

                    contagemDicas++;

                    if(palpite.equals(resposta)){
                        System.out.println("Correto!");
                        System.out.println(resposta);

                        System.out.println("Dicas usadas: " + contagemDicas);
                        System.out.println("Pontuação: " + pontuacao);

                        menu.backToMenu();
                    } else {
                        System.out.println("Resposta incorreta.");
                        System.out.println("Ou digite desistir para sair.");
                        palpite = scanner.nextLine();

                        if(palpite.equals("desistir")){
                            sair = true;
                            menu.menuInical();
                        }
                    }

                    if(contagemDicas==11){
                        menu.endGame(dica,resposta,palpite,pontuacao);

                    }
                }
            } while (!sair);

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

