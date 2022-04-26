package edu.monmouth.hw6;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class hw6 {
    public static void main(String args[]) {

        Set<Book> treeSet = new TreeSet<>();
        Set<Book> treePrice = new TreeSet<Book>(new BookPrice());


        if(args.length!=1){
            System.err.println("Enter valid filename ");
            System.exit(-1);
        }

        try {
            File file = new File("/Users/user/IdeaProjects/HW6/books.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length != 4) {
                    System.out.println("Error reading in data");
                }

                    String Title = bookData[0];
                    BookTypes type = BookTypes.valueOf(bookData[1]);
                    int pages = Integer.parseInt(bookData[2]);
                    double price = Double.parseDouble(bookData[3]);

                    try {
                        Book book = new Book(Title, type, pages, price);
                        treeSet.add(book);
                        treePrice.add(book);
                    }catch(BookException e){
                        System.out.println("cannot make book");
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(treeSet);
        System.out.println(treePrice);
        }
    }
