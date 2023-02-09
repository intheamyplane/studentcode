package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public File run() {

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String pathToSourceFile = userInput.nextLine();

        System.out.println("What is the destination file?");
        String pathToDestinationFile = userInput.nextLine();


        File sourceFile = new File(pathToSourceFile);
        File destinationFile = new File(pathToDestinationFile);


        try (Scanner sourceInput = new Scanner(sourceFile); PrintWriter writer = new PrintWriter(destinationFile)) {

            while (sourceInput.hasNextLine()) {

                String lineOfInput = sourceInput.nextLine();
                String convertedLine = "";
                if (lineOfInput.contains(searchWord)) {
                    convertedLine = lineOfInput.replaceAll(searchWord, replacementWord);
                } else {
                    convertedLine = lineOfInput;
                }
                writer.println(convertedLine);
            }


        } catch (FileNotFoundException e) {

            System.out.println("The file was not found");

        }return null;
    }
}





