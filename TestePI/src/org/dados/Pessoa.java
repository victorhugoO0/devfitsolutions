package org.dados;

public class Pessoa {
   
   private String ip;
   private String nome;
   private String data;
   

   public Pessoa() {
      super();
   }

   public Pessoa(String ip, String nome, String data) {
		super();
		this.ip = ip;
		this.nome = nome;
		this.data = data;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "IP = " + ip + " - Usuario = " + nome + " - Data = " + data + " ] ";
	}

}