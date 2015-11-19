package br.com.devfitsolutions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Exercicio2 {
	
	public static void main(String[] args) throws IOException{
		Scanner entrada = new Scanner (System.in);
		String nomeArquivo, destino;
		
		int contEspaco = 0;
		int contVogais = 0;
		int contConsoantes = 0;
		int contLinha = 0;
		int contPalavra = 0;
		int i = 0;
		
		try{
			FileReader arqvuio = new FileReader("c:\\temp\\entrada.txt");	//entrada baseado em caracteres
			BufferedReader lerArquivo = new BufferedReader(arqvuio);  	//classe que gera o buffer que ser� utilizado para realizar a leitura do arquivo txt.
			
			String linha = lerArquivo.readLine();
			while (linha != null){		//Enquanto tiver linha vai rodar (valida se a variavel linha contem valor (caracteres))
				for	(i = 0; i < linha.length(); i++){ 		//Verifica caracter por caracter
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
		
		// Gravando o arquivo no caminho informado pelo usuario
		
		FileWriter novoArquivo = new FileWriter("c:\\temp\\saida.txt"); //Cria
		BufferedWriter gravarNovoArquivo = new BufferedWriter(novoArquivo); //Classe responsavel por gerar o Buffer que ser� utilizado para realizar a escrita do txt.
		
		gravarNovoArquivo.write("O arquivo selecionado possui:\r\n");
		gravarNovoArquivo.write("Espa�os em branco: " +contEspaco+ "\r\n");
		gravarNovoArquivo.write("Vogais: " +contVogais+ "\r\n");
		gravarNovoArquivo.write("Consoantes: " +contConsoantes+ "\r\n");
		gravarNovoArquivo.write("Palavras: " +contPalavra+ "\r\n");
		gravarNovoArquivo.write("Letras: " +(contConsoantes + contVogais)+ "\r\n");
		gravarNovoArquivo.write("Linhas: " +contLinha+ "\r\n");
		
		gravarNovoArquivo.close();  // Fecha o arquivo com os dados gravados
		System.out.println("Arquivo gravado com sucesso!");
		
	}
}
