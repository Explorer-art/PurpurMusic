package org.truzme;

public class Track {
	String title;
	String description;
	String fullTime;
	String url;
	String downloadUrl;

	Track(String title, String description, String fullTime, String url, String downloadUrl) {
		this.title = title;
		this.description = description;
		this.fullTime = fullTime;
		this.url = url;
		this.downloadUrl = downloadUrl;
	}
}