package homework_24.ait.book_library.dao;

import homework_24.ait.book_library.model.Book;

public class LibraryImpl implements Library {

    private Book[] books;
    private int size;

    public LibraryImpl(int capacity) {
        this.books = new Book[capacity];
        this.size = 0;
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null || size == books.length || findBook(book.getIsbn()) != null) {
            return false;
        } else {
            books[size] = book;
            size++;
            return true;
        }
    }

    @Override
    public Book removeBook(long isbn) {
        Book victim = null;
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                victim = books[i];
                for (int j = i; j < size - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[size - 1] = null;
                size--;
                break;
            }
        }
        return victim;
    }

    @Override
    public Book findBook(long isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    @Override
    public Book[] ofAuthor(String author) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(author)) {
                count++;
            }
        }
        Book[] booksOfAuthor = new Book[count];
        for (int i = 0, j = 0; j < booksOfAuthor.length; i++) {
            if (books[i].getAuthor().equals(author)) {
                booksOfAuthor[j++] = books[i];
            }
        }
        return booksOfAuthor;
    }

    @Override
    public Book[] findByYear(int year1, int year2) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getYearOfPublishing() >= year1 && books[i].getYearOfPublishing() <= year2) {
                count++;
            }
        }
        Book[] booksByYear = new Book[count];
        for (int i = 0, j = 0; j < booksByYear.length; i++) {
            if (books[i].getYearOfPublishing() >= year1 && books[i].getYearOfPublishing() <= year2) {
                booksByYear[j++] = books[i];
            }
        }
        return booksByYear;
    }
}
