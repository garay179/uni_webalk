package hu.me.lev;

import hu.me.lev.exception.BookNameAlreadyTakenException;

import java.util.ArrayList;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public ArrayList getAllTheBooks() {
        return bookDAO.getEveryBook();
    }

    @Override
    public void addBook(Book book) throws BookNameAlreadyTakenException {
        bookDAO.insertBook(book);
    }

    @Override
    public void updateBook(int id, String name, String author, int price) {
        bookDAO.updateBook(id, name, author, price);
    }
}
