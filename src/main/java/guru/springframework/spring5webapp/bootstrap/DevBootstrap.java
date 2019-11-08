package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Publisher publisher = new Publisher();
        publisher.setName("harper");
        publisher.setAddress("8361 avenue 5");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("BDD", "1234", publisher);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);


        //Rod
        Publisher publisher2 = new Publisher();
        publisher2.setName("home");
        publisher2.setAddress("8372 avenue 6");

        publisherRepository.save(publisher2);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EEE dev", "3456", publisher2);
        rod.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);


    }


}
