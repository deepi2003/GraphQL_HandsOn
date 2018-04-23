package org.deepti.tuts.GraphQLTuts.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.deepti.tuts.GraphQLTuts.model.Author;
import org.deepti.tuts.GraphQLTuts.model.Book;
import org.deepti.tuts.GraphQLTuts.respository.AuthorRepository;
import org.deepti.tuts.GraphQLTuts.respository.BookRepository;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        book.setPageCount(pageCount);
        bookRepository.save(book);
        return book;
    }
}
