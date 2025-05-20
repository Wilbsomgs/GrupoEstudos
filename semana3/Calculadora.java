import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        String[] allowedOperation = {"+", "-", "*", "/"};
        String jogarNovamente;

        Scanner scanner = new Scanner(System.in);
        RealizarCalculos calcular = new RealizarCalculos();
       
        do{
            System.out.println("== CALCULADORA BÁSICA ==");
            System.out.print("""
                Digite uma operação!
                adição          +
                subtração       -
                multiplicação   *
                divisão         /
                >>>\s""");

            String operation = scanner.nextLine();

            checkOperation(operation);

            System.out.print("Digite o primeiro número: ");
            double firstNumber = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Digite o segundo número: ");
            double secondNumber = scanner.nextDouble();
            scanner.nextLine();

            if(firstNumber == 0 || secondNumber == 0){
                System.out.println("Digite um número acima de 0");
            }

            switch (operation) {
                case "+":
                    double resultSum = calcular.sum(firstNumber, secondNumber);
                    //result = calcular.math(firstNumber, secondNumber, operation);
                    System.out.println("Resultado: " + firstNumber + " + " + secondNumber + " = " + resultSum);
                    break;
                case "-":
                    double resultSubstraction = calcular.subtract(firstNumber, secondNumber);
                    System.out.println("Resultado: " + firstNumber + " - " + secondNumber + " = " + resultSubstraction);
                    break;
                case "*":
                    double resultMult = calcular.multiply(firstNumber, secondNumber);
                    System.out.println("Resultado: " + firstNumber + " * " + secondNumber + " = " + resultMult);
                    break;
                case "/":
                    divByZeroError(secondNumber);
                    double resultDiv = calcular.divide(firstNumber, secondNumber);
                    System.out.println("Resultado: " + firstNumber + " / " + secondNumber + " = " + resultDiv);
                    break;
                default:
                    System.out.println("Selecione uma operação: ");
            }
            
            //System.out.println("Resultado: " + firstNumber + " " + operation + " " + secondNumber + " = " + result);
            System.out.println("Deseja realizar o cálculo novamente novamente? (s/n)");
            jogarNovamente = scanner.nextLine().toLowerCase();

        }while(jogarNovamente.equals("s"));

        System.out.println("Você encerrou o programa, obrigado utilizar nossa calculadora.");
    }

    public static void divByZeroError(double secondNumber){
        if(secondNumber == 0){
            System.out.println("Erro: divisão por zero não é permitida. Encerrando.");
            System.exit(0);
        }
    }

    public static void checkOperation(String operation){
        boolean operationBoolean = switch (operation) {
            //allowedOperation
            case "+", "-", "*", "/" -> true;
            default -> false;
        };

        if (!operationBoolean) {
            System.out.println("Operação inválida, reinicie o programa");
            System.exit(0);
        }
    }
}