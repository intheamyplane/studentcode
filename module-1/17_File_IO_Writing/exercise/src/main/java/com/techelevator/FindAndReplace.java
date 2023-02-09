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


        File sourceFile = new File(pathToSourceFile);
        File convertedFile = getConvertedFile(sourceFile);

        try (Scanner sourceInput = new Scanner(sourceFile); PrintWriter writer = new PrintWriter(convertedFile)) {

            while (sourceInput.hasNextLine()) {

                String lineOfInput = sourceInput.nextLine();
                writer.println(lineOfInput.replace(searchWord, replacementWord));


            }
        } catch (FileNotFoundException e) {

            System.out.println("The file was not found: " + sourceFile.getAbsolutePath());

        }


        static private File getConvertedFile(File sourceFile) {

            String filePath = sourceFile.getAbsolutePath();

            int dotIndex = filePath.lastIndexOf('.');
            String convertedPath;
            if (dotIndex >= 0) {
                convertedPath = filePath.substring(0, dotIndex) + ".screaming." + filePath.substring(dotIndex + 1);
            } else {
                convertedPath = filePath + ".screaming";
            }
            return new File(convertedPath);
        }



        }






    }


