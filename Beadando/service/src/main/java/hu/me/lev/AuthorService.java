package hu.me.lev;

import hu.me.lev.exception.AuthorNotFoundException;

import java.util.ArrayList;

public interface AuthorService {
    ArrayList<Author> getAllTheAuthors();
    String getBooksByAuthor(String author) throws AuthorNotFoundException;
    void addAuthor(Author author);
}
