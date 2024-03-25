package com.api;

import java.time.Duration;
import java.util.*;

import akka.actor.Status;
import akka.japi.Predicate;
import io.gatling.commons.stats.assertion.Condition.Is;
import io.gatling.core.scenario.Scenario;
import io.gatling.core.session.Session;
import io.gatling.http.response.Response;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class Sample_API extends Simulation {

	
	
	
	private HttpProtocolBuilder httpProtocol = http.baseUrl("https://reqres.in/");
	
	
	
	
	
	
	
	
	
	FeederBuilder<String> datas=csv("Test_Datas/Data.csv").circular();
	


	ChainBuilder Post_Request =exec(

			feed(datas).exec(
					
					feed(datas).
					exec(session -> {
						  System.out.println(session.getString("Name"));
						  return session;
						}),
						
			
			http("Post").post("/api/users").asJson().body(RawFileBody("Test_Datas/Data.js"))
					
					.asJson().check(
							
						
							status().is(201),
							
							jsonPath("$.name").is("morpheus")
							
							
		
							)));

			
			
	
	
	
	
	ScenarioBuilder Post = scenario("Post_").exec(Post_Request);
	
	
		
		
	
			
			
			
	
	
	
	{
		
		
		
		
		
		setUp(
				
				
				Post.injectOpen(atOnceUsers(1))
				
				
				
				).protocols(httpProtocol);
	}

}
