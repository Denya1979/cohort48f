package homework_24.ait.book_library.model;

import java.util.StringJoiner;

public class Dictionary extends Book{
    private String language;

    public Dictionary(String title, String author, int yearOfPublishing, long isbn, String language) {
        super(title, author, yearOfPublishing, isbn);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
