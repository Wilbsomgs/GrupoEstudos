public class VerificacaoResposta {
    public void Verificador(int userNumber, int secretNumber) {
        if (userNumber < secretNumber) {
            System.out.println("O seu palpite é menor que o número aleatório.");
        } else if (userNumber > secretNumber) {
            System.out.println("O seu palpite é maior que o número aleatório.");
        } else {
            System.out.println("Parabéns você acertou o número secreto!!");

        }
    }
}

