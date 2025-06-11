import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;
public class LeitorAnimais {
   public static void main(String[] args){
       try {
           JsonReader reader = new JsonReader(new FileReader("C:/Users/wills/Github/IdeaProjects/GrupoEstudos/semana5/jsonPratica/Pratica003/src/animais.json"));
           Gson gson = new Gson();
           Animais animais = gson.fromJson(reader,Animais.class);

           System.out.println("animal: " +  animais.animal);
           System.out.println("Tipo: " + animais.tipo);
           System.out.println("Nome: " + animais.nome);
           System.out.println("Quantidade: " + animais.quantidade);

       }catch (IOException e) {
           System.out.println("Erro:"  + e.getMessage());
       }
   }

}
