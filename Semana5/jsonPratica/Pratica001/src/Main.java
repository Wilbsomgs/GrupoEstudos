import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        FileReader reader = new FileReader("C:\\Users\\wills\\Github\\IdeaProjects\\GrupoEstudos\\semana5\\jsonPratica\\Pratica001\\src\\produto.json");

        Type tipoLista = new TypeToken<List<Produto>>(){}.getType();
        List<Produto> produtos = gson.fromJson(reader, tipoLista);

        for (Produto p : produtos) {
            System.out.println("Produto: " + p.nome + " | Preço: R$" + p.preco);
        }
    }
}
