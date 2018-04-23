package org.deepti.tuts.GraphQLTuts.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.deepti.tuts.GraphQLTuts.model.Author;
import org.deepti.tuts.GraphQLTuts.model.Book;
import org.deepti.tuts.GraphQLTuts.respository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}
