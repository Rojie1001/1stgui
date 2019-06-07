package br.edu.ifsc.ui.stages;

import java.util.List;

import br.edu.ifsc.ui.entities.User;
import br.edu.ifsc.ui.util.DB;
import br.edu.ifsc.ui.util.Strings;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class MainStage extends Application {

	public void inicie(Stage stage, String username) {

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

		// loading users from the current database
		List<User> users = DB.users.getUsers();

		// creating the users table
		TableView<User> usersTable = new TableView<User>();
		usersTable.setLayoutX(10);
		usersTable.setLayoutY(50);
		usersTable.setPrefSize(620, 420);
		usersTable.setEditable(true);

		// creating the users table cols
		TableColumn<User, String> colName = new TableColumn<>(Strings.name);
		TableColumn<User, String> colPass = new TableColumn<>(Strings.password);
		TableColumn<User, Boolean> colAdmin = new TableColumn<>(Strings.isAdmin);

		// configuring the cols
		colName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		colName.setCellFactory(TextFieldTableCell.forTableColumn());
		colName.setMinWidth(200);

		colPass.setCellValueFactory(new PropertyValueFactory<User, String>("pass"));
		colPass.setCellFactory(TextFieldTableCell.forTableColumn());
		colPass.setMinWidth(200);

		colAdmin.setCellValueFactory(new PropertyValueFactory<User, Boolean>("isAdmin"));
		colAdmin.setCellFactory(CheckBoxTableCell.forTableColumn(colAdmin));
		colAdmin.setMinWidth(200);

		// adding the created cols to the table
		usersTable.getColumns().add(colName);
		usersTable.getColumns().add(colPass);
		usersTable.getColumns().add(colAdmin);

		// adding users data to the table
		usersTable.setItems(FXCollections.observableArrayList(users));

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

	@Override
	public void start(Stage primaryStage) throws Exception {
		inicie(primaryStage, "meu bem, bom dia.");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
