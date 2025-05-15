import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculos calcular = new Calculos();
        String[] allowedOperation = {"+", "-", "*", "/"};

        System.out.println("== CALCULADORA BÁSICA ==");
        System.out.print("""
                Digite uma operação!
                adição          +
                subtração       -
                multiplicação   *
                divisão         /
                >>>\s""");

        String operation = scanner.nextLine();

        /*if (!operation) {
            System.out.println("Operação inválida, reinicie o programa");
            return;
        }/*/



        System.out.print("Digite o primeiro número: ");
        double firstNumber = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o primeiro número: ");
        double secondNumber = scanner.nextDouble();
        scanner.nextLine();

        switch (operation){
            case "+":
                double resultSum = calcular.Soma(firstNumber,secondNumber);
                System.out.println("Resultado: " + firstNumber + " + " + secondNumber + " = " + resultSum);
                break;
            case "-":
                double resultSubstraction = calcular.Subtrair(firstNumber,secondNumber);
                System.out.println("Resultado: " + firstNumber + " - " + secondNumber + " = " + resultSubstraction);
                break;
            case "*":
                double resultMult = calcular.Multiplicar(firstNumber,secondNumber);
                System.out.println("Resultado: " + firstNumber + " * " + secondNumber + " = " + resultMult);
                break;
            case "/":
                double resultDiv = calcular.Dividir(firstNumber,secondNumber);
                System.out.println("Resultado: " + firstNumber + " / " + secondNumber + " = " + resultDiv);
                break;
        }

    }
}