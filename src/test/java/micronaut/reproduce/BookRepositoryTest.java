package micronaut.reproduce;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(transactional = false)
class BookRepositoryTest {
    @Inject
    private BookRepository bookRepository;

    @Test
    void testGetBooks() {
        StepVerifier.create(bookRepository.getBooks())
                .assertNext(book -> assertEquals("Title #1", book.getTitle()))
                .assertNext(book -> assertEquals("Title #2", book.getTitle()))
                .verifyComplete();
    }

    @Test
    void testGetBooksDto() {
        StepVerifier.create(bookRepository.getBooksAsDto())
                .assertNext(book -> assertEquals("Title #1", book.title()))
                .assertNext(book -> assertEquals("Title #2", book.title()))
                .verifyComplete();
    }
}
