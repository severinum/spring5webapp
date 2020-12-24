package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started bootstrap ...");

        Publisher publisher = new Publisher();
        publisher.setName("Vrox Publishing");
        publisher.setCity("Los Angeles");
        publisher.setState("CA");
        publisher.setAddressLine1("90210 Beverly Hills");

        publisherRepository.save(publisher);


        // Author
        Author eri = new Author("Eric", "Bubu");
        // Book
        Book ddd = new Book("Domain Driven Design" , "12345678910");
        // set publisher to the book
        ddd.setPublisher(publisher);
        // set book to the publisher
        publisher.getBooks().add(ddd);
        // set Book to Author
        eri.getBooks().add(ddd);
        // set Author to the Book
        ddd.getAuthors().add(eri);
        // save author
        authorRepository.save(eri);
        // save book
        bookRepository.save(ddd);
        // save publisher
        publisherRepository.save(publisher);

        // Author
        Author rod = new Author("Rod", "Johnson");
        // Book
        Book noEJB = new Book("J2EE Dev", "234567811");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        // Book
        Book someBook = new Book("Somebook", "726352612");
        rod.getBooks().add(someBook);
        someBook.getAuthors().add(rod);
        bookRepository.save(someBook);


        System.out.println("Boostrap started ....");
        System.out.println("Total number of books in DB: " + bookRepository.count());

        System.out.println("Publisher " + publisher.getName() + " number of books : " + publisher.getBooks().size());

    }
}
