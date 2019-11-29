package hu.me.lev;

import hu.me.lev.exception.BookNameAlreadyTakenException;

import java.util.ArrayList;

public interface BookService {
    ArrayList getAllTheBooks();
    void addBook(Book book) throws BookNameAlreadyTakenException;
    void updateBook(int id, String name, String author, int price);
}
