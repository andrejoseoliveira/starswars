package com.api.rest.starswars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.starswars.documents.Planeta;
import com.api.rest.starswars.repository.SwapiRequestRepository;
import com.api.rest.starswars.services.PlanetasServices;
import com.api.rest.starswars.webservices.SwapiWebService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
public class PlanetasController {

	@Autowired
	PlanetasServices service;
	
	SwapiWebService swapiWebService = new SwapiWebService();
	
	SwapiRequestRepository swapiRequestRepository = new SwapiRequestRepository(swapiWebService);
	
	private int getQuantidadeFilmesPlanetaSwApi(String nome) {
		
		int retorno = 0;
		try {
			nome = nome.replace(" ", "&amp;");		
//			System.out.println("NOME: " + nome);
	        JsonObject jsonObject = swapiRequestRepository.getAll("planets", nome);
	        JsonArray results = jsonObject.getAsJsonArray("results");
	        JsonObject planet = results.get(0).getAsJsonObject();
	        JsonArray filmes = planet.get("films").getAsJsonArray();
	        retorno = filmes.size();
		} catch (Exception e) {
			// TODO: handle exception
		}

       
        return retorno;
	}
	
	@GetMapping(value="/planetas/{id}")
	public Planeta getPlanetaId(@PathVariable String id){
		
		Planeta planeta = service.findById(id).get();
		
		int quantidade = getQuantidadeFilmesPlanetaSwApi(planeta.getNome());
		planeta.setQuantidade(quantidade);
		
		return planeta;
	}
	
	@GetMapping(value="/planetas/lista")
	public List<Planeta> getPlanetas(){		
		List<Planeta> planetas = service.findAll();		
		for (Planeta planeta : planetas) {
			int quantidade = getQuantidadeFilmesPlanetaSwApi(planeta.getNome());
			planeta.setQuantidade(quantidade);
		}				
		return planetas;
	}
	
	@PostMapping(value="/planetas/insert")
	public Planeta save(@RequestBody Planeta planeta){
		return service.save(planeta);
	}
	
	@GetMapping(value="/planetas/remove/{id}")
	public String removerPlanetaId(@PathVariable String id){
		Planeta planeta = service.findById(id).get();
		service.remove(planeta);
		return "['message' : 'Planeta removido com sucesso']";
	}
	
	@GetMapping(value="/planetas/busca/{nome}")
	public Planeta getPlanetaPeloNome(@PathVariable String nome){
		
		Planeta planeta = service.findByNome(nome); 
		int quantidade = getQuantidadeFilmesPlanetaSwApi(planeta.getNome());
		planeta.setQuantidade(quantidade);
		return planeta;
	}
}
