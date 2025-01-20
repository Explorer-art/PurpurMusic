package org.truzme;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
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

        PurpurMusicFX.main(args);
    }
}