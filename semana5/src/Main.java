import com.google.gson.Gson;
import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        menu.menuInical();

                Reader reader = new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/palavrasDicas.json")));
                Gson gson = new Gson();
                Palavras palavra = gson.fromJson(reader, Palavras.class);
                System.out.println(palavra);

        }
}
