package hu.mev.lev.Beadando.SpringBoot.persist;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
