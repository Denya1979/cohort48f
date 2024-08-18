package homework_24.ait.book_library.test;

import homework_24.ait.book_library.dao.Library;
import homework_24.ait.book_library.dao.LibraryImpl;
import homework_24.ait.book_library.model.Book;
import homework_24.ait.book_library.model.Catalog;
import homework_24.ait.book_library.model.Dictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class LibraryImplTest {

    Library library;
    Book[] books;

    @BeforeEach
    void setUp() {
        library = new LibraryImpl(5);
        books = new Book[5];
        books[0] = new Dictionary("Title 1", "Author 1", 2002, 1_111_111_111_112L,"French");
        books[1] = new Dictionary("Title 2", "Author 2", 1985, 1_111_111_111_113L,"Italian");
        books[2] = new Catalog("Title 3", "Author 1", 1999, 1_111_111_111_114L,"Table","F-0452-2023",43.99);
        books[3] = new Catalog("Title 4", "Author 4", 2016, 1_111_111_111_115L,"Wardrobe","F-0453-2023",149.99);

        for (int i = 0; i < books.length; i++) {
            library.addBook(books[i]);
        }

    }

    @Test
    void addBook() {
        assertFalse(library.addBook(null));
        assertFalse(library.addBook(books[0]));
        Book myBook = new Dictionary("Titel 5", "Author 5",1998,1_111_111_111_116L,"English");
        assertTrue(library.addBook(myBook));
        assertEquals(5,library.quantity());
        myBook = new Catalog("Titel 6", "Author 6",2024,1_111_111_111_117L,"Sofa","F-0451-2023",529.99);
        assertFalse(library.addBook(myBook));
    }

    @Test
    void removeBook() {
        Book victim = library.removeBook(1_111_111_111_113L);
        assertEquals(books[1],victim);
        assertEquals(3,library.quantity());
        assertNull(library.removeBook(1_111_111_111_113L));
    }

    @Test
    void findBook() {
        Assertions.assertEquals(books[1],library.findBook(1_111_111_111_113L));
        assertNull(library.findBook(2_111_111_111_113L));
    }

    @Test
    void quantity() {
        assertEquals(4,library.quantity());
    }

    @Test
    void printBooks() {
        library.printBooks();
    }

    @Test
    void ofAuthor() {
        Book[] expected = {books[0],books[2]};
        Book[] actual = library.ofAuthor("Author 1");
        assertArrayEquals(expected,actual);
    }

    @Test
    void findByYear(){
        Book[] expected = {books[1],books[2]};
        Book[] actual = library.findByYear(1980,2000);
        assertArrayEquals(expected,actual);
    }

}