package hu.mev.lev.Beadando.SpringBoot.controller;

import hu.mev.lev.Beadando.SpringBoot.persist.AuthorEntity;
import hu.mev.lev.Beadando.SpringBoot.service.AuthorService;
import hu.mev.lev.Beadando.SpringBoot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {
    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("addAuthor")
    @ResponseBody
    public void addAuthor(@Valid @RequestBody AuthorEntity authorEntity, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            System.out.println(bindingResult.getAllErrors());
        }
        else
        {
            authorService.addAuthor(authorEntity);
        }
    }

    @GetMapping("authors")
    @ResponseBody
    public List<AuthorEntity> authorEntities() {
        return authorService.getAuthors();
    }

    @GetMapping("authorName")
    @ResponseBody
    public List<String> authorNames() {
        List<String> names = new ArrayList<>();
        for (AuthorEntity authorEntity: authorService.getAuthors()) {
            names.add(authorEntity.getName());
        }
        return authorNames();
    }

    @PostMapping("author")
    @ResponseBody
    public void getBooksByAuthor(@Valid @RequestBody Long ID, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        }
        else
        {
            bookService.getBooksByAuthorID(ID);
        }
    }

}
