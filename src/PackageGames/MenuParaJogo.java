package PackageGames;

import java.io.IOException;
import java.util.Scanner;

public class MenuParaJogo {

   public static void limparTela() throws IOException, InterruptedException {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
   }

   public static void main(String[] args) throws Exception {
      
      int opcaoEscolhida;
      Scanner scan = new Scanner(System.in);

      do {
         limparTela();
         System.out.println("1 - Jogar");
         System.out.println("2 - Sair");
         System.out.println("Opção desejada: ");

         opcaoEscolhida = scan.nextInt();

         switch (opcaoEscolhida) {
            case 1:
               System.out.println("Jogando...");
               Thread.sleep(2000);
               System.out.println("Acabou o jogo!");
               Thread.sleep(1000);
               break;
               
               case 2:
               System.out.println("Saindo...");
               Thread.sleep(1000);
               break;
               
               default:
               System.out.println("Dado inválido, tente novamente!");
               Thread.sleep(2000);
               break;
         }
      } while (opcaoEscolhida != 2);

      scan.close();
      System.out.println("Saiu!");

   }
}
