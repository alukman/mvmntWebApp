package org.gerejanewlife.mvmntWebApp.bootstrap;

import org.gerejanewlife.mvmntWebApp.domain.Author;
import org.gerejanewlife.mvmntWebApp.domain.Book;
import org.gerejanewlife.mvmntWebApp.repositories.AuthorRepository;
import org.gerejanewlife.mvmntWebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain-driven Design", "9780321125217");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("Expert One-on-One J2EE Development Without EJB", "9780470332962");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }
}
