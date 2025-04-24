/*
    DESAFIO 001
    Criar sugeridor de senhas fortes em Java

    1. importação da classe Scanner
    2. método de criptografia de senha
    3. Solicitar nova senha do usuário
    4. Converter a senha original pra caixa alta
    5. Inverter a senha
    6. Remover as vogais da senha
    7. Cifrar senha
    8. Exibir a senha original e possíveis senha
    9. Encessar programa

 */

import java.util.Scanner;
public class SugerirSenha{
    public static String criptografarSenha(String senha) {
        StringBuilder senhaCifrada = new StringBuilder();

        //Loop para percorrer cada caractere e armazenar no array
        for (char c : senha.toCharArray()) {
            switch (Character.toLowerCase(c)) { // Converte os caracteres armazenados em caixa baixa
                case 'a': senhaCifrada.append('@'); break;
                case 'e': senhaCifrada.append('3'); break;
                case 'i': senhaCifrada.append('1'); break;
                case 'o': senhaCifrada.append('0'); break;
                case 's': senhaCifrada.append('$'); break;
                case 'g': senhaCifrada.append('9'); break;
                case 't': senhaCifrada.append('7'); break;

                // IF simplificado para verificar se o caractere está ou não em caixa alta e o converte em caixa alta
                default: senhaCifrada.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c)); break;
            }
        }

        // Converte em um novo objeto o inverte e retorna em uma string
        return new StringBuilder(senhaCifrada.toString()).reverse().toString();
    }


    public static void main(String[] args){

        // Instanciando o scanner
        Scanner scanner = new Scanner(System.in);

        // Definindo as variáveis
        String novaSenha, senhaMaiuscula, senhaInvertida, senhaCriptografada, senhaSemVogal;

        // Solicitando senha do usuário
        System.out.println("Insira sua nova senha: ");
        novaSenha = scanner.nextLine();

        // Converte a senha digitada para caixa alta
        senhaMaiuscula = novaSenha.toUpperCase();

        // Converte a string pra um objeto inverte os caracteres e retonra uma string
        senhaInvertida = new StringBuilder(novaSenha).reverse().toString();

        // Remove as vogais da senha informada
        senhaSemVogal = novaSenha.replaceAll("[aeiouAEIOU]", "");

        // Senha criptografada
        senhaCriptografada = criptografarSenha(novaSenha);



        // Exibição de senhas
        System.out.println("-------------------------------------");
        System.out.println("Senha original: " + novaSenha);
        System.out.println("Senha maiúscula: " + senhaMaiuscula);
        System.out.println("Senha invertida: " + senhaInvertida );
        System.out.println("Senha sem vogais: " + senhaSemVogal);
        System.out.println("Senha criptografada: " + senhaCriptografada );
        System.out.println("-------------------------------------");
    }
}