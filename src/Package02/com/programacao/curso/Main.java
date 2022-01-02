package Package02.com.programacao.curso;

import java.io.IOException;

public class Main {

   public static void limparTela() throws IOException, InterruptedException {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
   }

   public static void main(String[] args) throws Exception {

      limparTela();

      Aluno genilson = new Aluno("Genilson Cavalcante", 20);
      genilson.matricular();
      genilson.dadosDoAluno();

      System.out.println("-----------------------------");

      Aluno germano = new Aluno("Germano Cavalcante", 16);
      germano.matricular();
      germano.dadosDoAluno();

   }
}
