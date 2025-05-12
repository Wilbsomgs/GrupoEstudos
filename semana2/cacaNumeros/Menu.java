public class Menu {
    public void ExibirMenu(){
        System.out.println("-------- Caça Ao número --------");
        System.out.println("Selecione uma opção: ");
        System.out.println("1- Jogar ");
        System.out.println("2- Sair ");
    }

    void ComecarJogo(int opcao){

        switch (opcao){
            case 1:
                System.out.println("Iniciando jogo");
                break;
            case 2:
                System.out.println("Encerrando jogo");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                break;
        }
    }



    
}
