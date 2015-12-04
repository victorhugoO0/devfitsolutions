package br.com.devfitsolutions;

import java.util.*;
import java.io.*;

public class Arquivo {
	
	   public static List<Acesso> leitor(File arquivoOrigem) {
	      List<Acesso> listaDeLog = new ArrayList<Acesso>();
	      try {
	         Scanner ler = new Scanner(arquivoOrigem);
	         
	         while (ler.hasNext()) {
	            Acesso acesso = new Acesso();
	            String linhaDoArquivo = ler.nextLine();
	            String[] dadosDoLog = linhaDoArquivo.split("-");
	            acesso.setIp(dadosDoLog[0]);
	            acesso.setNome(dadosDoLog[1]);
	            acesso.setData(dadosDoLog[2]);
	            listaDeLog.add(acesso);
	         }
	      } catch (FileNotFoundException e) {
	         System.out.println("O arquivo especificado não foi encontrado.");
	      }
	      return listaDeLog;
	   }
}
