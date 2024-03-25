package com.api;

import static io.gatling.javaapi.core.CoreDsl.csv;
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

public class Feeder_Example extends Simulation{

		
	
	
	FeederBuilder<String> datas=csv("Test_Datas/Data.csv").circular();
	
	
	
	ChainBuilder feeder=exec(
			feed(datas).
			exec(session -> {
				  System.out.println(session.getString("Name"));
				  return session;
				})
			
			
	
					
					);
	
	
			
			ScenarioBuilder Feed=scenario("getData").exec(feeder);
			
			{
			setUp(
				
				Feed.injectOpen(atOnceUsers(1)));
				
				
			}
			
	
}
