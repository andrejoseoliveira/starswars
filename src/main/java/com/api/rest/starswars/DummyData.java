package com.api.rest.starswars;

import org.springframework.boot.CommandLineRunner;

import com.api.rest.starswars.repository.PlanetasRepository;
import com.api.rest.starswars.repository.SwapiRequestRepository;
import com.api.rest.starswars.webservices.SwapiWebService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DummyData implements CommandLineRunner{

	
	private SwapiWebService swapiWebService = new SwapiWebService();
	private SwapiRequestRepository swapiRequestRepository = new SwapiRequestRepository(swapiWebService);
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CARREGANDO");
        JsonObject jsonObject = swapiRequestRepository.getAll("planets", null);
        JsonArray results = jsonObject.getAsJsonArray("results");
        
        int i = 1;
        for (JsonElement planet : results) {
			System.out.println(1 + " - " + planet);
			i++;
		}
		
	}

}
