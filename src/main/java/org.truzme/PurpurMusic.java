package org.truzme;

import java.util.ArrayList;

public class PurpurMusic {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage:");
			System.out.println("java -jar PurpurMusic.jar [query]");
			return;
		}

		ArrayList<Track> track_list = Hitmo.search(args[0]);

		for (Track track : track_list) {
			System.out.printf("Title: %s\n", track.title);
			System.out.printf("Description: %s\n", track.description);
			System.out.printf("Full time: %s\n", track.fullTime);
			System.out.printf("URL: %s\n", track.url);
			System.out.printf("Download URL: %s\n\n", track.downloadUrl);
		}

		System.out.printf("Total results: %d\n", track_list.size());
	}
}