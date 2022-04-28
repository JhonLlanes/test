package ec.llanes.objrestdatajpa.controller;

import ec.llanes.objrestdatajpa.modelo.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate restTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        restTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    //    BookController controller = new BookController();
    @Test
    void findall() {


    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = "{\n" +
                "\t\"title\":\"libro desde s test\",\n" +
                "\t\"autor\":\"JLC\",\n" +
                "\t\"paginas\":10,\n" +
                "\t\"costo\": 10.00,\n" +
                "\t\"lazamientofecha\":\"2016-06-12\",\n" +
                "\t\"online\":true\n" +
                "}";

        HttpEntity<String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Book> response = restTemplate.exchange("/save", HttpMethod.POST, request, Book.class );
        Book resutl = response.getBody();

        assertEquals(1L, resutl.getId());
        assertEquals("JLC", resutl.getAutor());





    }

    @Test
    void delete() {
    }

    @Test
    void helloword() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hola", String.class);
        response.getStatusCode();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("123", response.getBody());
    }

}