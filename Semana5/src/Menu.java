import java.util.Scanner;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    Jogar jogar = new Jogar();
    public void menuInical(){


        System.out.println("+-----------------------------+");
        System.out.println("|        QUEM SOU EU?         |");
        System.out.println("+-----------------------------+");
        System.out.println("| 1. Jogar                    |");
        System.out.println("| 2. Ajuda                    |");
        System.out.println("| 3. Ver Leaderboard          |");
        System.out.println("| 4. Sair                     |");
        System.out.println("+-----------------------------+");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        switch (opcao){
            case 1: jogar.jogo();
                break;
            case 2: ajuda();
                break;
            case 3: leaderBoard();
                break;
            case 4: leaveGame();
                break;
            default: System.out.println("Opção inválida, tente novamente.");
                break;
        }
    }

    public void ajuda(){
        System.out.println("+-----------------------------+");
        System.out.println("|            AJUDA            |");
        System.out.println("+-----------------------------+");
        System.out.println("Regras do jogo:");
        System.out.println("- Adivinhe quem é com até 10 dicas.");
        System.out.println("- Cada dica: −10 pts.");
        System.out.println("- Cada minuto -1 pt");
        System.out.println("Digite 'desistir' para encerrar o desafio atual.");
        scanner.nextLine();
        backToMenu();

    }
    public void leaderBoard(){
        System.out.println("+-----------------------------+");
        System.out.println("|         LEADERBOARD         |");
        System.out.println("+-----------------------------+");
        System.out.println("1. José    – 100 pts");
        System.out.println("2. Madu    –  90 pts");
        System.out.println("3. Carol   –  80 pts");
        System.out.println("4. Lucas   –  70 pts");
        System.out.println("5. Will    –  60 pts");
        System.out.println("6. Anna    –  50 pts");
        System.out.println("7. Gustavo –  40 pts");
        System.out.println("8. John    –  30 pts");
        System.out.println("9. Karol     –  20 pts");
        System.out.println("10. Sofia   –  10 pts");
        scanner.nextLine();
        backToMenu();
    }
    public void endGame(String dica, String resposta, int pontuacao){

        pontuacao=0;
        System.out.println("+-----------------------------+");
        System.out.println("|         FIM DE JOGO         |");
        System.out.println("+-----------------------------+");
        System.out.println(dica);
        System.out.println(resposta);
        System.out.println("💀 Fim de jogo!");
        System.out.println("Resposta certa: " + resposta);
        System.out.println("Você usou todas as dicas.");
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Pressione ENTER para voltar para o menu");
    }
    public void leaveGame(){

        System.out.println("+-----------------------------+");
        System.out.println("|        DESEJA SAIR?          |");
        System.out.println("+-----------------------------+");
        System.out.println("Tem certeza que deseja sair?");
        System.out.println("1. Sim");
        System.out.println("2. Não");

        System.out.println("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao){
            case 1: System.exit(0);
            case 2: menuInical();
            default: System.out.println("Opção inválida, tente novamente");
        }

    }
    public void backToMenu(){
        System.out.println("Pressione ENTER para voltar para o menu");
        String enter = scanner.nextLine();

        if(enter.isEmpty()){
            menuInical();
        }
    }
}
