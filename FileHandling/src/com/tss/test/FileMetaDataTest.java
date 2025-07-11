package com.tss.test;

import java.io.File;

public class FileMetaDataTest {

	public static void main(String[] args) {

		File file = new File("Directory");
		printNames(file);

	}

	private static void printNames(File file) {
		File[] filelist;

		boolean isDirectory = file.isDirectory();

		if (!isDirectory) {
			System.out.println("Total length of File " + file.getName() + "is => " + file.length());
		} else {
			filelist = file.listFiles();
			if (filelist != null) {
				for (File files : filelist) {
					printNames(files);
				}
			}
			System.out.println(file.getName());

		}
	}
}
