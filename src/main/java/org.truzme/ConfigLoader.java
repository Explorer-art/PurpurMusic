package org.truzme;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigLoader {
	public static void createConfig(File file) {
		Config config;

		try {
			config = new Config("sounds");
			ObjectMapper objectMapper = new ObjectMapper();

			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Config load(File file) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			Config config = objectMapper.readValue(file, Config.class);

			return config;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}