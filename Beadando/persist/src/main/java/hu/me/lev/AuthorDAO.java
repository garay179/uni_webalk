package hu.me.lev;

import hu.me.lev.exception.AuthorNotFoundException;

import java.util.ArrayList;

public interface AuthorDAO {
    ArrayList<Author> getEveryAuthor();
    String getBooksByAuthor(String author) throws AuthorNotFoundException;
    void insertAuthor(Author author);
}
