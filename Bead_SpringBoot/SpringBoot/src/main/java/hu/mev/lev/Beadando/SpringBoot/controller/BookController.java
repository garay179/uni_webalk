package hu.mev.lev.Beadando.SpringBoot.controller;

import hu.mev.lev.Beadando.SpringBoot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("addBook")
    @ResponseBody
    public void addBook(@Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
        {
            System.out.println(bindingResult.getAllErrors());
        }
        else
        {
            bookService.addBook(bookDTO);
        }
    }

    @GetMapping("books")
    @ResponseBody
    public List<BookDTO> bookEntities() {
        return bookService.getAllBooks();
    }
}
