package Package03;

import java.io.IOException;

public class Metodos {

   public static void limparTela() throws IOException, InterruptedException {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
   }

   public static int[] obterVetorInvertido(int[] vetor) {
      int[] vetorInvertido = new int[vetor.length];
      int contador = 0;

      for (int i = vetor.length -1; i >= 0; i--) {
         vetorInvertido[contador] =+ vetor[i];
         contador++;
      }
      return vetorInvertido;
   }

   public static void mostrarVetor(int[] vetor) {
      for (int valor : vetor) {
         System.out.print(valor + ", ");
      }
   }
   
   public static void main(String[] args) throws Exception {

      limparTela();

      int[] vetorOriginal = {13, 25, 43, 78, 33};
      int[] vetorInvertido = obterVetorInvertido(vetorOriginal);

      mostrarVetor(vetorInvertido);



      //Chamada para método SEM parâmetro!!!
      // limparTela();
      // double res = obterMediaVetor();
      // System.out.println(res);


      //Chamada para método COM parâmetro!!!
      // limparTela();
      // System.out.println("++++++VETOR 1++++++");
      // int[] vetor1 = {13, 25, 43, 78, 33};
      // double res = obterMediaVetor(vetor1);
      // System.out.println(res);

      // System.out.println("++++++VETOR 2++++++");
      // int[] vetor2 = {17, 32, 38, 89, 36};
      // double res2 = obterMediaVetor(vetor2);
      // System.out.println(res2);
      //DECLARANDO-SE MÉTODOS POR MEIO DE PARÂMETROS, PODEMOS FAZER COM QUE APLIQUEMOS ESSE MÉTODO VÁRIAS VEZES, COM DIFERENTES VALORES.

      //OBS: GERALMENTE, NOMES DE MÉTODOS PODEM SER VERBOS, QUE INDICAM AÇÃO.
      //OBS: UMA OUTRA BOA PRÁTICA É NA CRIAÇÃO DE MÉTODOS QUE TENHAM COMO FINALIDADE EXECUTAR APENAS UMA AÇÃO, POIS ASSIM ELE SE TORNA MAIS FÁCIL DE LER E FAZER COM QUE ELE TENHA APENAS ESSA RESPONSABILIDADE QUE O SEU NOME A DEFINA CLARAMENTE. ISSO AUMENTA BASTANTE O GRAU DE REUSO DESSE MÉTODO.

   }

   //Método que retorna um array - SEM parâmetro de entrada!!!;
   // public static double obterMediaVetor() {
   //    int[] vetor1 = {13, 25, 43, 78, 33};
   //    int somaVetor1 = 0;
   //    for(int i = 0; i < vetor1.length; i++) {
   //       somaVetor1 += vetor1[i];
   //    }

   //    double resultado = (float)somaVetor1/vetor1.length;
   //    return resultado;
   // }

   //Método que retorna um array - COM parâmetro de entrada!!!;
   // public static double obterMediaVetor(int[] vetor) {
      
   //    int somaVetor1 = 0;
   //    for(int i = 0; i < vetor.length; i++) {
   //       somaVetor1 += vetor[i];
   //    }

   //    double resultado = (float)somaVetor1/vetor.length;
   //    return resultado;
   // }
}
