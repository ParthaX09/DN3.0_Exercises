package com.exercise.BookstoreAPI;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.exercise.BookstoreAPI.controllers.BookController;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookController.class)
class BookstoreApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService service;

	@Test
	public void testGetBookById() throws Exception {
		Book book = new Book(0, "The Jungle Book", "Rudyard Kipling", 51.99, "987654321");

		when(service.getBookById(0)).thenReturn(book);

		mockMvc.perform(get("/books/0")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("0"))
				.andExpect(jsonPath("$.title").value("The Jungle Book"))
				.andExpect(jsonPath("$.author").value("Rudyard Kipling"))
				.andExpect(jsonPath("$.price").value(51.99))
				.andExpect(jsonPath("$.isbn").value("987654321"));
	}

	// Testing the POST /books/save-one route
	@Test
	public void testSaveBook() throws Exception {
		Book book = new Book(0, "The Jungle Book", "Rudyard Kipling", 51.99, "987654321");

		when(service.saveBook(book)).thenReturn(book);

		mockMvc.perform(post("/books/save-one")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(book)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value("0"))
				.andExpect(jsonPath("$.title").value("The Jungle Book"))
				.andExpect(jsonPath("$.author").value("Rudyard Kipling"))
				.andExpect(jsonPath("$.price").value(51.99))
				.andExpect(jsonPath("$.isbn").value("987654321"));

	}

}
