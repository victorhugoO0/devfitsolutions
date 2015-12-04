package br.com.devfitsolutions;

import java.util.*;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

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
	            if (lista.isEmpty()) {  //VERIRICA SE A LISTA EST� VAZIA
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
	      System.out.println("\nObrigado!");
	 }
	 public static int menu() {
		 Scanner entrada = new Scanner(System.in);
		 int opcao;
		 do {
			 System.out.println("\n>>>>>>> MENU <<<<<<<");
			 System.out.println("\n[1] - Mostrar Log");
			 System.out.println("[2] - Estatísticas");
			 System.out.println("[0] - Sair");
			 System.out.print("Opcao Desejada > ");
			 opcao = entrada.nextInt();
			 if (opcao > 2){
				 System.out.println("\n>>>>>> Opção invalida! <<<<<<");
			 }
		 } while (opcao < 0 || opcao > 2);

		 return opcao;
	 }
	 public static int menu2() {
		 Scanner entrada = new Scanner(System.in);
		 int op;
		 do {
			 System.out.println("\n>>>>>>> MENU ESTATÍSTICAS <<<<<<<");
			 System.out.println("\n[1] - Acessos e Média por IP");
			 System.out.println("[2] - Média, Mediana e Moda");
			 System.out.println("[0] - Voltar ao menu anterior");
			 System.out.print("Opção Desejada > ");
			 op = entrada.nextInt();
		 } while (op < 0 || op > 2);

		 return op;
	 }
	 //MOSTRA O ARQUIVO DE LOG COMPLETO
	 public static void imprimir(List<Acesso> lista) {
		 System.out.println("\n>>>>>>>>>>>>>>>>>>>>> ARQUIVO DE LOG <<<<<<<<<<<<<<<<<<<<\n");
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
			 if(ip.equalsIgnoreCase(lista.get(i).getIp())){  //COMPARA O IP INFORMADO C/ A POSIÇAO ATUAL DA LISTA E COM O METODO GETIP
				 cont++;
			 }
			 total++;
		 }
		 if(cont == 0){
			 System.out.println("Desculpe! Não existe esse IP no log!");
		 }
		 else{
			 System.out.println("\n>>>>>>>>>>>>>>>>>> RELATÓRIO POR IP <<<<<<<<<<<<<<<<<<");
			 System.out.println("\nAcessos do IP " + ip + ": " + cont + " vezes. \nTotal de Acessos no Servidor: " + total + " vezes.");
			 mediaIp = (float) ((cont)*(1.0)/(total));
			 percentualIp = (mediaIp)*100;
			 System.out.println("O IP " + ip + " possui média de " + mediaIp + " acessos!");
			 //System.out.println("O Percentual de Acessos do IP " + ip + " é de " + percentualIp + " %.\n");
			 System.out.printf("O Percentual de acessos do IP %s é de %.2f", ip, percentualIp);
			 System.out.println("%.");
		 }
	 }

	 public static void estatisticaGeral(List<Acesso> lista){
		 Scanner entrada = new Scanner(System.in);
		 String ip1, ip2 = "", ip3 = "";
		 int qtdIp1 = 0, qtdIp2 = 0, qtdIp3 = 0, total = 0, mediana = 0;
		 float media1, media2, media3;
		 double dp1, dm1, dq1, dm2, dq2, dm3, dq3, totalDm, mediaT, cv, var;
		 ip1 = lista.get(0).getIp();

		 System.out.println("\n>>>>>>>>>>>>>> RELATÓRIO GERAL <<<<<<<<<<<<<<\n");

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
				 qtdIp1++;
			 }
			 if(ip2.equalsIgnoreCase(lista.get(i).getIp())){
				 qtdIp2++;
			 }
			 if(ip3.equalsIgnoreCase(lista.get(i).getIp())){
				 qtdIp3++;
			 }
		 }
		 if((qtdIp1>qtdIp2) && (qtdIp1>qtdIp3)){
			 System.out.println("\nA Moda e o IP " + ip1 + " que se repetiu " + qtdIp1 + " vezes!");
		 }
		 else{
			 if((qtdIp2>qtdIp1) && (qtdIp2>qtdIp3)){
				 System.out.println("A Moda e o IP " + ip2 + " que se repetiu " + qtdIp2 + " vezes!");
			 }
			 else{
				 System.out.println("A Moda e o IP " + ip3 + " que se repetiu " + qtdIp3 + " vezes!");
			 }
		 }
		 //MEDIANA
		 mediana = total/2;
		 System.out.println("\nA mediana e o IP: " + lista.get(mediana).getIp());

		 //MEDIA EM PORCENTAGEM
		 media1 = (float)((qtdIp1)*(1.0)/(total)*100);
		 media2 = (float)((qtdIp2)*(1.0)/(total)*100);
		 media3 = (float)((qtdIp3)*(1.0)/(total)*100);
		 
		 System.out.printf("\nA média do IP %s tem percentual de %.2f", ip1, media1);
		 System.out.println("%");
		 System.out.printf("A média do IP %s tem percentual de %.2f", ip2, media2);
		 System.out.println("%");
		 System.out.printf("A média do IP %s tem percentual de %.2f", ip3, media3);
		 System.out.println("%");
		 
		 //CALCULANDO O DESVIO PADRAO
		 mediaT = total /3;
		 dm1 = (qtdIp1 - mediaT);
		 dq1 = Math.pow(dm1, 2);
		 
		 
		 dm2 = (qtdIp2 - mediaT);
		 dq2 = Math.pow(dm2, 2);
		 
		 dm3 = (qtdIp3 - mediaT);
		 dq3 = Math.pow(dm3, 2);
		 
		 totalDm = (dq1 + dq2 + dq3)/3;
		 dp1 = Math.sqrt(totalDm);
		 
		 cv = (dp1/total)*100;
		 var = Math.pow(dp1, 2);
		 
		 if (cv < 15){
			 System.out.printf("\nO Coefieciente de Variação é: %.2f",cv);
			 System.out.println("% indicando baixa dispersão!");
			 //System.out.println("Baixa disperção!");
		 } else if (cv >= 30){
			 System.out.printf("Onde o Coefieciente de Variação é: %.2f",cv);
			 System.out.println("% indicando media dispersão!");
			 //System.out.println("Media disperção!");
		 } else {
			 System.out.printf("Onde o Coefieciente de Variação é: %.2f",cv);
			 System.out.println("% indicando alta dispersão!");
			 //System.out.println("Alta disperção!");
		 }
		 System.out.printf("O Desvio padrão é: %.2f\n",dp1);
		 System.out.println("A variância é: "+ var);
	 }
}
