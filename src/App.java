import java.io.IOException;

import Package01.Pessoa;

public class App {

   public static void limparTela() throws IOException, InterruptedException {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
   }

   public static void main(String[] args) throws Exception {

      limparTela();

      System.out.println("-----------------------------");

      Pessoa pessoaGenilson = new Pessoa("Genilson", 20);
      pessoaGenilson.setSalario(400);
      pessoaGenilson.mostrarDados();

      System.out.println("-----------------------------");

      Pessoa pessoaGermano = new Pessoa("Germano", 16);
      pessoaGermano.setSalario(100);
      pessoaGermano.mostrarDados();

      System.out.println("-----------------------------");

      Pessoa pessoaSemNome = new Pessoa();
      pessoaSemNome.mostrarDados();

      System.out.println("-----------------------------");

   }
}
