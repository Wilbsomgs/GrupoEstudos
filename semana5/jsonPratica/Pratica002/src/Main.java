import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            JsonReader reader = new JsonReader(new FileReader("C:\\Users\\wills\\Github\\IdeaProjects\\GrupoEstudos\\semana5\\jsonPratica\\Pratica002\\src\\dados.json"));
            Gson gson = new Gson();
            Pessoa pessoa = gson.fromJson(reader, Pessoa.class);

            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
