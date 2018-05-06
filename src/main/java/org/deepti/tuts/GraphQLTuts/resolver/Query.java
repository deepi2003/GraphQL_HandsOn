package org.deepti.tuts.GraphQLTuts.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.deepti.tuts.GraphQLTuts.model.Author;
import org.deepti.tuts.GraphQLTuts.model.AuthorFilter;
import org.deepti.tuts.GraphQLTuts.model.Book;
import org.deepti.tuts.GraphQLTuts.respository.AuthorRepository;
import org.deepti.tuts.GraphQLTuts.respository.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public Iterable<Book> allBooksByAuthor(AuthorFilter authorFilter) {
        String authorName = authorFilter.getAuthorName();
        long id = authorRepository.findDistinctFirstByFirstName(authorName).getId();
        return bookRepository.findBooksByAuthor_Id(id);
    }
}
