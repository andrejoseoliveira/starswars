package com.api.rest.starswars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.starswars.documents.Planeta;
import com.api.rest.starswars.repository.PlanetaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetaServicesImpl implements PlanetaServices{

	@Autowired
	PlanetaRepository repository;
	
	@Override
	public Flux<Planeta> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Planeta> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Planeta> save(Planeta Planeta) {
		return repository.save(Planeta);
	}
	
	@Override
	public Mono<Void> remove(String id) {		
		return repository.deleteById(id);
	}

//	@Override
//	public Planeta findPlanetById(String id) {
//		// TODO Auto-generated method stub
//		return repository.findById(id);;
//	}

//	@Override
//	public Planeta findByName(String name) {
//		// TODO Auto-generated method stub
//		
//		repository.
//		return null;
//	}		
}