package br.com.devfitsolutions;

import java.util.*;
import java.io.*;

public class Arquivo {
	/**
	    * Faz a leitura do arquivo e retorna uma lista de pessoas. O layout do
	    * arquivo deve ser: ip;user;data(dd/mm/aaaa);hora(hh:mm:ss)
	    * @param arquivoOrigem
	    * @return
	    */
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
	         System.out.println("O arquivo especificado nao foi encontrado.");
	      }
	      return listaDeLog;
	   }
}
