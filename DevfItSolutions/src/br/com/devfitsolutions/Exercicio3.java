package br.com.devfitsolutions;

import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try{
			
			Scanner scanner = new Scanner(new FileReader("g://itens1.dat"))
	                    .useDelimiter(" ");
			Scanner scanner2 = new Scanner(new FileReader("g://itens2.dat"))
	                    .useDelimiter(" ");
			
			String caminho = "g://listagem.dat";
			
			OutputStream os = new FileOutputStream(caminho);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			while (scanner.hasNext()) {
				String nome = scanner.next();
				Double valor = scanner.nextDouble();
				String marca = scanner.next();
				String validade = scanner.next();
				bw.write(nome + "-");
				bw.write(marca + "-");
				bw.write(validade + "\n");
			}
				
			while (scanner2.hasNext()) {
				String nome2 = scanner2.next();
				Double valor2 = scanner2.nextDouble();
				String marca2 = scanner2.next();
				String validade2 = scanner2.next();
				bw.write( nome2 + "-");
				bw.write(marca2 + "-");
				bw.write(validade2 + "\n");
				
			}
			bw.close();  
			JOptionPane.showMessageDialog(null, "Combina��o de arquivos gravada com sucesso em: "
			+ caminho);
			
		}catch(IOException exc){
			System.err.println("ERRO: " + exc);
		}

	}

}