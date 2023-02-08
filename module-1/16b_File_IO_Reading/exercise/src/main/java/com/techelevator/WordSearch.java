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

		File userTextToSearch = new File(filePath);

		System.out.println("What is the search word you are looking for?");
		String searchWord = userInput.nextLine();

		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseSensitiveSearchWord = userInput.nextLine();

		if(caseSensitiveSearchWord=="Y"){
		boolean caseSensitive = true;}


		boolean inUserText = false;
		int lineCount = 0;

		try (Scanner inputStream = new Scanner(userTextToSearch)) {
			while (inputStream.hasNextLine()) {
				String lineOfText = inputStream.nextLine();
				if (lineOfText.startsWith(BEGINNING)) {
					inUserText = true;
					continue;
				}
				if (lineOfText.endsWith(ENDING)) {
					break;
				}

				if (inUserText) {
					lineCount++;


				}
				if (lineOfText.contains(searchWord)) {
					System.out.println(lineCount + ") " + lineOfText);


				}

			}
			}catch (FileNotFoundException e){
			System.out.println("file not found"+ userTextToSearch.getAbsolutePath());
		}
		}
	}
