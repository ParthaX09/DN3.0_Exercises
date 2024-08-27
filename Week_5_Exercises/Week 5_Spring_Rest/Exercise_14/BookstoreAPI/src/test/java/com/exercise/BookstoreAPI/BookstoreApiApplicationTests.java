package com.exercise.BookstoreAPI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class BookstoreApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BookService service;

	@BeforeEach
	public void setup() {
		Book b = new Book(1, "The Jungle Book", "Rudyard Kipling", 49.99, "789797899");
		service.saveBook(b);
	}

	// Testing GET /books/{id} route
	@Test
	public void testGetBookById() throws Exception {
		Book b = new Book(1, "The Jungle Book", "Rudyard Kipling", 49.99, "789797899");
		service.saveBook(b);

		mockMvc.perform(get("/books/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.title").value("The Jungle Book"))
				.andExpect(jsonPath("$.author").value("Rudyard Kipling"))
				.andExpect(jsonPath("$.price").value(49.99))
				.andExpect(jsonPath("$.isbn").value("789797899"));
	}


	// Testing POST /books/save-one route
	@Test
	public void testSaveBook() throws Exception {
		Book b = new Book(2, "Feluda Samagra", "Satyajit Roy", 50.99, "900098833");
		mockMvc.perform(post("/books/save-one")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(b)))
				.andExpect(jsonPath("$.id").value("2"))
				.andExpect(jsonPath("$.title").value("Feluda Samagra"))
				.andExpect(jsonPath("$.author").value("Satyajit Roy"))
				.andExpect(jsonPath("$.price").value(50.99))
				.andExpect(jsonPath("$.isbn").value("900098833"));
	}

}
