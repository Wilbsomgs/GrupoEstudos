import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        menu.menuInical();



                Gson gson = new Gson();
                Palavras palavra = gson.fromJson(new FileReader("C:\\Users\\wills\\Github\\IdeaProjects\\GrupoEstudos\\semana5\\src\\palavrasDicas.json"), Palavras.class);
                System.out.println(palavra);

        }
}
