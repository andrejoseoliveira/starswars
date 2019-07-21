package com.api.rest.starswars.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Planeta {

	@Id
	private String id;
	private String nome;
	private String terreno;
	private String clima;
	@Transient
	private int quantidade;
	
	public Planeta(String id, String nome, String terreno, String clima) {
		super();
		this.id = id;
		this.nome = nome;
		this.terreno = terreno;
		this.clima = clima;
	}
	
//	public Planeta( String nome, String terreno, String clima) {
//		super();
//		this.nome = nome;
//		this.terreno = terreno;
//		this.clima = clima;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTerreno() {
		return terreno;
	}
	
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	public String getClima() {
		return clima;
	}
	
	public void setClima(String clima) {
		this.clima = clima;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}