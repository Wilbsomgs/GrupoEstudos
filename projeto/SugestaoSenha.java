
import java.util.Scanner;



public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String novaSenha, senhaMaiuscula, invertida, semVogal, cifrada;
        
        System.out.println("Insira sua nova senha: ");
        novaSenha = scanner.nextLine();
        
        //Senha maiuscula
        senhaMaiuscula = novaSenha.toUpperCase();
        
        //invertida
        invertida = new StringBuilder(novaSenha).reverse().toString(); // Método da classe StringBuilder de manipulação de string que 
        //reverte os caracteres e devolve pra uma string
        
        // Remover vogais
        semVogal = novaSenha.replaceAll("[aeiouAEIOU]", ""); // Método que substitui caracteres por 
        
        System.out.println("Senha original: " + novaSenha);
        System.out.println("Senha maiúscula " + senhaMaiuscula);
        System.out.println("Senha invertida " + invertida);
        System.out.println("Senha maiúscula " + semVogal);
        
        
    }
}