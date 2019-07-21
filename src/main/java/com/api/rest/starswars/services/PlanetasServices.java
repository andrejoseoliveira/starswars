package com.api.rest.starswars.services;

import java.util.List;
import java.util.Optional;

import com.api.rest.starswars.documents.Planeta;

import reactor.core.publisher.Mono;

public interface PlanetasServices {
	List <Planeta> findAll();
	Optional<Planeta> findById(String id);
	Planeta save(Planeta Planeta);
	void remove(Planeta planeta);
	void removeAll();
	Planeta findByNome(String nome);
}
