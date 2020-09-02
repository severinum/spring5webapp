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
        Publisher publisher = new Publisher("APress", "Somestreet 20", "Newark", "New York", "NY2233823");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driver Design", "123456789");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noJBS = new Book("J2EE Development", "8383827273882");
        rod.getBooks().add(noJBS);
        noJBS.getAuthors().add(rod);
        noJBS.setPublisher(publisher);
        publisher.getBooks().add(noJBS);
        authorRepository.save(rod);
        bookRepository.save(noJBS);
        publisherRepository.save(publisher);


        Author collin = new Author("Collin", "Power");
        authorRepository.save(collin);


        System.out.println("Started in Bootstrap.");
        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Number of Authors : " + authorRepository.count());
        System.out.println("Number of Publishers : " + publisherRepository.count());
        System.out.println("Publisher " + publisher.getName() + " books number : " + publisher.getBooks().size());

    }
}
