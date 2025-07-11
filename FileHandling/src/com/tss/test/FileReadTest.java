package com.tss.test;

import java.io.*;

public class FileReadTest {

	public static void main(String[] args) {

		int charCount = 0;
		int wordCount = 0;
		int lineCount = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();

				System.out.println(line);

				lineCount++;
				charCount += line.length();
				if (line.trim().isEmpty()) {
					wordCount += 0;
				} else {
					wordCount += line.trim().split("\\s+").length;
				}
			}

			System.out.println("\nFile copied successfully");
			System.out.println("Characters: " + charCount);
			System.out.println("Words: " + wordCount);
			System.out.println("Lines: " + lineCount);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
