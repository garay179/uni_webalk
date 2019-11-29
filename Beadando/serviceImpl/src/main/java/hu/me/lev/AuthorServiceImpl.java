package hu.me.lev;

import hu.me.lev.exception.AuthorNotFoundException;

import java.util.ArrayList;

public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public ArrayList<Author> getAllTheAuthors() {
        return authorDAO.getEveryAuthor();
    }

    @Override
    public String getBooksByAuthor(String author) throws AuthorNotFoundException {
        return authorDAO.getBooksByAuthor(author);
    }

    @Override
    public void addAuthor(Author author) {
        authorDAO.insertAuthor(author);
    }
}
