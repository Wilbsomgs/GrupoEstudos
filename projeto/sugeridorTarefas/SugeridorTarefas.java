/*
    --- Criar um algoritmo que sugira tarefas com base no tempo disponível do usuário

    1. Solicitar tempo disponível do usuário
    2. Converter para hora totais
    3. Selecionar atividades recomendadas

    -- Faixas de tempo pré-definidas
    - 5 minutos: beber água, levantar e alongar, respirar fundo.
    - 10 minutos: ler um artigo curto, revisar anotações, meditar.
    - 20 minutos: assistir a uma videoaula, fazer uma caminhada curta.
    - 45 minutos: estudar um módulo, escrever um texto, resolver exercícios.
    - Mais de 90 minutos:** projeto pessoal, estudo aprofundado, tarefa doméstica longa.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SugeridorTarefas{


    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Tempo disponível: ");
      String time = scanner.nextLine().toLowerCase();

      Pattern horasPattern = Pattern.compile("(\\d+)\\s*(h|hora|horas)");
      Pattern minutosPattern = Pattern.compile("(\\d+)//s*(m|min|minuto|minutos)");

      Matcher horasMatcher = horasPattern.matcher(time);
      Matcher minutosMatcher = minutosPattern.matcher(time);

      int totalMinutos = 0;
      if(horasMatcher.find()){
          int horas = Integer.parseInt(horasMatcher.group(1));
          totalMinutos += horas *60;
      }
      if (minutosMatcher.find()){
          int minutos = Integer.parseInt(minutosMatcher.group(1));
          totalMinutos  += minutos;
      }
      if (totalMinutos==0){
          try {
              totalMinutos = Integer.parseInt(time.replaceAll("[^0-9]", ""));
          } catch (NumberFormatException e){
              System.out.println("Entrada inválida.");
              return;
          }
      }

      System.out.println("Você informou: " + totalMinutos + "minutos disponíveis");
    }
}