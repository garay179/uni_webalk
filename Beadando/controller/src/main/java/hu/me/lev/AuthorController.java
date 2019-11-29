package hu.me.lev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value="/authorName")
    public String getAuthorNames()
    {
        String authorNames = "";
        int size = authorService.getAllTheAuthors().size();
        for(int i=0; i<size; i++)
        {
            authorNames += " | " + authorService.getAllTheAuthors().get(i).name + " | ";
        }
        return authorNames;
    }

    @RequestMapping(value="/authors")
    public String getAllAuthors()
    {
        return authorService.getAllTheAuthors().toString();
    }

    @RequestMapping(value="/addAuthor")
    public void addAuthor(String name, int age, String writtenbook)
    {
        authorService.addAuthor(new Author(name, age, writtenbook));
    }
}
