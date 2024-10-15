import java.util.Random;
import java.util.Scanner;

public class JogoDaAdivinhacao {
    public static void main(String[] args) {
        int numeroAleatorio = new Random().nextInt(100);
        Scanner leitura = new Scanner(System.in);
        int chute = 0;
        int i = 0;
        int j = 0;
        int tentativas = 0;
        String dificuldade;

        while (i < 1) {
            System.out.println("Em qual dificuldade você deseja jogar? (Easy, Medium ou Hard)");
            dificuldade = leitura.nextLine();
            switch (dificuldade.toLowerCase()) {
                case "easy":
                    tentativas = 10;
                    i++;
                    break;
                case "medium":
                    tentativas = 7;
                    i++;
                    break;
                case "hard":
                    tentativas = 5;
                    i++;
                    break;
                default:
                    System.out.println("Dificuldade inválida. Tente novamente.");
            }
        }

        while (j < tentativas) {
            int tentativasRestantes = tentativas - j;
            System.out.println(String.format("Digite um número de 0 a 100. Você tem %d tentativas restantes", tentativasRestantes));
            chute = leitura.nextInt();
            if (chute == numeroAleatorio) {
                System.out.println("Parabéns! Você acertou o número secreto!");
                break;
            } else if (chute < numeroAleatorio && tentativasRestantes > 1) {
                System.out.println("Você errou. Tente um número maior");
            } else if (chute > numeroAleatorio && tentativasRestantes > 1) {
                System.out.println("Você errou. Tente um número menor");
            } else if (chute != numeroAleatorio && tentativasRestantes == 1) {
                System.out.println(String.format("GAME OVER - O número secreto era: %d", numeroAleatorio));
            }
            j++;
        }
    }
}