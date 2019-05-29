package br.edu.ifsc.ui.stages;

import br.edu.ifsc.ui.entities.User;
import br.edu.ifsc.ui.util.DB;
import br.edu.ifsc.ui.util.Strings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class LoginStage {
	private Button btnLogin;
	private TextField txtUser;
	private PasswordField txtPass;

	public LoginStage(Stage stage) throws Exception {

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
		txtUser.setPromptText(Strings.username);

		// creating the password textfield
		txtPass = new PasswordField();
		txtPass.setLayoutX(10);
		txtPass.setLayoutY(50);
		txtPass.setMaxWidth(150);
		txtPass.setMinWidth(150);
		txtPass.setPrefWidth(150);
		txtPass.setPromptText(Strings.password);

		// creating the login button
		btnLogin = new Button(Strings.btnLogin);
		btnLogin.setLayoutX(10);
		btnLogin.setLayoutY(90);
		btnLogin.setMaxWidth(150);
		btnLogin.setMinWidth(150);
		btnLogin.setPrefWidth(150);

		// setting the login button behavior using a lambda expression
		btnLogin.setOnMouseClicked(e -> login(txtUser.getText(), txtPass.getText(), stage));

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

	private void login(String username, String pass, Stage stage) {

		User user = DB.users.getUser(username);
		
		if (user == null) {
			showLoginError();
			return;
		}
		
		if(!user.getPass().equals(pass)) {
			showLoginError();
			return;
		}
		
		new MainStage(stage, txtUser.getText());
	}

	private void showLoginError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(Strings.loginError);
		alert.setHeaderText(Strings.loginError);
		alert.showAndWait();
	}
}
