package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class wordCount {

    private static int wordCount(String input) throws FileNotFoundException {
        // read input from command line in the format file_name
        File file ;
        Optional<Scanner> optionalfileScanner = Optional.empty();
        int totalWords = 0;
        //open the file, read through each line and count the number of words in each line
        //print the number of words in each line
        //print the total number of words in the file
        try {
            file = new File(input);
            optionalfileScanner = Optional.of(new Scanner(file));
            while (optionalfileScanner.get().hasNextLine()) {
                String line = optionalfileScanner.get().nextLine();
                // split the line into words
                String[] words = line.trim().split("[=,\\s\\!\\']+");
                Stream.of(words).forEach(System.out::println);
                totalWords = totalWords + words.length;
            }
            System.out.println("The total number of words in the file is: " + totalWords);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            if (optionalfileScanner.isPresent())
                optionalfileScanner.get().close();
        }
        return totalWords;
    }
    public static void main(String[] args) throws FileNotFoundException {

        // read input from command line in the format file_name
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        // check if the input is in the format fileName.txt
        if (input.matches("^[a-zA-Z0-9]+\\.txt$")) {
            System.out.println("The input is in the correct format [ filename.txt ]");
        } else {
            System.out.println("The input is not in the correct format [ filename.txt ]");
        }
        wordCount(input);

    }
}