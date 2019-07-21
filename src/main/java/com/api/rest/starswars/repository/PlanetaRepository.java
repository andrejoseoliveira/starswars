package com.api.rest.starswars.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.rest.starswars.documents.Planeta;

public interface PlanetaRepository extends ReactiveMongoRepository<Planeta, String>{

}
