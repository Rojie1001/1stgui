package br.edu.ifsc.ui;

import org.controlsfx.control.Rating;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Login extends Application {
	private Button btnLogin;
	private TextField txtUsername;
	private Rating rating;
	private Label lblLogin;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(280, 120);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		lblLogin = new Label(Strings.lblLogin);
		lblLogin.setLayoutX(10);
		lblLogin.setLayoutY(10);

		// creating the username textfield
		txtUsername = new TextField();
		txtUsername.setLayoutX(10);
		txtUsername.setLayoutY(31);
		txtUsername.setMaxWidth(150);
		txtUsername.setMinWidth(150);
		txtUsername.setPrefWidth(150);

		// creating the login button
		btnLogin = new Button(Strings.btnLogin);
		btnLogin.setLayoutX(167);
		btnLogin.setLayoutY(30);
		btnLogin.setOnMouseClicked(e -> login(stage, (int) rating.getRating())); // setting the button behavior using a
																					// lambda expression

		// creating the rating component, a controlsfx library control
		rating = new Rating();
		rating.setUpdateOnHover(true);
		rating.setLayoutX(10);
		rating.setLayoutY(70);
		rating.setPrefWidth(10);
		rating.setRating(0);
		rating.setMax(7);

		// adding all created components to the pane
		pane.getChildren().add(lblLogin);
		pane.getChildren().add(btnLogin);
		pane.getChildren().add(txtUsername);
		pane.getChildren().add(rating);

		// applying the LIGHT style from the JMetro library to the pane
		new JMetro(JMetro.Style.LIGHT).applyTheme(pane);

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

	private void login(Stage stage, int password) {

		if (txtUsername.getText().isEmpty()) {
			try {
				new Error(Strings.loginError).start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}

		if (password != 3) {
			try {
				new Error(Strings.passwordError).start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}

		try {
			new Main(txtUsername.getText()).start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
