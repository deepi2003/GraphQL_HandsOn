package org.deepti.tuts.GraphQLTuts.respository;

import org.deepti.tuts.GraphQLTuts.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }
