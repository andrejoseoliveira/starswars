package com.api.rest.starswars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarswarsApplicationTests {
	
//	@Autowired
//	PlanetasServices service;
//	
//	private SwapiWebService swapiWebService = new SwapiWebService();
//	private SwapiRequestRepository swapiRequestRepository = new SwapiRequestRepository(swapiWebService);
//	
	
	@Test
	public void contextLoads() {
	}
	
//	@Test
//	public void carregaVBanco() throws InterruptedException {
		
//		Thread.sleep(1000);
//		Thread.sleep(1000);
//		Thread.sleep(1000);
//		
//        JsonObject jsonObject = swapiRequestRepository.getAll("planets", null);
//        JsonArray results = jsonObject.getAsJsonArray("results");
//        
//        System.out.println("APAGANDO OS DADOS DO BANCO");     
//        service.removeAll();  
//        Thread.sleep(1000);
//        Thread.sleep(1000);
//        Thread.sleep(1000);
//        Thread.sleep(1000);
//        
//        System.out.println("CARREGANDO DADOS NO BANCO");
//        Thread.sleep(1000);
//        Thread.sleep(1000);
//        
//        for (int i =0; i < results.size() ; i++ ) {
//        	JsonObject planeta = results.get(i).getAsJsonObject();
//			System.out.println(i + " - " + planeta.get("name").toString());
//			System.out.println(i + " - " + planeta.get("climate").toString());
//			System.out.println(i + " - " + planeta.get("terrain").toString());
//			
//			String nome = planeta.get("name").toString().replace("\"", "");;
//			String clima  =  planeta.get("climate").toString().replace("\"", "");;
//			String terreno =  planeta.get("terrain").toString().replace("\"", "");;
//			
//			Planeta p  = new Planeta(nome, terreno, clima);
//			
//			service.save(p);
//			
//			Thread.sleep(1000);
//			Thread.sleep(1000);
//			Thread.sleep(1000);
			
//		}
//	}

}
