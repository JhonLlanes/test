package ec.llanes.objrestdatajpa.repository;

import ec.llanes.objrestdatajpa.modelo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
