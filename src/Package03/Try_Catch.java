package Package03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Try_Catch {
   public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);
      System.out.println("Digite seu nome: ");
      String nome = scan.next();

      try {
         
         System.out.println("Digite sua idade");
         int idade = scan.nextInt();
         System.out.println("Nome: " + nome + ", com a idade de " + idade + " anos");

      } catch (InputMismatchException e) {
         System.out.println("Você digitou o dado incorretamente!!!");
      }

      scan.close();

   }
}
