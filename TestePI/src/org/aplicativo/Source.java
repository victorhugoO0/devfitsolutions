package org.aplicativo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.manipulararquivos.Arquivo;
import org.dados.Pessoa;

public class Source {

   public static void main(String[] args) throws IOException {
      int op, op2;
      File arquivo = new File("./src/arquivoLog.txt");
      List<Pessoa> lista = Arquivo.leitor(arquivo);
      do {
         op = menu();
         switch (op) {
         case 1:
            if (lista.isEmpty()) {
               System.out.println("Lista vazia");
            } else {
               imprimir(lista);
            }
            break;
         case 2:
        	 if (lista.isEmpty()) {
        		 System.out.println("Lista vazia");
        	 } else {
        		op2 = menu2();
        		switch(op2){
        		case 1:
        			estatisticaIp(lista);
        			break;
        		case 2:
        			estatisticaGeral(lista);
        			break;
        		}
        	 }
         }
      } while (op != 0);
      /*if (!lista.isEmpty()) {
         Arquivo.escritor(lista, arquivo);
      }*/
      System.out.println("\nObrigado!");
   }

   public static int menu() {
      Scanner entrada = new Scanner(System.in);
      int opcao;
      do {
         System.out.println("\n...::: MENU :::...");
         System.out.println("1 - Mostrar Log");
         System.out.println("2 - Estatisticas");
         System.out.println("0 - Sair");
         System.out.print("Opcao Desejada: ");
         opcao = entrada.nextInt();
      } while (opcao < 0 || opcao > 2);

      return opcao;
   }

   public static int menu2() {
	      Scanner leia = new Scanner(System.in);
	      int op;
	      do {
	         System.out.println("\n...::: MENU ESTATASTICAS :::...");
	         System.out.println("1 - Acessos e Media por IP");
	         System.out.println("2 - Media, Mediana e Moda");
	         System.out.println("0 - Voltar ao menu anterior");
	         System.out.print("Opcao Desejada: ");
	         op = leia.nextInt();
	      } while (op < 0 || op > 2);

	      return op;
	   }

   public static void imprimir(List<Pessoa> lista) {
      for (int i = 0; i < lista.size(); i++) {
         System.out.println(lista.get(i).toString());
      }
      System.out.println();
   }
   
   public static void estatisticaIp(List<Pessoa> lista){
	   Scanner leia = new Scanner(System.in);
	   String ip; 
	   int cont = 0, total = 0;
	   float mediaIp, percentualIp;
	   System.out.println("\nInforme o IP : ");
	   ip = leia.next();
	   
	   for (int i = 0; i < lista.size(); i++) {
		   if(ip.equalsIgnoreCase(lista.get(i).getIp())){
			   cont++;
		   }
		   total++;
	   }
	   if(cont == 0){
		   System.out.println("Desculpe! Não existe esse IP no log!");
	   }
	   else{
		   System.out.println("\n         ...::: RELATARIO POR IP :::...         ");
		   System.out.println("Acessos do IP " + ip + " : " + cont + " vezes \nTotal de Acessos no Servidor : " + total + " vezes.");
		   mediaIp = (float) ((cont)*(1.0)/(total));
		   percentualIp = (mediaIp)*100;
		   System.out.println("O IP " + ip + " possui media de " + mediaIp + " acessos!");
		   System.out.println("O Percentual de Acessos do IP " + ip + " é de " + percentualIp + " %.\n");
	   }
   }
   
   public static void estatisticaGeral(List<Pessoa> lista){
	   Scanner entrada = new Scanner(System.in);
	   String ip1, ip2 = "", ip3 = "", ipm = "";
	   int cip1 = 0, cip2 = 0, cip3 = 0, total = 0, mediana = 0;
	   float media1, media2, media3;
	   ip1 = lista.get(0).getIp();
	   
	   System.out.println("\n       ...::: RELATARIO GERAL :::...       ");
	   
	   //PARA C�LCULO DA MODA 
	   //PEGANDO O SEGUNDO VALOR DE IP DIFERENTE
	   for (int i = 0; i < lista.size(); i++) {
		   if(!(ip1.equalsIgnoreCase(lista.get(i).getIp()))){
			   ip3 = lista.get(i).getIp();
		   }
		   total++;
	   }
	   //PEGANDO O ULTIMO VALOR DE IP DIFERENTE
	   for (int i = 0; i < lista.size(); i++) {
		   if(!(ip1.equalsIgnoreCase(lista.get(i).getIp()))){
			   if(!(ip3.equalsIgnoreCase(lista.get(i).getIp()))){
				   ip2 = lista.get(i).getIp();
			   }
		   }
	   }
	   
	   for (int i = 0; i < lista.size(); i++) {
		   if(ip1.equalsIgnoreCase(lista.get(i).getIp())){
			   cip1++;
		   }
		   if(ip2.equalsIgnoreCase(lista.get(i).getIp())){
			   cip2++;
		   }
		   if(ip3.equalsIgnoreCase(lista.get(i).getIp())){
			   cip3++;
		   }
	   }
	   if((cip1>cip2) && (cip1>cip3)){
		   System.out.println("\nA Moda e o IP " + ip1 + " que se repetiu " + cip1 + " vezes!");
	   }
	   else{
		   if((cip2>cip1) && (cip2>cip3)){
			   System.out.println("A Moda e o IP " + ip2 + " que se repetiu " + cip2 + " vezes!");
		   }
		   else{
			   System.out.println("A Moda e o IP " + ip3 + " que se repetiu " + cip3 + " vezes!");
		   }
	   }
	   //MEDIANA
	   mediana = total/2;
	   System.out.println("\nA mediana e o IP: " + lista.get(mediana).getIp());
	   
	   //M�DIA EM PORCENTAGEM
	   media1 = (float)((cip1)*(1.0)/(total)*100);
	   media2 = (float)((cip2)*(1.0)/(total)*100);
	   media3 = (float)((cip3)*(1.0)/(total)*100);
	   System.out.println("\nA media do IP " + ip1 + " tem percentual de " + media1 + " %.");
	   System.out.println("A media do IP " + ip2 + " tem percentual de " + media2 + " %.");
	   System.out.println("A media do IP " + ip3 + " tem percentual de " + media3 + " %.\n");
   }
}