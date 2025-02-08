import library.Book;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//junit test case pentru book
class booktest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Titlu Test", "Autor Test", "2020", 10, "Fictiune");
    }

    @Test
    void testConstructor() {
        assertEquals("titlu test", book.getTitle());
        assertEquals("autor test", book.getAuthor());
        assertEquals("2020", book.getYear());
        assertEquals(10, book.getStock());
        assertEquals(10, book.getcurrentStock());
        assertEquals("drama", book.getGenre());
    }

    @Test
    void testGetAndSetStock() {
        book.setStock(15);
        assertEquals(15, book.getStock());
    }

    @Test
    void testGetAndSetCurrentStock() {
        book.setCurrentStock(5);
        assertEquals(5, book.getcurrentStock());
    }

    @Test
    void testToString() {
        String expected = "Titlu Test de Autor Test (2020) - Fictiune - stoc: 10";
        assertEquals(expected, book.toString());
    }
}
