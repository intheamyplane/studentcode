package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);
    static private final String BEGINNING = "*** START OF";
    static private final String ENDING = "*** END OF";

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.run();
    }

    public void run() {
        System.out.println("What is the fully qualified name of the file that should be searched?");
        String filePath = userInput.nextLine();

        File userFile = new File(filePath);

        System.out.println("What is the search word you are looking for?");
        String searchWord = userInput.nextLine();

        System.out.println("Should the search be case sensitive? (Y\\N)");
        String caseSensitiveSearchWord = userInput.nextLine();


//        boolean caseSensitive = true;
//
//        if (caseSensitiveSearchWord == "N") {
//            caseSensitive = false;
//        }

        try (Scanner inputStream = new Scanner(userFile)) {
            int lineCount = 1;
            while (inputStream.hasNextLine()) {
                String lineOfText = inputStream.nextLine();


                if (caseSensitiveSearchWord.equals("N")) {
                    if (lineOfText.toLowerCase().contains(searchWord.toLowerCase())) {
                        System.out.println(lineCount + ") " + lineOfText);
                    }
                } else {
                    if (lineOfText.contains(searchWord)) {
                        System.out.println(lineCount + ") " + lineOfText);
                    }
                }
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found" + userFile.getAbsolutePath());
        }

    }
}
