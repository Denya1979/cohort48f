package homework_24.ait.book_library.dao;

import homework_24.ait.book_library.model.Book;

public interface Library {
    //add a book to library
    boolean addBook(Book book);

    //remove book from library
    Book removeBook(long isbn);

    //find a book in library
    Book findBook(long isbn);

    //count books in library
    int quantity();

    //print out all books in library
    void printBooks();

    //find all books from author
    Book[] ofAuthor(String author);

    //find all books from year 1 to year 2
    Book[] findByYear(int year1, int year2);

}
