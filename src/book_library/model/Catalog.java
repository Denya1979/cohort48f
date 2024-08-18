package homework_24.ait.book_library.model;

import java.util.StringJoiner;

public class Catalog extends Book{

    private String productName;
    private String productArticle;
    private double price;

    public Catalog(String title, String author, int yearOfPublishing, long isbn, String productName, String productArticle, double price) {
        super(title, author, yearOfPublishing, isbn);
        this.productName = productName;
        this.productArticle = productArticle;
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductArticle(String productArticle) {
        this.productArticle = productArticle;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
