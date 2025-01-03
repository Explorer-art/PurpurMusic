package org.truzme;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PurpurMusic {
	public static void main(String[] args) {
		Config config;

		try {
			File fileConfig = new File("config.json");

			if (!fileConfig.exists() && !fileConfig.isDirectory()) {
				ConfigLoader.createConfig(fileConfig);
			}

			config = ConfigLoader.load(fileConfig);

			File dirSounds = new File(config.getSoundsDir());

			if (!dirSounds.exists()) {
				dirSounds.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (args.length < 1) {
			System.out.println("Usage:");
			System.out.println("java -jar PurpurMusic.jar [query]");
			return;
		}

		List<Track> track_list = Hitmo.search(args[0]);

		for (int i = 0; i < track_list.size(); i++) {
			System.out.printf("%d. Title: %s\n", i + 1, track_list.get(i).title());
			System.out.printf("    Description: %s\n", track_list.get(i).description());
			System.out.printf("    Duration: %s\n", track_list.get(i).duration());
			System.out.printf("    URL: %s\n", track_list.get(i).url());
			System.out.printf("    Download URL: %s\n\n", track_list.get(i).downloadUrl());
		}

		System.out.printf("Total results: %d\n\n", track_list.size());

		Scanner in = new Scanner(System.in);

		System.out.print("> ");
		int downloadTrack = in.nextInt() - 1;

		System.out.printf("Track %s downloading...\n", track_list.get(downloadTrack).title());
		track_list.get(downloadTrack).download("track.mp3");
		System.out.printf("Track %s downloaded!\n", track_list.get(downloadTrack).title());

		in.close();
	}
}