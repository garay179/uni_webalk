package hu.me.lev;

import hu.me.lev.exception.BookNameAlreadyTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value="/addBook")
    public void addBook(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("price") int price) throws BookNameAlreadyTakenException {
        bookService.addBook(new Book(id, name, author, price));
    }

    @RequestMapping(value="/updateBook")
    public void updatebook(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("price") int price)
    {
        bookService.updateBook(id, name, author ,price);
    }

    @RequestMapping(value="/Books")
    public String getAllBooks()
    {
        return bookService.getAllTheBooks().toString();
    }
}
