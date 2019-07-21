package com.api.rest.starswars.services;

import com.api.rest.starswars.documents.Planeta;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetaServices {
	Flux<Planeta> findAll();
	Mono<Planeta> findById(String id);
//	Planeta findPlanetById(String id);
	Mono<Planeta> save(Planeta Planeta);
	Mono<Void> remove(String id);
//	@Query("SELECT p FROM Planeta p WHERE p.nome = ?1 ")
//	Planeta findByName(String name);
	
}