package br.edu.ifsc.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Error extends Application {

	private String message;

	public Error(String message) {
		this.message = message;
	}

	@Override
	public void start(Stage stage) throws Exception {
		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(280, 120);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		Label lblMessage = new Label(message);
		lblMessage.setLayoutX(10);
		lblMessage.setLayoutY(10);

		// creating the login button
		Button btnOk = new Button(Strings.btnOk);
		btnOk.setLayoutX(167);
		btnOk.setLayoutY(10);
		btnOk.setOnMouseClicked(e -> close(stage));

		// adding all created components to the pane
		pane.getChildren().add(lblMessage);
		pane.getChildren().add(btnOk);

		// applying the LIGHT style from the JMetro library to the pane
		new JMetro(JMetro.Style.LIGHT).applyTheme(pane);
		
		stage.show();
	}

	private void close(Stage stage) {
		stage.close();
	}

}
