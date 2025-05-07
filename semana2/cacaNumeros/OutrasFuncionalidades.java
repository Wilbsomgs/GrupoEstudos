import java.util.Random;

public class OutrasFuncionalidades {
    public void MaiorMenor(int userNumber, int secretNumber){

    if(userNumber < secretNumber){
        System.out.println("O seu palpite é menor que o número aleatório.");
    }
    else if(userNumber > secretNumber){
        System.out.println("O seu palpite é maior que o número aleatório.");
    } else {
        System.out.println("Parabéns você acertou o número secreto!!");

    }
 }
    public void EncerrarPrograma(String opcao){
        if(opcao.equals("n")){
            System.out.println("Saindo...");
            System.exit(0);
        }
    }

    public int numeroAleatorio(){
        Random random = new Random();

        return random.nextInt(100) + 1;
    }
}
