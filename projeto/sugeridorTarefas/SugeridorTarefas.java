/*
    --- Criar um algoritmo que sugira tarefas com base no tempo disponível do usuário

    1. Solicitar tempo disponível do usuário
    2. Converter para hora totais
    3. Selecionar atividades recomendadas

    -- Faixas de tempo pre definidas
    - 5 minutos: beber água, levantar e alongar, respirar fundo.
    - 10 minutos: ler um artigo curto, revisar anotações, meditar.
    - 20 minutos: assistir a uma videoaula, fazer uma caminhada curta.
    - 45 minutos: estudar um módulo, escrever um texto, resolver exercícios.
    - Mais de 90 minutos:** projeto pessoal, estudo aprofundado, tarefa doméstica longa.
 */

import java.util.Scanner;
public class SugeridorTarefas{


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int time, timeMinutos;


        System.out.println("Quanto tempo disponível você tem?");
        time = input.nextInt();

       timeMinutos = time * 60;

       System.out.println("Tempo em " + timeMinutos + " minutos");

    }
}