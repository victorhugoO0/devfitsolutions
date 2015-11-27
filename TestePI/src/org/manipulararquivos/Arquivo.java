package org.manipulararquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dados.Acesso;

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

	   /*
	   /**
	    * Grava o arquivo.
	    * @param lista
	    * @param arquivoDestino
	    * N�O SER� UTILIZADO NESTE PROGRAMA
	    
	   public static void escritor(List<Pessoa> lista, File arquivoDestino) {
	      FileWriter writer;
	      try {
	         writer = new FileWriter(arquivoDestino);
	         for (int i=0; i<lista.size();i++) {
	        	  String linha = String.format("%s;%s;%s\n",
	              lista.get(i).getIp(),
	              lista.get(i).getNome(),
	              lista.get(i).getData());
	              writer.write(linha);
	      }
	      writer.flush();
	      } catch (IOException e) {
	         System.out.println("Houve um erro ao tentar gravar o Arquivo.\nVerifique se voce possui permissao no diretorio de gravacao");
	      }
	   }   */
}