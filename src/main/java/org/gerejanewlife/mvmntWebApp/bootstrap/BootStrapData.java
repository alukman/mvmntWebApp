package org.gerejanewlife.mvmntWebApp.bootstrap;

import org.gerejanewlife.mvmntWebApp.domain.Author;
import org.gerejanewlife.mvmntWebApp.domain.Book;
import org.gerejanewlife.mvmntWebApp.domain.Publisher;
import org.gerejanewlife.mvmntWebApp.repositories.AuthorRepository;
import org.gerejanewlife.mvmntWebApp.repositories.BookRepository;
import org.gerejanewlife.mvmntWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher addisonWesley = new Publisher(
                "Addison Wesley Publishing Company",
                "75 Arlington Street",
                "Boston",
                "MA",
                02116);
        publisherRepository.save(addisonWesley);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain-driven Design", "9780321125217");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(addisonWesley);
        addisonWesley.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(addisonWesley);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("Expert One-on-One J2EE Development Without EJB", "9780470332962");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(addisonWesley);
        addisonWesley.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(addisonWesley);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of books: " + addisonWesley.getBooks().size());

    }
}
