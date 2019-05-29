package br.edu.ifsc.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Login extends Application {
	private Button btnLogin;
	private TextField txtUser;
	private TextField txtPass;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(170, 130);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the username textfield
		txtUser = new TextField();
		txtUser.setLayoutX(10);
		txtUser.setLayoutY(10);
		txtUser.setMaxWidth(150);
		txtUser.setMinWidth(150);
		txtUser.setPrefWidth(150);

		// creating the password textfield
		txtPass = new TextField();
		txtPass.setLayoutX(10);
		txtPass.setLayoutY(50);
		txtPass.setMaxWidth(150);
		txtPass.setMinWidth(150);
		txtPass.setPrefWidth(150);

		// creating the login button
		btnLogin = new Button(Strings.btnLogin);
		btnLogin.setLayoutX(10);
		btnLogin.setLayoutY(90);
		btnLogin.setMaxWidth(150);
		btnLogin.setMinWidth(150);
		btnLogin.setPrefWidth(150);
		btnLogin.setOnMouseClicked(e -> login(stage, txtPass.getText())); // setting the button behavior using a
															// lambda expression
		// adding all created components to the pane
		pane.getChildren().add(btnLogin);
		pane.getChildren().add(txtUser);
		pane.getChildren().add(txtPass);

		// applying the LIGHT style from the JMetro library
		new JMetro(JMetro.Style.LIGHT).applyTheme(pane);

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

	private void login(Stage stage, String password) {
		try {
			new Main(txtUser.getText()).start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
