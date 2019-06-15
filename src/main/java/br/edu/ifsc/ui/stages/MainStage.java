package br.edu.ifsc.ui.stages;

import br.edu.ifsc.ui.entities.User;
import br.edu.ifsc.ui.util.DB;
import br.edu.ifsc.ui.util.Strings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class MainStage {

	public MainStage(Stage stage, String username) {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(640, 480);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		Label lblMain = new Label(Strings.lblMain + " " + username);
		lblMain.setLayoutX(10);
		lblMain.setLayoutY(10);
		pane.getChildren().add(lblMain);
		
		Button btnAdd = new Button(Strings.addUser);
		btnAdd.setLayoutX(400);
		btnAdd.setLayoutY(10);
		btnAdd.setOnAction(e -> {
			new AddUserStage(new Stage());
		});

		pane.getChildren().add(btnAdd);

		// creating the users table
		TableView<User> usersTable = new TableView<User>();
		usersTable.setLayoutX(10);
		usersTable.setLayoutY(50);
		usersTable.setPrefSize(620, 420);
		usersTable.setEditable(true);

		// creating the users table cols
		TableColumn<User, String> colName = new TableColumn<>(Strings.name);
		TableColumn<User, String> colPass = new TableColumn<>(Strings.password);

		// configuring the cols
		colName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		colName.setCellFactory(TextFieldTableCell.forTableColumn());
		colName.setMinWidth(200);

		colPass.setCellValueFactory(new PropertyValueFactory<User, String>("pass"));
		colPass.setCellFactory(TextFieldTableCell.forTableColumn());
		colPass.setMinWidth(200);
		colPass.setOnEditCommit(e -> {
			DB.users.changePass(e.getRowValue().getName(), e.getNewValue());
		});

		// adding the created cols to the table
		usersTable.getColumns().add(colName);
		usersTable.getColumns().add(colPass);

		// adding users data to the table
		usersTable.setItems(DB.users.getUsers());

		// adding the table to the pane
		pane.getChildren().add(usersTable);

		// applying the LIGHT style from the JMetro library to the pane
		new JMetro(JMetro.Style.LIGHT).applyTheme(pane);

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}
}
