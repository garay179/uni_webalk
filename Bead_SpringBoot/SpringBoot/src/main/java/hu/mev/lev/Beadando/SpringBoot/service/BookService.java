package hu.mev.lev.Beadando.SpringBoot.service;

import hu.mev.lev.Beadando.SpringBoot.controller.BookDTO;
import hu.mev.lev.Beadando.SpringBoot.persist.BookEntity;
import hu.mev.lev.Beadando.SpringBoot.persist.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public void addBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setISDN(bookDTO.getISDN());
        bookEntity.setName(bookDTO.getName());
        bookEntity.setHowMany(bookDTO.getHowMany());
        bookEntity.setAuthorEntity(authorService.getAuthor(bookDTO.getAuthor_id()));
        bookRepository.save(bookEntity);
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (BookEntity bookEntity :bookRepository.findAll()) {
            bookDTOList.add(new BookDTO(bookEntity.getISDN(), bookEntity.getName(), bookEntity.getHowMany(), bookEntity.getAuthorEntity().getID()));
        }
        return bookDTOList;
    }

    public List<BookEntity> getBooksByAuthorID(Long AuthorID) {
        List<BookEntity> books = new ArrayList<>();
        for (BookEntity bookentity :bookRepository.findAll()) {
             if(bookentity.getAuthorEntity().getID().equals(AuthorID))
             {
                 books.add(bookentity);
             }
        }
        return books;
    }
}
