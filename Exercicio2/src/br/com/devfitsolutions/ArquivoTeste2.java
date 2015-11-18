package br.com.devfitsolutions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

public class ArquivoTeste2 {
	
	public static void main(String[] args) throws IOException{
		Scanner entrada = new Scanner (System.in);
		String nomeArquivo;
		
		int contEspaco = 0;
		int contVogais = 0;
		int contConsoantes = 0;
		int contLinha = 0;
		int contPalavra = 0;
		int i = 0;
		
		System.out.println("Informe o caminho do arquivo texto: ");
		nomeArquivo = entrada.nextLine();
		
		try{
			FileReader arqvuio = new FileReader(nomeArquivo);
			BufferedReader lerArquivo = new BufferedReader(arqvuio);
			
			String linha = lerArquivo.readLine();
			String[] palavra = linha.split(" ");
			while (linha != null){
				for	(i = 0; i < linha.length(); i++){
					char caracter = linha.toLowerCase().charAt(i);
					if (caracter == ' '){
						contPalavra++;
						contEspaco++;
					} else if ((int) caracter >= 97 && (int) caracter <= 127){
						if(caracter == 'a' || caracter == 'e'|| caracter == 'i' || caracter == 'o' || caracter == 'u'){
							contVogais++;
						} else {
							contConsoantes++;
						}
					}
				}
				linha = lerArquivo.readLine();
				contLinha++;
				contPalavra++;
			}		
			arqvuio.close();
		}catch (IOException e){
			System.out.printf("Erro!", e.getMessage());
		}
		
		System.out.println("Espaços: " +contEspaco);
		System.out.println("Vogais: " +contVogais);
		System.out.println("Consoantes: " +contConsoantes);
		System.out.println("Linhas: " +contLinha);
		System.out.println("Palavras: " +contPalavra);
		System.out.println("Letras: " + (contConsoantes + contVogais));
	}
}
