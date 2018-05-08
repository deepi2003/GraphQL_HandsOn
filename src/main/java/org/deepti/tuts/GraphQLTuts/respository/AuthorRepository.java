package org.deepti.tuts.GraphQLTuts.respository;

import org.deepti.tuts.GraphQLTuts.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findDistinctFirstByFirstName(String firstName);
    List<Author> findAllByFirstName(String firstName);
}
