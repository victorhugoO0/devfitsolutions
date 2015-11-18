package br.com.devfitsolutions;

import java.io.File.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class Exercicio1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	Scanner input = new Scanner(System.in);	
	int parametro = 0, qtdCaractere, ascii;
	String txtNormal = "";
	String txtCript = "";
	char caractere, aux;
	
	System.out.print("informe os dados para criptografar: ");
	txtNormal = input.nextLine();
	txtNormal = txtNormal.toLowerCase();
	qtdCaractere = txtNormal.length();
	System.out.print("Informe o parametro...: ");
	 parametro = input.nextInt();
	 
	
	for (int i = 0; i < qtdCaractere; i++){
		
	  caractere = txtNormal.charAt(i);
	  ascii = (int) caractere;
	  if (ascii+ parametro >= 97 && ascii+ parametro <=122){
	  ascii = (int) caractere + parametro;
	  }
	  txtCript = txtCript + (char) ascii;
	  
	}
	
	FileWriter arq = new FileWriter("D:/Cripografia.txt");
	PrintWriter gravarArq = new PrintWriter(arq);
	
	gravarArq.printf(txtCript);
	arq.close();
	
	System.out.println("Foi gerado com sucesso em \"D:/Criptografia.txt\". \n");
	
	
	}

}