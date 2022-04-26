package edu.monmouth.hw6;

import java.util.Comparator;

public class BookPrice implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        final int BEFORE = -1;
        final int AFTER = 1;

        //System.out.println("bookprice comparator");
        if (o1.getPrice() < o2.getPrice()) {
            return BEFORE;
        }
        if (o1.getPrice() > o2.getPrice()) {
            return AFTER;
        }
        return 0;

    }
}
