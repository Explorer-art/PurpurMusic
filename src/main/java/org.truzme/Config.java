package org.truzme;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Config {
	@JsonProperty("sounds_dir")
	private String soundsDir;

	public Config() {
	}

	public Config(String soundsDir) {
		this.soundsDir = soundsDir;
	}

	public String getSoundsDir() {
		return soundsDir;
	}
}