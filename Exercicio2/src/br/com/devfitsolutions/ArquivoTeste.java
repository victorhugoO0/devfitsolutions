package br.com.devfitsolutions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoTeste {

	public static void main(String[] args) throws IOException{
	    FileInputStream entrada = new FileInputStream("C:\\temp\\teste.txt");
	    InputStreamReader entradaFormatada = new InputStreamReader(entrada);
	    int caracteres = entradaFormatada.read();
	    //int consoantes = entradaFormatada.read();
	    
	    int consoantes = 0;
	    int vogais = 0, cont = 0, espaco =0, linhas = 0, enter =0;
	    
	    while( caracteres != -1){
	    	System.out.print( (char)caracteres);
	    	caracteres = entradaFormatada.read();
	    	if (caracteres == 97 || caracteres == 101 || caracteres == 105 || caracteres == 111 || caracteres == 117){
	    		vogais++;
	    	}
	    	if (caracteres == 32){
	    		espaco++;
	    	}
	    	if (caracteres > 33 && caracteres <= 64 ){
	    		linhas++;
	    	}
	    	/*if (caracteres == 32 || caracteres == 13){
	    		palavra++;
	    	}*/
	    	if (caracteres == 13){
	    		enter++;
	    	}
	    	cont++;
	    }
	    
	    consoantes = cont - vogais;
	    //palavra++;
	    linhas++;
	    cont = cont - espaco - enter;
	    consoantes = cont - espaco - linhas - vogais - 1;
	    System.out.printf("\nvogais: " +vogais+ "\n");
	    System.out.println("consoantes: " +consoantes);
	    System.out.println("espacos: " +espaco);
	    //System.out.println("palavras: " +palavra);
	    System.out.println("total de linhas: " +linhas);
	    System.out.println("total de letras: " +cont);
	}

}