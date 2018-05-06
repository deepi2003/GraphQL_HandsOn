package org.deepti.tuts.GraphQLTuts.respository;

import org.deepti.tuts.GraphQLTuts.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findBooksByAuthor_Id(long id);
}


