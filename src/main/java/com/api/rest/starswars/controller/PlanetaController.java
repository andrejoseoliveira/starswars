package com.api.rest.starswars.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.starswars.documents.Planeta;
import com.api.rest.starswars.repository.SwapiRequestRepository;
import com.api.rest.starswars.services.PlanetaServices;
import com.api.rest.starswars.webservices.SwapiWebService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PlanetaController {

	@Autowired
	PlanetaServices service;
	
	SwapiWebService swapiWebService = new SwapiWebService();
	
	SwapiRequestRepository swapiRequestRepository = new SwapiRequestRepository(swapiWebService);
	
	@GetMapping(value="/planeta")
	public Flux<Planeta> getPlaneta(){
		return service.findAll();
	}
		
	@GetMapping(value="/planeta/{id}")
	public Mono<Planeta> getPlanetaId(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping(value="/planeta")
	public Mono<Planeta> save(@RequestBody Planeta Planeta){
		return service.save(Planeta);
	}
	
	@GetMapping(value="/planeta/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Planeta>> getPlanetaByEvents(){
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Planeta> events = service.findAll();
        System.out.print("Passou aqui events");
        return Flux.zip(interval, events);       
	}

	@GetMapping(value="/planeta/remove/{id}")
	public Mono<Void> removetPlanetaId(@PathVariable String id){
		return service.remove(id);
	}
	
	@GetMapping(value="/planeta/swapi/{nome}")
	public String getPlanetaSwApi(@PathVariable String nome) {
		
		System.out.println("CHEGOU AQUI 1");
        JsonObject jsonObject = swapiRequestRepository.getAll("planets", nome);
        System.out.println("CHEGOU AQUI 2");
        JsonArray results = jsonObject.getAsJsonArray("results");
        System.out.println("CHEGOU AQUI 3");
        JsonObject planet = results.get(0).getAsJsonObject();
        System.out.println("CHEGOU AQUI 4");
        System.out.println("PLANETA"+ planet.toString());
		return planet.toString();
	}
	
	@GetMapping(value="/planeta/swapi/qtd/{nome}")
	public int getQuantidadeFilmesPlanetaSwApi(@PathVariable String nome) {
		
		System.out.println("CHEGOU AQUI 1");
        JsonObject jsonObject = swapiRequestRepository.getAll("planets", nome);
        System.out.println("CHEGOU AQUI 2");
        JsonArray results = jsonObject.getAsJsonArray("results");
        System.out.println("CHEGOU AQUI 3");
        JsonObject planet = results.get(0).getAsJsonObject();
        System.out.println("CHEGOU AQUI 4");
        System.out.println("PLANETA"+ planet.toString());
        
        JsonArray filmes = planet.get("films").getAsJsonArray();
        System.out.println("Naboo Films"+ filmes.size());
        
        
        return filmes.size();
	}
	
	
	
	@GetMapping(value="/pipeline")
	public String getPipeline(){
		return "Hello World!!!";
	}
}
