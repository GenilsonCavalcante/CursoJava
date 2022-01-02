package Package01;

public class Pessoa {
   public String nome;
   public int idade;
   private double salario;

   // Construtor Default
   public Pessoa() {
      this.nome = "Sem Nome";
      this.idade = 0;
      this.salario = 0;
   }

   // Construtor para informações iniciais
   public Pessoa(String nome, int idade) {
      this.nome = nome;
      this.idade = idade;
   }

   public void mostrarDados() {
      System.out.printf("%s tem %d anos de idade, seu salário é de %.2f reais.\n", this.nome, this.idade, this.salario);
   }

   public double getSalario() {
      return salario;
   }

   public void setSalario(double salario) {
      this.salario = salario;
   }

}
