package org.truzme;

import java.net.URL;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

public class Track {
	private String title;
	private String description;
	private String duration;
	private String url;
	private String downloadUrl;

	public Track(String title, String description, String duration, String url, String downloadUrl) {
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.url = url;
		this.downloadUrl = downloadUrl;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getDuration() {
		return duration;
	}

	public String getUrl() {
		return url;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void download(String filePath) {
		try (BufferedInputStream in = new BufferedInputStream(new URL(downloadUrl).openStream())) {
			FileOutputStream out = new FileOutputStream(filePath);

			byte[] buffer = new byte[1024];
			int bytesRead;

			while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}