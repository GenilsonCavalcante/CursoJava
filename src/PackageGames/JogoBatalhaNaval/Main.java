package PackageGames.JogoBatalhaNaval;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {

   static int tamanhoX, tamanhoY, quantidadeDeNavios, limiteMaximoDeNavios;
   static int tabuleiroJogador1[][], tabuleiroJogador2[][];
   
   public static void limparTela() throws IOException, InterruptedException {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
   }

   public static void obterTamanhoDosTabuleiros() {

      boolean prosseguir = true;
      do {
         try {

            Scanner input = new Scanner(System.in);
            System.out.println("Digite a altura do tabuleiro: ");
            tamanhoX = input.nextInt();
      
            System.out.println("Digite o comprimento do tabuleiro: ");
            tamanhoY = input.nextInt();

            prosseguir = false;
         
         } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("Você digitou incorretamente!!!");
            System.out.println("Digite um valor numérico.");
            System.out.println("");
         }
         
      } while (prosseguir == true);
   }
   
   public static void calcularTamanhoMaximoDosNaviosNoJogo() {
      limiteMaximoDeNavios = (tamanhoX * tamanhoY) / 3;//1/3 do tabuleiro;
   }
   
   public static int[][] retornarNovoTabuleiroVazio() {
      return new int[tamanhoX][tamanhoY];
   }
   
   public static void iniciandoTamanhoDosTabuleiros() {
      tabuleiroJogador1 = retornarNovoTabuleiroVazio();
      tabuleiroJogador2 = retornarNovoTabuleiroVazio();
   }

   public static void obterQuantidadeDeNaviosNoJogo() {
      
      boolean prosseguir = true;
      do {
         try {

            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out.println("Digite a quantidade de navios no jogo");
            System.out.println("Máximo de " + limiteMaximoDeNavios + " navios.");
            quantidadeDeNavios = input.nextInt();
   
            if (quantidadeDeNavios < 1 || quantidadeDeNavios > limiteMaximoDeNavios) {
               System.out.println("");
               System.out.println("O limite máximo de navios era para ser "+ limiteMaximoDeNavios);
               System.out.println("Como você quebrou uma das regras do jogo, nós passamos então a colocar "+ limiteMaximoDeNavios + " navios.");
               System.out.println("");
               quantidadeDeNavios = limiteMaximoDeNavios; 
            }
            
            prosseguir = false;

         } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("Você digitou incorretamente!!!");
            System.out.println("Digite um valor numérico.");
            System.out.println("");
         }
         
      } while(prosseguir == true);
   }

   public static int[][] retornarNovoTabuleiroComOsNavios() {
      
      int novoTabuleiro[][] = retornarNovoTabuleiroVazio();
      int quantidadeRestanteDeNavios = quantidadeDeNavios;
      int x = 0, y = 0;
      Random numeroAleatorio = new Random();
      
      do {
         x = 0;
         y = 0;
         for(int[] linha : novoTabuleiro) {
            for (int coluna : linha) {
               if (numeroAleatorio.nextInt(100) <= 10) {
                  if (coluna == 0) {
                     novoTabuleiro[x][y] = 1;
                     quantidadeRestanteDeNavios--;
                     break;
                  }
                  if (quantidadeRestanteDeNavios == 0) {
                     break;
                  }
               }
               y++;
            }
            y = 0;
            x++;
            if (quantidadeRestanteDeNavios == 0) {
               break;
            }
         }

      } while (quantidadeRestanteDeNavios > 0);

      return novoTabuleiro;
   }

   public static void inserirOsNaviosNosTabuleirosDosJogadores() {
      tabuleiroJogador1 = retornarNovoTabuleiroComOsNavios();
      tabuleiroJogador2 = retornarNovoTabuleiroComOsNavios();
   }

   public static void exibirLetrasDasColunasDoTabuleiro() {
      char letraDaColuna = 65;
      String letrasDoTabuleiro = "    ";

      for(int i = 0; i < tamanhoY; i++) {
         letrasDoTabuleiro += (letraDaColuna++) + " ";
      }
      System.out.println(letrasDoTabuleiro);
   }

   public static void exibirTabuleiro() {
      System.out.println("***JOGADOR1***");
      int numeroDaLinha = 1;
      boolean seuTabuleiro = true;
      exibirLetrasDasColunasDoTabuleiro();
      String linhaDoTabuleiro = "";

      for(int[] linha : tabuleiroJogador1) {
         if (numeroDaLinha < 10) {
            linhaDoTabuleiro = (numeroDaLinha++) + "  |";
         } else if (numeroDaLinha < 100) {
            linhaDoTabuleiro = (numeroDaLinha++) + " |";
         } else {
            linhaDoTabuleiro = (numeroDaLinha++) + "|";
         }

         for (int coluna : linha) {
            switch (coluna) {
               case 0: //Vazio ou Sem Ação
                  linhaDoTabuleiro += " |";
                  break;

               case 1: //Navio
                  if (seuTabuleiro) {
                     linhaDoTabuleiro += "N|";
                     break;
                  } else {
                     linhaDoTabuleiro += " |";
                     break;
                  }

               case 2: //Erro
                  linhaDoTabuleiro += "X|";
                  break;

               case 3: //Acertou
                  linhaDoTabuleiro += "D|";
                  break;

            
               default:
                  break;
            }
         }
         System.out.println(linhaDoTabuleiro);
      }
   }
   
   public static void main(String[] args) throws IOException, InterruptedException {
      /***TABULEIROS
       1 - Jogador
       2 - Computador / Outro jogador
       */
      
      limparTela();
      
      obterTamanhoDosTabuleiros();
      calcularTamanhoMaximoDosNaviosNoJogo();
      iniciandoTamanhoDosTabuleiros();
      obterQuantidadeDeNaviosNoJogo();
      inserirOsNaviosNosTabuleirosDosJogadores();
      exibirTabuleiro();

      // input.close();
      
   }
}
