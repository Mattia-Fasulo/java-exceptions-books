package org.exercise.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private final static String FILE_PATH = "./storage/file.txt";
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int count = 0;

        System.out.println("*******************************");
        System.out.println("   Welcome in java Books");
        System.out.println("*******************************\n");

        System.out.print("How many books do you want to add? ");
        int numBooks = Integer.parseInt(scanner.nextLine());

        Book[] books = new Book[numBooks];

        System.out.println();



            while (count < numBooks) {
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
                    books[count] = book;
                    System.out.println();
                    count++;

                } catch (NullPointerException | IllegalArgumentException e){

                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println();

                }
            }
        System.out.println();

        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println();

        //salvo l'array in un file di testo
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(FILE_PATH, true);
            for (Book book : books) {
                fileWriter.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Unable to create file");
            System.out.println(e.getMessage());
        } finally {
            // da qui ci passo sempre e chiudo il FileWriter
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        //leggo il contenuto del file di testo

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(FILE_PATH));
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileScanner != null) {
                try {
                    fileScanner.close();
                } catch (IllegalStateException ise) {
                    ise.printStackTrace();
                }
            }
        }

        scanner.close();
    }


}
