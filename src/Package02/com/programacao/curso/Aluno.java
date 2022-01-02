package Package02.com.programacao.curso;

public class Aluno {
   public String nome;
   public int idade;
   public int numMatricula;
   private int cpf;

   public Aluno(String nome, int idade) {
      this.nome = nome;
      this.idade = idade;
   }

   public void matricular() {
      System.out.printf("%s está Matriculado!\n", this.nome);
      
   }

   public void dadosDoAluno() {
      System.out.printf("Dados do Aluno: " + this.nome + " tem " + this.idade + " com a matricula " + this.numMatricula + " e CPF do n° " + this.cpf + "\n");
   }

   public int getCpf() {
      return cpf;
   }
   public void setCpf(int cpf) {
      this.cpf = cpf;
   }

   
}
