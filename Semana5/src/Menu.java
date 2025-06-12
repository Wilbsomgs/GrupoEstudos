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
            case 1: jogar.Exibir();
            case 2: ajuda();
            case 3: leaderBoard();
            case 4: leaveGame();
            default: System.out.println("Opção inválida, tente novamente.");
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
    public void endGame(){

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
        System.out.println("Pressione ENTER para voltar");
        String enter = scanner.nextLine();

        if(enter.isEmpty()){
            menuInical();
        }
    }
}
