package org.deepti.tuts.GraphQLTuts.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.deepti.tuts.GraphQLTuts.model.Author;
import org.deepti.tuts.GraphQLTuts.model.AuthorFilter;
import org.deepti.tuts.GraphQLTuts.model.Book;
import org.deepti.tuts.GraphQLTuts.respository.AuthorRepository;
import org.deepti.tuts.GraphQLTuts.respository.BookRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Book> allBooksByAuthor(AuthorFilter authorFilter, int skip, int first) {
        String authorName = authorFilter.getAuthorName();
        List<Author> authorList = authorRepository.findAllByFirstName(authorName);
        if(authorList.size() > 0) {
            return authorList.stream()
                    .map(Author::getId)
                    .collect(Collectors.toList())
                    .stream()
                    .map(id -> bookRepository.findBooksByAuthor_Id(id))
                    .flatMap(list -> list.stream())
                    .skip(skip)
                    .limit(first)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
