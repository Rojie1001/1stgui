package br.edu.ifsc.ui.stages;

import br.edu.ifsc.ui.util.DB;
import br.edu.ifsc.ui.util.Strings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddUserStage {
	private Button btnAdd;
	private TextField txtUser;
	private PasswordField txtPass;
	
	public AddUserStage(Stage stage) {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(170, 190);
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

		// creating the add button
		btnAdd = new Button(Strings.btnAdd);
		btnAdd.setLayoutX(10);
		btnAdd.setLayoutY(90);
		btnAdd.setMaxWidth(150);
		btnAdd.setMinWidth(150);
		btnAdd.setPrefWidth(150);

		// setting the login button behavior using a lambda expression
		btnAdd.setOnMouseClicked(e -> {
			// verificações
			DB.users.addUser(txtUser.getText(), txtPass.getText());
			// alertar
			stage.close();
		});

		// adding all created components to the pane
		pane.getChildren().add(btnAdd);
		pane.getChildren().add(txtUser);
		pane.getChildren().add(txtPass);

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

}
