package backend.spring.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.spring.graphql.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{

}
