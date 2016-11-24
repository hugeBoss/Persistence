package by.bsuir.netcracker.rest.services;

import by.bsuir.netcracker.persistance.models.BookEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 21.11.2016.
 */
public interface IBookService {
    public void addBook(BookEntity book) throws SQLException;

    public List<BookEntity> getAllBooks() throws SQLException;

    public void removeBook(int id) throws SQLException;
}
