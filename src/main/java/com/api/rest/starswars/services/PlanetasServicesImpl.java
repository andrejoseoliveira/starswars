package com.api.rest.starswars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.starswars.documents.Planeta;
import com.api.rest.starswars.repository.PlanetasRepository;

import reactor.core.publisher.Mono;

@Service
public class PlanetasServicesImpl implements PlanetasServices{

	@Autowired
	PlanetasRepository repository ;
	
	
	@Override
	public List<Planeta> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Planeta> findById(String id) {		
		return repository.findById(id);
	}

	@Override
	public Planeta save(Planeta Planeta) {
		return repository.save(Planeta);
	}

	@Override
	public void remove(Planeta planeta) {
		repository.delete(planeta);
	}

	@Override
	public Planeta findByNome(String nome) {
		return repository.findByNome(nome);
	}

	@Override
	public void removeAll() {
		repository.deleteAll();
	}

}
