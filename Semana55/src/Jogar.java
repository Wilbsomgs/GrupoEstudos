import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class Jogar {
    public void Exibir(){
        try {
            JsonReader reader = new JsonReader(new FileReader("C://Users//wills//Github//IdeaProjects//GrupoEstudos//Semana55//src//palavrasDicas.json"));
            Gson gson = new Gson();
            Palavras palavras = gson.fromJson(reader, Palavras.class);
            System.out.println("Categoria: " + palavras.categoria);
            System.out.println("Resposta:" + palavras.resposta);
        } catch (IOException e){
            System.out.println("Erro não foi possível rodar!"  + e.getMessage());
        }

    }
}
