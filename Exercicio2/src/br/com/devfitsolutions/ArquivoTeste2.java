package br.com.devfitsolutions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoTeste2 {
	
	public static void main(String[] args) throws IOException{
		
	    FileInputStream entrada = new FileInputStream("/Users/victorvianasantos/Downloads/Hirens/teste.txt");
	    InputStreamReader entradaFormatada = new InputStreamReader(entrada);
	    int caracter = entradaFormatada.read();
	    int spaco = 0, vogais = 0, consoantes = 0, enter = 0, palavras = 0, linhas = 0, letras = 1, carcEsp = 0;
	    
	    while( caracter >= 1){
	    	if (caracter == 97 || caracter == 101 || caracter == 105 || caracter == 111 || caracter == 117){
	    		vogais++;
	    	}
	    	System.out.print( (char)caracter);
	    	caracter = entradaFormatada.read();
	    	if ( caracter == 32){
	    		spaco++;
	    	}
	    	if (caracter == 10){
	    		linhas++;
	    		palavras++;
	    	}
	    	if (caracter > 33 && caracter <= 64 ){
	    		carcEsp++;
	    	}
	    	letras++;
	    }
	    
	    consoantes = letras - spaco - vogais - carcEsp - linhas - 1;
	    palavras = spaco + linhas;
	    
	    System.out.println("\nEspaco: " +spaco);
	    System.out.println("Vogais: " +vogais);
	    System.out.println("Consoantes: " +consoantes);
	    System.out.println("linhas: " +linhas);
	    System.out.println("Letras: " +letras);
	    System.out.println("palavras: " +palavras);
	}
}
