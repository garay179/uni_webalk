package hu.mev.lev.Beadando.SpringBoot.service;

import hu.mev.lev.Beadando.SpringBoot.persist.AuthorEntity;
import hu.mev.lev.Beadando.SpringBoot.persist.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    public List<AuthorEntity> getAuthors() {
        return (List<AuthorEntity>) authorRepository.findAll();
    }

    public AuthorEntity getAuthor(Long id) {
        return authorRepository.findById(id).get();
    }
}
