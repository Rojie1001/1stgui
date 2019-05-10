
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private YourButton yourButton;
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
		yourButton = new YourButton();
		yourButton.setText("Teu botão");
		yourButton.setLayoutX(230);
		yourButton.setLayoutY(10);

		// adding the button to the pane
		pane.getChildren().add(yourButton);

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
		yourButton.setOnMouseClicked(buttonEvent);

		// setting the txtField behavior using lambda expression
		txtField.setOnMouseClicked(event -> updateButtonText());

		// showing the created UI
		stage.show();
	}

	EventHandler<MouseEvent> buttonEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			updateButtonText();
		}
	};

	private void updateButtonText() {
		this.yourButton.setText(this.txtField.getText());
	}
}
