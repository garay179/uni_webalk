package hu.me.lev;

import hu.me.lev.exception.AuthorNotFoundException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AuthorDAOImpl implements AuthorDAO {
    private Map<Integer, Author> authors;

    public AuthorDAOImpl(Map<Integer, Author> authors) {
        this.authors = authors;
    }

    public AuthorDAOImpl()
    {
        this.authors = new HashMap<>();
        authors.put(1,new Author("Béla", 35, "Verseskötet"));
    }

    @Override
    public ArrayList<Author> getEveryAuthor() {
        ArrayList<Author> everyAuthor = new ArrayList<Author>();
        int size = authors.size();
        int i = 1;

        while(i < size)
        {
            everyAuthor.add(i,authors.get(size));
        }
        return everyAuthor;
    }

    @Override
    public String getBooksByAuthor(String author) throws AuthorNotFoundException {
        int mapSize = authors.size();
        int matches = 0;
        String writtenBooks = "";

        while(mapSize > 0)
        {
            if(authors.get(mapSize).name == author)
            {
                matches++;
                writtenBooks += authors.get(author).writtenBook;
            }
            mapSize--;
        }

        if(matches == 0)
        {
            throw new AuthorNotFoundException("nincs ilyen szerző!");
        }
        else
        {
            return writtenBooks;
        }

    }

    @Override
    public void insertAuthor(Author author) {
        authors.put(authors.size()+1, author);
    }
}
