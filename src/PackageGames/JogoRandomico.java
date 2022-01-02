package PackageGames;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class JogoRandomico {

   public static void limparTela() throws IOException, InterruptedException {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
   }

   public static void regrasDoJogo() {
      System.out.println("#====================== JOGO RANDÔMICO ======================#");
      System.out.println("");
      System.out.println("Digite um número de 0 á 10, e tente acertar o número sorteado");
      System.out.println("   Você terá uma barra de vida que possui quatro tentativas");
      System.out.println("        Caso perca as quatro chances, perderá o jogo!");
      System.out.println("");
   }
   
   public static int verificarNumeroSorteado(int valorSorteado, int tentativas, int valorDigitado, Scanner scan) throws Exception {
      do {

         tentativas++;

         switch (tentativas) {
            case 1:
               System.out.println("LIFE: ####");
               System.out.println("");
            break;

            case 2:
               System.out.println("LIFE: ###");
               System.out.println("");
            break;
            
            case 3:
               System.out.println("LIFE: ##");
               System.out.println("");
            break;
            
            case 4:
               System.out.println("LIFE: #");
               System.out.println("");
            break;
            
            default:
               System.out.println("GAME OVER");
               break;
         }

         if (tentativas <= 4) {
            System.out.print("Digite seu palpite: ");
            valorDigitado = scan.nextInt();
            
            if (valorDigitado != valorSorteado) {
               System.out.println("Você errou... Tente novamente.");
               Thread.sleep(2000);
               limparTela();
            }
         } else {
            break;
         }

         
      } while (valorDigitado != valorSorteado);

      return tentativas;
   }

   public static void verificarTentativasDoVencedor(int tentativas, int valorSorteado, Scanner scan) {
      if (tentativas == 1) {
         System.out.println("");
         System.out.println("PARABÉNS, acertou de primeira.");
         System.out.println("Você está com muita sorte hoje.");
      } else if (tentativas <= 4) {
         System.out.println("");
         System.out.println("PARABÉNS, vobê ganhou!");
         System.out.println("O número sorteado foi " + valorSorteado);
         System.out.format("Você gastou %d tentativas.%n", tentativas-1);
      } else {
         System.out.println("");
         System.out.println("Infelismente não foi dessa vez, tente na próxima");
         System.out.println("O número sorteado foi " + valorSorteado);
         System.out.format("Você gastou %d tentativas.%n", tentativas-1);
      }
   }
   
   public static void main(String[] args) throws Exception {
      
      limparTela();
      regrasDoJogo();

      int opcaoParaContinuar;
      Scanner scan = new Scanner(System.in);

      do {
         Random gerador = new Random();
         int valorSorteado = gerador.nextInt(11);
         int tentativas = 0;
         int valorDigitado = 0;

         System.out.println("");
         System.out.println("Deseja jogar?");
         System.out.println("1 - Jogar");
         System.out.println("2 - Sair");
         System.out.print("Opção desejada: ");

         opcaoParaContinuar = scan.nextInt();
         limparTela();
         
         switch (opcaoParaContinuar) {
            case 1:
               tentativas = verificarNumeroSorteado(valorSorteado, tentativas, valorDigitado, scan);
               verificarTentativasDoVencedor(tentativas, valorSorteado, scan);
            continue;
            
            case 2:
               System.out.println("Obrigado por jogar!");
            break;
               
            default:
               System.out.println("Dado inválido, tente novamente!");
            break;
         }
      } while (opcaoParaContinuar != 2);
      
      scan.close();

   }
}
