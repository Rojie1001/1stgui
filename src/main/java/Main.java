import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Button button;
	private TextField txtField;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(800, 600);

		Scene scene = new Scene(pane);

		stage.setScene(scene);

		// creating a button
		button = new Button("My first button in JavaFX");
		button.setLayoutX(230);
		button.setLayoutY(10);

		// adding the button to the pane
		pane.getChildren().add(button);

		// creating a TextField
		txtField = new TextField();
		txtField.setLayoutX(10);
		txtField.setLayoutY(10);
		txtField.setMaxWidth(200);
		txtField.setMinWidth(200);
		txtField.setPrefWidth(200);

		// adding the TextField to the pane
		pane.getChildren().add(txtField);

		// setting the button behavior
		button.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				updateButtonText();
			}

		});

		// showing the created UI
		stage.show();
	}

	private void updateButtonText() {
		this.button.setText(this.txtField.getText());
	}
}
