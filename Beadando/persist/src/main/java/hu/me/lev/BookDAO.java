package hu.me.lev;

import hu.me.lev.exception.BookNameAlreadyTakenException;

import java.util.ArrayList;

public interface BookDAO {
    ArrayList getEveryBook();
    void insertBook(Book book) throws BookNameAlreadyTakenException;
    void updateBook(int id, String name, String author, int price);
}
