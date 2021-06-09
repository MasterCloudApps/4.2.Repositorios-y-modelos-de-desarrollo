package es.urjc.code.daw.library.e2e.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import es.urjc.code.daw.library.book.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("REST tests")
public class RestTest {

    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Añadir un nuevo libro y comprobar que se ha creado")
	public void createBookTest() throws Exception {

        // CREAMOS UN NUEVO LIBRO

		Book book = new Book("FAKE BOOK","Contenido de prueba");
    	
        Book createdBook = 
            given()
                .request()
                    .body(objectMapper.writeValueAsString(book))
                    .contentType(ContentType.JSON).
            when()
                .post("/api/books/").
            then()
                .assertThat()
                .statusCode(201)
                .body("title", equalTo(book.getTitle()))
                .extract().as(Book.class);

        // COMPROBAMOS QUE EL LIBRO SE HA CREADO CORRECTAMENTE

        when()
            .get("/api/books/{id}", createdBook.getId())
        .then()
             .assertThat()
             .statusCode(200)
             .body("title", equalTo(book.getTitle()));
		
    
    }

    @Test
	@DisplayName("Borrar un libro y comprobar que se ha borrado")
	public void deleteBookTest() throws Exception {

        // CREAMOS UN NUEVO LIBRO

		Book book = new Book("FAKE BOOK","Contenido de prueba");
    	
        Book createdBook = 
            given()
                .request()
                    .body(objectMapper.writeValueAsString(book))
                    .contentType(ContentType.JSON)
            .when()
                .post("/api/books/")
            .then()
                .assertThat()
                .statusCode(201)
                .body("title", equalTo(book.getTitle()))
                .extract().as(Book.class);
        
        // BORRAMOS EL LIBRO CREADO
        when()
             .delete("/api/books/{id}",createdBook.getId())
        .then()
             .assertThat()
                .statusCode(200);

        // COMPROBAMOS QUE EL LIBRO YA NO EXISTE

        when()
             .get("/api/books/{id}", createdBook.getId())
        .then()
             .assertThat()
                .statusCode(404);

    }
    
}