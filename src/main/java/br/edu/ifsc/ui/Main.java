package br.edu.ifsc.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Main extends Application {

	private String username;

	public Main(String username) {
		this.username = username;
	}

	@Override
	public void start(Stage stage) throws Exception {
		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(640, 480);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		Label lblMain = new Label(Strings.lblMain + " " + username);
		lblMain.setLayoutX(10);
		lblMain.setLayoutY(10);

		// adding all created components to the pane
		pane.getChildren().add(lblMain);

		// applying the LIGHT style from the JMetro library to the pane
		new JMetro(JMetro.Style.LIGHT).applyTheme(pane);

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

}
