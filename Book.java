package edu.monmouth.hw6;

import java.util.Objects;

public class Book implements Comparable<Book> {

    int numberOfPages;
    BookTypes bookType;
    String Title;
    double price;

    @Override
    public String toString() {
        return "Book{" +
                "numberOfPages=" + numberOfPages +
                ", bookType=" + bookType +
                ", Title='" + Title + '\'' +
                ", price=" + price +
                '}';
    }

    public Book(String Title, BookTypes bookType, int numberOfPages, double price) throws BookException{
        setNumberOfPages(numberOfPages);
        setBookType(bookType);
        setPrice(price);
        setTitle(Title);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("In Book equals...");
        if (o == null) {
            return false;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Book otherBook = (Book) o;
        return otherBook.numberOfPages == numberOfPages &&
                otherBook.price == price &&
                otherBook.bookType == bookType &&
                otherBook.Title.equals(Title);
    }

        @Override
        public int hashCode () {
            return Objects.hash(numberOfPages, bookType, Title);
        }

        public void setNumberOfPages ( int numberOfPages) throws BookException {
            if (numberOfPages < 1) {
                throw new BookException("Book must have 1 or more pages");
            }
            this.numberOfPages = numberOfPages;
        }

        public void setBookType (BookTypes bookType){
            this.bookType = bookType;
        }

        public String getTitle () {
            return Title;
        }

        public void setTitle (String title) throws BookException {
            if ((title == null) || (title.length() < 1)) {
                throw new BookException("Book must have a title");
            }
            Title = title;
        }

        public double getPrice () {
            return price;
        }

        public void setPrice ( double price) throws BookException {
            if (price <= 0) {
                throw new BookException("Price must be positive value");
            }
            this.price = price;
        }

    public int compareTo(Book otherBook) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        if (this == otherBook) {
            return EQUAL;
        }
        //System.out.println("In Book's compareTo");
        if (this.numberOfPages < otherBook.numberOfPages) {
            return BEFORE;
        }
        if (this.numberOfPages > otherBook.numberOfPages) {
            return AFTER;
        }
        if (this.price < otherBook.price) {
            return BEFORE;
        }
        if (this.price > otherBook.price) {
            return AFTER;
        }
        return this.Title.compareTo(otherBook.Title);
    }
}
