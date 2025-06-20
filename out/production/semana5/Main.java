import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        menu.menuInical();
        try {
            JsonReader reader = new JsonReader(new FileReader("C:\\Users\\wills\\Github\\IdeaProjects\\GrupoEstudos\\semana5\\src\\palavrasDicas.json"));
            Gson gson = new Gson();
            Palavras palavras = gson.fromJson(reader, Palavras.class);
            System.out.println("Categoria: " + palavras.categoria);
            System.out.println("Resposta:" + palavras.respostas);
        } catch (IOException e){
            System.out.println("Erro não foi possível rodar!"  + e.getMessage());
        }

    }
}
