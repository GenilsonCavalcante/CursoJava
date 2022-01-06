package PackageGames.JogoBatalhaNaval;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {

   /*
   TABULEIRO
   0 - VAZIO
   1 - NAVIO
   2 - ERRO
   3 - ACERTOU
   */

   static final int VAZIO = 0;
   static final int NAVIO = 1;
   static final int ERROU_TIRO = 2;
   static final int ACERTOU_TIRO = 3;

   static final int POSICAO_X = 0;
   static final int POSICAO_Y = 1;

   static String nomeJogador1, nomeJogador2;
   static int tamanhoX, tamanhoY, quantidadeDeNavios, limiteMaximoDeNavios;
   static int tabuleiroJogador1[][], tabuleiroJogador2[][];
   static int naviosJogador1, naviosJogador2;
   
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

   public static void obterNomesDosJogadores() {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Digite o nome do Jogador 1: ");
      nomeJogador1 = input.next();

      System.out.println("Digite o nome do Jogador 2: ");
      nomeJogador2 = input.next();

      while (nomeJogador1.equals(nomeJogador2)) {
         System.out.println("");
         System.out.println("O nome do Jogador 2, não pode ser o mesmo de Jogador 1");
         System.out.println("Digite um CodeNome para Jogador 2:");
         nomeJogador2 = input.next();
      }
      
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

   public static void instanciarContadoresDeNaviosDosJogadores() {
      naviosJogador1 = quantidadeDeNavios;
      naviosJogador2 = quantidadeDeNavios;
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
                  if (coluna == VAZIO) {
                     novoTabuleiro[x][y] = NAVIO;
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

   public static void exibirNumerosDasColunasDosTabuleiros() {
      int numeroDaColuna = 1;
      String numerosDoTabuleiro = "    ";

      for(int i = 0; i < tamanhoY; i++) {
         numerosDoTabuleiro += (numeroDaColuna++) + " ";
      }
      System.out.println(numerosDoTabuleiro);
   }

   public static void exibirTabuleiro(String nomeDoJogador, int[][] tabuleiro, boolean seuTabuleiro) {
      System.out.println("*** "+ nomeDoJogador +" ***");
      exibirNumerosDasColunasDosTabuleiros();
      String linhaDoTabuleiro = "";
      char letraDaLinha = 65;

      for(int[] linha : tabuleiro) {
         linhaDoTabuleiro = (letraDaLinha++) + "  |";

         for (int coluna : linha) {
            switch (coluna) {
               case VAZIO:
                  linhaDoTabuleiro += " |";
                  break;

               case NAVIO:
                  if (seuTabuleiro) {
                     linhaDoTabuleiro += "N|";
                     break;
                  } else {
                     linhaDoTabuleiro += " |";
                     break;
                  }

               case ERROU_TIRO:
                  linhaDoTabuleiro += "X|";
                  break;

               case ACERTOU_TIRO:
                  linhaDoTabuleiro += "D|";
                  break;
            }
         }
         System.out.println(linhaDoTabuleiro);
      }
   }
   
   public static void exibirTabuleiroDosJogadores() {
      exibirTabuleiro(nomeJogador1, tabuleiroJogador1, true);
      System.out.println("");
      exibirTabuleiro(nomeJogador2, tabuleiroJogador2, false);
   }
   
   public static boolean validarPosicoesInseridasPeloJogador(int[] posicoes) {
      boolean retorno = true;
      if (posicoes[0] > tamanhoX -1) {
         retorno = false;
         System.out.println("A posição das letras não podem ser maior que " + (char) (tamanhoX + 64));
      }
      if (posicoes[1] > tamanhoY -1) {
         retorno = false;
         System.out.println("A posição numérica não podem ser maior que " + tamanhoY);
      }
      
      return retorno;
   }
   
   public static String receberValorDigitadoPeloJogador() {
      Scanner input = new Scanner(System.in);
      System.out.println("Digite a posição do seu tiro:");
      return input.next();
   }
   
   public static boolean validarTiroDoJogador(String tiroDoJogador) {
      int quantidadeDeNumeros = (tamanhoY >= 10) ? 2 : 1;
      String expressaoDeVerificacao = "^[A-Za-z]{1}[0-9]{"+quantidadeDeNumeros+"}$";
      
      return tiroDoJogador.matches(expressaoDeVerificacao);
   }
   
   public static int[] retornarPosicoesDigitadasPeloJogador(String tiroDoJogador) {
      String tiro = tiroDoJogador.toLowerCase();
      int[] retorno = new int[2];
      retorno[POSICAO_X] = tiro.charAt(0) - 97;
      retorno[POSICAO_Y] = Integer.parseInt(tiro.substring(1)) -1;
      return retorno;
   }

   public static void inserirValoresDaAcaoNoTabuleiro(int[] posicoes, int numeroDoJogador) {
      if(numeroDoJogador == 1) {
         if (tabuleiroJogador2[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] == NAVIO) {
            tabuleiroJogador2[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ACERTOU_TIRO;
            naviosJogador2--;
            System.out.println("Você acertou um navio!!!");
         } else {
            tabuleiroJogador2[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ERROU_TIRO;
            System.out.println("Você errou o tiro!");
         }
      } else {
         if (tabuleiroJogador1[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] == NAVIO) {
            tabuleiroJogador1[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ACERTOU_TIRO;
            naviosJogador1--;
            System.out.println("Você acertou um navio!!!");
         } else {
            tabuleiroJogador1[posicoes[POSICAO_X]][posicoes[POSICAO_Y]] = ERROU_TIRO;
            System.out.println("Você errou o tiro!");
         }
      }
   }
   
   public static boolean acaoDoJogador() {
      
      boolean acaoValida = true;
      String tiroDoJogador = receberValorDigitadoPeloJogador();
      if(validarTiroDoJogador(tiroDoJogador)) {
         int[] posicoes = retornarPosicoesDigitadasPeloJogador(tiroDoJogador);
         if(validarPosicoesInseridasPeloJogador(posicoes)) {  
            inserirValoresDaAcaoNoTabuleiro(posicoes, 1);
         } else {
            acaoValida = false;
         }

      } else {
         System.out.println("Posição Inválida");
         acaoValida = false;
      }

      return acaoValida;
   }

   public static void acaoDoComputador() {
      int[] posicoes = retornarJogadaDoComputador();
      inserirValoresDaAcaoNoTabuleiro(posicoes, 2);
   }
   
   public static int[] retornarJogadaDoComputador() {
      int[] posicoes = new int[2];
      posicoes[POSICAO_X] = retornarJogadaAleatoriaDoComputador(tamanhoX);
      posicoes[POSICAO_Y] = retornarJogadaAleatoriaDoComputador(tamanhoY);
      return posicoes;
   }

   public static int retornarJogadaAleatoriaDoComputador(int limite) {
      Random jogadaDoComputador = new Random();
      int numeroGerado = jogadaDoComputador.nextInt(limite);
      return (numeroGerado == limite) ? --numeroGerado : numeroGerado;
   }
   
   public static void main(String[] args) throws IOException, InterruptedException {
      /***TABULEIROS
       1 - Jogador
       2 - Computador / Outro jogador
       */
      
      limparTela();
      
      obterNomesDosJogadores();
      obterTamanhoDosTabuleiros();
      calcularTamanhoMaximoDosNaviosNoJogo();
      iniciandoTamanhoDosTabuleiros();
      obterQuantidadeDeNaviosNoJogo();
      instanciarContadoresDeNaviosDosJogadores();
      inserirOsNaviosNosTabuleirosDosJogadores();
      
      boolean jogoAtivo = true;
      do {
         exibirTabuleiroDosJogadores();
         if (acaoDoJogador()) {
            if(naviosJogador2 <= 0) {
               System.out.println("***" + nomeJogador1 + "*** Venceu o Jogo!!!");
               break;
            }
            acaoDoComputador();
            if(naviosJogador1 <= 0) {
               System.out.println("***" + nomeJogador2 + "*** Venceu o Jogo!!!");
               break;
            }
         }
      } while (jogoAtivo);
      exibirTabuleiroDosJogadores();
      
   }
}
