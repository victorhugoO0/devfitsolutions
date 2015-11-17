package br.com.devfitsolutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		
		String nomeArquivo;
		int contLinha = 0;
		
		System.out.println("Informe o caminho do arquivo texto: ");
		nomeArquivo = entrada.nextLine();
		
		System.out.println("Conteudo do arquivo texto: ");
		try {
			FileReader arquivo = new FileReader(nomeArquivo);
			BufferedReader lerArquivo = new BufferedReader(arquivo);
			
			String linha = lerArquivo.readLine();
			while (linha != null){ 							//Enquanto tiver conteudo ele roda esse bloco de codigo.
				System.out.printf("%s\n", linha);
				contLinha++;  										// Contagem de linhas
				linha = lerArquivo.readLine();
			}
			arquivo.close();
		} catch (IOException e){
			System.err.printf("Erro na abertura do arquivo! %s.\n", e.getMessage());
		}
	System.out.println("O arquivo selecionado contém: "+contLinha+ " linhas!");
	}
}
