package org.deepti.tuts.GraphQLTuts.respository;

import org.deepti.tuts.GraphQLTuts.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findDistinctFirstByFirstName(String firstName);
}
