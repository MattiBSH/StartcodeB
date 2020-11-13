/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTOs.SpeciesDTO;
import entities.RenameMe;
import entities.Species;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;

/**
 *
 * @author matti
 */
public class MyOwnResourceIT {
//    
//     private static final int SERVER_PORT = 7777;
//    private static final String SERVER_URL = "http://localhost/api";
//    private static Species r1, r2;
//
//    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
//    private static HttpServer httpServer;
//    private static EntityManagerFactory emf;
//
//    static HttpServer startServer() {
//        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
//        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//        //This method must be called before you request the EntityManagerFactory
//        EMF_Creator.startREST_TestWithDB();
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//
//        httpServer = startServer();
//        //Setup RestAssured
//        RestAssured.baseURI = SERVER_URL;
//        RestAssured.port = SERVER_PORT;
//        RestAssured.defaultParser = Parser.JSON;
//    }
//
//    @AfterAll
//    public static void closeTestServer() {
//        //System.in.read();
//
//        //Don't forget this, if you called its counterpart in @BeforeAll
//        EMF_Creator.endREST_TestWithDB();
//        httpServer.shutdownNow();
//    }
//
//    // Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
//    //TODO -- Make sure to change the EntityClass used below to use YOUR OWN (renamed) Entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        r1 = new Species("Some txt", "More text");
//        r2 = new Species("aaa", "bbb");
//        try {
//            em.getTransaction().begin();
//            em.createNamedQuery("RenameMe.deleteAllRows").executeUpdate();
//            em.persist(r1);
//            em.persist(r2);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @Test
//    public void allUp() {
//        given().when().get("/species/all").then().statusCode(200);
//    }
//    @Test
//    public void idUp() {
//        given().when().get("/species/id/1").then().statusCode(200);
//    }
//    
//    @Test
//    public void testId() throws Exception {
//        given()
//                .contentType("application/json")
//                .get("/species/id/1").then()
//                .assertThat()
//                .statusCode(HttpStatus.OK_200.getStatusCode())
//                .body("title", equalTo("aaa"));
//    }
//    @Test
//    public void testAll() throws Exception {
//        given()
//                .contentType("application/json")
//                .get("/species/all").then()
//                .assertThat()
//                .statusCode(HttpStatus.OK_200.getStatusCode())
//                .body("title[0]", equalTo("aaa"));
//    }
//    //This test assumes the database contains two rows
//    
//    @Test
//    public void testAddPerson() {
//        given()
//                .contentType("application/json")
//                .body(new SpeciesDTO("Monster", "Mærkeligt væsen"))
//                .when()
//                .post("species/add")
//                .then()
//                .body("description", equalTo("Mærkeligt væsen"))
//                .body("title", equalTo("Monster"))
//                ;
//    }
}
