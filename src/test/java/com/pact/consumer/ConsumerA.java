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


public class ConsumerA {
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("UserService", "localhost", 8112, this);

    @Pact(consumer = "ConsumerA")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        DslPart etaResults = new PactDslJsonBody()
                .stringType("empid","214")
                .integerType("age", 30)
                .asBody();

        return builder
                .given("There is a user with empid 214 available in the Consumer A system")
                .uponReceiving("A request for age for emp id 214")
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
        .get("/user/Peter/214")
        .then()
        .statusCode(200);
      RestAssured.reset();
    }
}

