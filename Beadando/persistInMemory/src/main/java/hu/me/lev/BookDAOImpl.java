package hu.me.lev;

import hu.me.lev.exception.BookNameAlreadyTakenException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookDAOImpl implements BookDAO {
    private Map<Integer, Book> books;

    public BookDAOImpl(Map<Integer, Book> books) {
        this.books = books;
    }

    public BookDAOImpl(){
        this.books = new HashMap<>();
        books.put(1,new Book(1,"Verseskötet", "Béla", 2500));
    }

    @Override
    public ArrayList getEveryBook() {
        ArrayList<Book> allBooks = new ArrayList<Book>();
        int size = books.size();
        int i = 1;

        while (i < size)
        {
            allBooks.add(i,books.get(size));
            i++;
        }
        return allBooks;
    }

    @Override
    public void insertBook(Book book) throws BookNameAlreadyTakenException {
        if(!getEveryBook().contains(book.getName()))
        {
            throw new BookNameAlreadyTakenException();
        }
        else{
            this.books.put(book.getId(), book);
        }
    }

    @Override
    public void updateBook(int id, String name, String author, int price){
        Book bookToUpdate = books.get(id);
        bookToUpdate.setName(name);
        bookToUpdate.setAuthor(author);
        bookToUpdate.setPrice(price);
    }
}
