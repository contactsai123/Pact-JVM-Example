package com.pact.consumer;


import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.jayway.restassured.*;
import com.jayway.restassured.http.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ConsumerB {
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("UserService", "localhost", 8112, this);

    @Pact(consumer = "ConsumerB")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        DslPart etaResults = new PactDslJsonBody()
                .stringType("name","Peter")
                .stringType("empid","214")
                //.integerType("age", 30)
             //   .integerType("eta",60000)
                .asBody();

        return builder
                .given("There is a user with empid 214 available in the Consumer B system")
                .uponReceiving("A request for name for emp id 214")
                .path("/user/Peter/214")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(etaResults).toPact();

    }

    
    @Test
    @PactVerification("UserService")
    public  void runTest() {
    	
        System.setProperty("pact.rootDir","pacts");  // Change output dir for generated pact-files

      RestAssured
        .given()
        .port(8112)
        .contentType(ContentType.JSON)
        //.body(getUser())
        .get("/user/Peter/214")
        .then()
        .statusCode(200);
     //   .header("location", Matchers.containsString(SOME_SERVICE_USER));
        //System.out.println("According to test Salary is ="+salary);
        //assertTrue(salary >= 0);

      RestAssured.reset();
    }
    
//    @Test
//    @PactVerification()
//    public void doTest() {
//        System.setProperty("pact.rootDir","pacts");  // Change output dir for generated pact-files
//        Integer eta = new WhenComesTheBus(provider.getPort()).checkEta("Hammersmith", "613");
//        System.out.println("According to test eta="+eta);
//        assertTrue(eta >= 0);
//    }

}

