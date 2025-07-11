package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.tss.model.Song;

public class SongTest {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		List<Song> songs = new ArrayList<>();

		while (true) {
			System.out.println();
			System.out.println("1. Add a song");
			System.out.println("2. Remove a song");
			System.out.println("3. Search a song");
			System.out.println("4. Display all songs");
			System.out.println("5. Shuffle Playlist");
			System.out.println("6. Exit");

			System.out.print("Enter Choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addSong(songs);
				break;
			case 2:
				removeSong(songs);
				break;
			case 3:
				searchSong(songs);
				break;
			case 4:
				displayAllSongs(songs);
				break;
			case 5:
				shufflePlaylist(songs);
				break;
			case 6:
				System.out.println("Thank you for using Music Player...");
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid choice...");
			}
		}
	}

	private static void shufflePlaylist(List<Song> songs) {
		if (songs.isEmpty()) {
			System.out.println("Playlist is empty.");
			return;
		}
		Collections.shuffle(songs);
		System.out.println("Playlist shuffled successfully.");
	}

	private static void displayAllSongs(List<Song> songs) {
		if (songs.isEmpty()) {
			System.out.println("Playlist is empty.");
			return;
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.printf("| %-20s | %-20s | %-10s |\n", "Title", "Artist", "Duration");
		System.out.println("----------------------------------------------------------------------------------");
		for (Song song : songs) {
			System.out.println(song);
		}
		System.out.println("----------------------------------------------------------------------------------");
	}

	private static void searchSong(List<Song> songs) {
		if (songs.isEmpty()) {
			System.out.println("Playlist is empty.");
			return;
		}
		System.out.print("Enter Title/Artist of song: ");
		String found = scanner.nextLine();
		boolean songFound = false;

		System.out.println("----------------------------------------------------------------------------------");
		System.out.printf("| %-20s | %-20s | %-10s |\n", "Title", "Artist", "Duration");
		System.out.println("----------------------------------------------------------------------------------");

		for (Song song : songs) {
			if (song.getTitle().equalsIgnoreCase(found) || song.getArtist().equalsIgnoreCase(found)) {
				System.out.println(song);
				songFound = true;
			}
		}

		if (!songFound) {
			System.out.println("Song is not in the Playlist...");
		} else {
			System.out.println("----------------------------------------------------------------------------------");
		}
	}

	private static void removeSong(List<Song> songs) {
		if (songs.isEmpty()) {
			System.out.println("Playlist is empty.");
			return;
		}
		System.out.print("Enter Title of song to remove: ");
		String title = scanner.nextLine();
		boolean songFound = false;

		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
				songs.remove(i);
				songFound = true;
				System.out.println("Song removed from playlist...");
				break;
			}
		}
		if (!songFound) {
			System.out.println("Song not found in Playlist...");
		}
	}

	private static void addSong(List<Song> songs) {

		System.out.print("Enter Song Title: ");
		String title = scanner.nextLine();
		System.out.print("Enter Artist: ");
		String artist = scanner.nextLine();
		System.out.print("Enter Song Duration (seconds): ");
		int duration = scanner.nextInt();
		scanner.nextLine();

		for (Song song : songs) {
			if (song.getTitle().equalsIgnoreCase(title) && song.getArtist().equalsIgnoreCase(artist)) {
				System.out.println("Song is already in the playlist.");
				return;
			}
		}

		songs.add(new Song(title, artist, duration));
		System.out.println("Song added to playlist.");
	}
}
