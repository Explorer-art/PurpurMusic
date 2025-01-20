package org.truzme;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PurpurMusicFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		Text logo = new Text("PurpurMusic");
		logo.setLayoutX(10);
		logo.setLayoutY(15);
		logo.setFont(Font.font("Arial", 18));

		Text backgroundSearchText = new Text("Поиск");
		backgroundSearchText.setFont(Font.font("Arial", 18));
		backgroundSearchText.setFill(Color.GRAY);

		TextField search = new TextField();
		search.setLayoutX(1750);
		search.setLayoutY(5);

		Group group = new Group(logo, search);
		Scene scene = new Scene(group);

		stage.setScene(scene);
		stage.setTitle("PurpurMusic");
		stage.setMaximized(true);
		stage.show();
	}
}