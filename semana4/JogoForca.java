import java.util.Random;
import java.util.Scanner;

public class JogoForca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String chosenWord = showMenu(scanner);

        if (chosenWord == null) {
            System.out.println("Opção inválida. Encerrando o jogo.");
            return;
        }

        String maskedWord = maskWord(chosenWord);
        int attempts = 6;

        while (attempts > 0) {
            System.out.println("\nPalavra: " + maskedWord);
            System.out.println("Tentativas restantes: " + attempts);
            System.out.print("Digite uma letra: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Você precisa digitar uma letra.");
                continue;
            }

            char guess = input.charAt(0);

            if (chosenWord.toLowerCase().contains(String.valueOf(guess).toLowerCase())) {
                System.out.println("Letra correta!");
                maskedWord = revealLetters(chosenWord, maskedWord, guess);
            } else {
                System.out.println("Letra incorreta!");
                attempts--;
            }

            if (!maskedWord.contains("_")) {
                System.out.println("\nParabéns! Você acertou a palavra: " + chosenWord);
                return;
            }
        }

        System.out.println("\nVocê perdeu! A palavra era: " + chosenWord);
    }

    public static String showMenu(Scanner scanner) {
        String[] animals = {"Gato", "Peixe", "Ganso", "Formiga", "Cachorro"};
        String[] fruits = {"Morango", "Uva", "Banana", "Laranja", "Manga"};
        String[] countries = {"Brasil", "Portugal", "Argentina", "Venezuela", "Colombia"};

        System.out.println("----------------------------------------------------------");
        System.out.println("Olá, seja bem-vindo(a) ao Jogo da Forca!");
        System.out.println("Selecione uma categoria: [1] Animais [2] Frutas [3] Países");
        System.out.println("----------------------------------------------------------");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Categoria: ANIMAIS");
                return getRandomWord(animals);
            case "2":
                System.out.println("Categoria: FRUTAS");
                return getRandomWord(fruits);
            case "3":
                System.out.println("Categoria: PAÍSES");
                return getRandomWord(countries);
            default:
                return null;
        }
    }

    public static String getRandomWord(String[] words) {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }

    public static String maskWord(String word) {
        String masked = "_".repeat(word.length());
        System.out.println("A palavra tem " + word.length() + " letras.");
        return masked;
    }

    public static String revealLetters(String originalWord, String currentMasked, char guess) {
        char[] updatedMasked = currentMasked.toCharArray();

        for (int i = 0; i < originalWord.length(); i++) {
            if (Character.toLowerCase(originalWord.charAt(i)) == Character.toLowerCase(guess)) {
                updatedMasked[i] = originalWord.charAt(i);
            }
        }

        return new String(updatedMasked);
    }
}
