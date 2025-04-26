import java.util.*;

public class SugeridorTarefas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mapa com tempo (minutos) e lista de tarefas
        HashMap<Integer, List<String>> atividades = new HashMap<>();
        atividades.put(90, Arrays.asList("Projeto pessoal", "Estudo aprofundado", "Tarefa doméstica longa"));
        atividades.put(45, Arrays.asList("Estudar um módulo", "Escrever um texto", "Resolver exercícios"));
        atividades.put(20, Arrays.asList("Assistir a uma videoaula", "Fazer uma caminhada curta"));
        atividades.put(10, Arrays.asList("Ler um artigo curto", "Revisar anotações", "Meditar"));
        atividades.put(5, Arrays.asList("Beber água", "Levantar e alongar", "Respirar fundo"));

        // Entrada do usuário
        System.out.print("Quanto tempo você tem disponível (em minutos)? ");
        int tempoDisponivel = scanner.nextInt();
        int tempoRestante = tempoDisponivel;

        System.out.println("\nVocê tem " + tempoDisponivel + " minutos. Sugestões:");

        // Organiza as chaves em ordem decrescente
        List<Integer> tempos = new ArrayList<>(atividades.keySet());
        Collections.sort(tempos, Collections.reverseOrder());

        // Escolhe sugestões
        for (int tempo : tempos) {
            if (tempoRestante >= tempo) {
                String sugestao = atividades.get(tempo).get(0); // Pega a primeira da lista
                System.out.println("✅ " + sugestao + " (" + tempo + " min)");
                tempoRestante -= tempo;
            }
        }

        System.out.println("⏳ Tempo restante: " + tempoRestante + " min");
        scanner.close();
    }
}
