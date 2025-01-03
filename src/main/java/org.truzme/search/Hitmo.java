package org.truzme;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Hitmo {
	private static String base_url = "https://rus.hitmotop.com";

	public static ArrayList<Track> search(String query) {
		ArrayList<Track> results = new ArrayList<>();

		try {
			Document document = Jsoup.connect(base_url + "/search?q=" + query.replace(' ', '+')).get();

			Elements track_list = document.select("ul.tracks__list").first().select("li");

			if (track_list.isEmpty()) {
				return results;
			}

			for (Element track : track_list) {
				String trackTitle = track.select("div.track__title").text().strip();
				String trackDescription = track.select("div.track__desc").text();
				String trackFullTime = track.select("div.track__fulltime").text();
				String trackUrl = base_url + track.select("a.track__info-l").attr("href");
				String trackDownloadUrl = track.select("a.track__download-btn").attr("href");

				Track trackData = new Track(
					trackTitle,
					trackDescription,
					trackFullTime,
					trackUrl,
					trackDownloadUrl
				);

				results.add(trackData);
			}

			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}
}