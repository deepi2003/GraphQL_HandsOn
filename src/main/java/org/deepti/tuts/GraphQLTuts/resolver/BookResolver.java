package org.deepti.tuts.GraphQLTuts.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.deepti.tuts.GraphQLTuts.errorhandler.AuthorNotFoundException;
import org.deepti.tuts.GraphQLTuts.model.Author;
import org.deepti.tuts.GraphQLTuts.model.Book;
import org.deepti.tuts.GraphQLTuts.respository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book)  {
        Author author =  authorRepository.findOne(book.getAuthor().getId());
        if(author == null) {
            throw new AuthorNotFoundException("Author not found", book.getAuthor().getId());
        }
        return author;
    }
}
