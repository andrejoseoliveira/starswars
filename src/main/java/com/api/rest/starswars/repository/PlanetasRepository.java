package com.api.rest.starswars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.api.rest.starswars.documents.Planeta;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetasRepository extends  MongoRepository<Planeta, String>{

    @Query("{ 'nome' : ?0 }")
    Planeta findByNome(String nome);
}
