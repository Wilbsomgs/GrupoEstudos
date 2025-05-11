import java.util.Random;

public class NumeroAleatorio {
    public int GerarNumeroAleatorio(){
        Random random = new Random();

        return random.nextInt(100) + 1;
    }
}

