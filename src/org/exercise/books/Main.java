package org.exercise.books;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.println("*******************************");
        System.out.println("   Welcome in java Books");
        System.out.println("*******************************");

        System.out.println();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();

        System.out.print("Number of pages: ");
        int numPages = Integer.parseInt(scanner.nextLine());

        try {
            Book book = new Book(title, author, publisher, numPages);
        } catch (NullPointerException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        scanner.close();
    }


}
