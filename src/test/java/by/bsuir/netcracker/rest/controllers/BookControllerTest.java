package by.bsuir.netcracker.rest.controllers;

import by.bsuir.netcracker.persistance.models.BookEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Huge Boss on 22.11.2016.
 */
public class BookControllerTest {
    ClassPathXmlApplicationContext context;
    BookController bookController;

    @Test
    public void getBooks() throws Exception {
        List<BookEntity> books = bookController.getBooks();
        assertTrue(!books.isEmpty());
    }

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");
        bookController = context.getBean(BookController.class);
    }
}