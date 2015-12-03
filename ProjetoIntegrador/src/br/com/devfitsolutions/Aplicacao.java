package br.com.devfitsolutions;

import java.util.*;
import java.util.List;
import java.io.*;

public class Aplicacao {

	 public static void main(String[] args) throws IOException {
	      int op, op2;
	      File arquivo = new File("./src/access.log");
	      List<Acesso> lista = Arquivo.leitor(arquivo);
	      do {
	         op = menu();
	         switch (op) {
	         case 1:
	            if (lista.isEmpty()) {  //VERIRICA SE A LISTA ESTÁ VAZIA
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
	        			estatisticaUser(lista);
	        			break;
	        		case 3:
	        			estatisticaGeral(lista);
	        			break;
	        		}
	        	 }
	         }
	      } while (op != 0);
	      System.out.println("\nObrigado!");
	 }
	 public static int menu() {
		 Scanner entrada = new Scanner(System.in);
		 int opcao;
		 do {
			 System.out.println("\n>>>> MENU <<<<");
			 System.out.println("[1] - Mostrar Log");
			 System.out.println("[2] - Estatisticas");
			 System.out.println("[0] - Sair");
			 System.out.print("Opcao Desejada > ");
			 opcao = entrada.nextInt();
			 if (opcao > 2){
				 System.out.println("\n>>>>>>>Opcao invalida!<<<<<<<");
			 }
		 } while (opcao < 0 || opcao > 2);

		 return opcao;
	 }
	 public static int menu2() {
		 Scanner entrada = new Scanner(System.in);
		 int op;
		 do {
			 System.out.println("\n>>>> MENU ESTATASTICAS <<<<");
			 System.out.println("[1] - Acessos e Media por IP");
			 System.out.println("[2] - Acessos e Media por user");
			 System.out.println("[3] - Media, Mediana e Moda");
			 System.out.println("[0] - Voltar ao menu anterior");
			 System.out.print("Opcao Desejada > ");
			 op = entrada.nextInt();
		 } while (op < 0 || op > 3);

		 return op;
	 }

	 public static void imprimir(List<Acesso> lista) {
		 for (int i = 0; i < lista.size(); i++) {
			 System.out.println(lista.get(i).toString());
		 }
		 System.out.println();
	 }

	 public static void estatisticaIp(List<Acesso> lista){
		 Scanner entrada = new Scanner(System.in);
		 String ip; 
		 int cont = 0, total = 0;
		 float mediaIp, percentualIp;
		 System.out.println("\nInforme o IP > ");
		 ip = entrada.next();

		 for (int i = 0; i < lista.size(); i++) { //ENTRA ENQUANTO O NUMERO DE ELEMENTOS DA LISTA FOR MENOR QUE "i"
			 if(ip.equalsIgnoreCase(lista.get(i).getIp())){  //COMPARA O IP INFORMADO C/ A POSIÇÃO ATUAL DA LISTA E COM O METODO GETIP
				 cont++;
			 }
			 total++;
		 }
		 if(cont == 0){
			 System.out.println("Desculpe! NÃ£o existe esse IP no log!");
		 }
		 else{
			 System.out.println("\n         >>>> RELATARIO POR IP <<<<         ");
			 System.out.println("Acessos do IP " + ip + " : " + cont + " vezes \nTotal de Acessos no Servidor : " + total + " vezes.");
			 mediaIp = (float) ((cont)*(1.0)/(total));
			 percentualIp = (mediaIp)*100;
			 System.out.println("O IP " + ip + " possui media de " + mediaIp + " acessos!");
			 System.out.println("O Percentual de Acessos do IP " + ip + " Ã© de " + percentualIp + " %.\n");
		 }
	 }
	 
//--------INICIA ESTATISTICA DE ACESSO POR USER------
	 
	 public static void estatisticaUser(List<Acesso> lista){
		 Scanner entrada = new Scanner(System.in);
		 String user; 
		 int cont = 0, total = 0;
		 float mediaUser, percentualUser;
		 System.out.println("\nInforme o usuario > ");
		 user = entrada.next();

		 for (int i = 0; i < lista.size(); i++) {
			 if(user.equalsIgnoreCase(lista.get(i).getNome())){
				 cont++;
			 }
			 total++;
		 }
		 if(cont == 0){
			 System.out.println("Desculpe! Este usuario nÃ£o acessou o servidor!");
		 }
		 else{
			 System.out.println("\n         >>>> RELATARIO POR USUARIO <<<<         ");
			 System.out.println("Acessos do usuario " + user + " : " + cont + " vezes \nTotal de Acessos no Servidor : " + total + " vezes.");
			 mediaUser = (float) ((cont)*(1.0)/(total));
			 percentualUser = (mediaUser)*100;
			 System.out.println("O usuario " + user + " possui media de " + mediaUser + " acessos!");
			 System.out.println("O Percentual de Acessos do usuario " + user + " Ã© de " + percentualUser + " %.\n");
		 }
	 }

	 // -------TERMINA REL DE ACESSO POR USER----------

	 public static void estatisticaGeral(List<Acesso> lista){
		 Scanner entrada = new Scanner(System.in);
		 String ip1, ip2 = "", ip3 = "";
		 int cip1 = 0, cip2 = 0, cip3 = 0, total = 0, mediana = 0;
		 float media1, media2, media3;
		 ip1 = lista.get(0).getIp();

		 System.out.println("\n       >>>> RELATARIO GERAL <<<<       ");

		 //PARA CALCULO DA MODA 
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

		 //Mï¿½DIA EM PORCENTAGEM
		 media1 = (float)((cip1)*(1.0)/(total)*100);
		 media2 = (float)((cip2)*(1.0)/(total)*100);
		 media3 = (float)((cip3)*(1.0)/(total)*100);
		 System.out.println("\nA media do IP " + ip1 + " tem percentual de " + media1 + " %.");
		 System.out.println("A media do IP " + ip2 + " tem percentual de " + media2 + " %.");
		 System.out.println("A media do IP " + ip3 + " tem percentual de " + media3 + " %.\n");
		 
	 }
}
