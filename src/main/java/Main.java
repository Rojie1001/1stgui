
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;
import org.controlsfx.control.*;

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

		 TreeItem<YourButton> root = new TreeItem<YourButton>(yourButton);
		 TreeItem<YourButton> node1 = new TreeItem<YourButton>(yourButton);
		 TreeItem<YourButton> node2 = new TreeItem<YourButton>(yourButton);
		 TreeItem<YourButton> node3 = new TreeItem<YourButton>(yourButton);
		 TreeItem<YourButton> node4 = new TreeItem<YourButton>(yourButton);
		 TreeItem<YourButton> node5 = new TreeItem<YourButton>(yourButton);

		 root.getChildren().addAll(node1,node2,node3,node4,node5);
		 
		BreadCrumbBar<YourButton> seuCuque = new BreadCrumbBar<YourButton>(root);
		seuCuque.selectedCrumbProperty().set(node3);
		seuCuque.setLayoutX(0);
		seuCuque.setLayoutY(200);
		pane.getChildren().add(seuCuque);
		
		// setting the button behavior
		yourButton.setOnMouseClicked(e -> updateButtonText());

		// setting the txtField behavior using lambda expression
		txtField.setOnKeyTyped(keyEvent);
		
		new JMetro(JMetro.Style.LIGHT).applyTheme(pane);
		
		// showing the created UI
		stage.show();
	}

	EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			updateButtonText(event.getCharacter());
		}

	};

	private void updateButtonText() {
		this.yourButton.setText(this.txtField.getText());
	}

	private void updateButtonText(String keyPressed) {
		this.yourButton.setText(this.txtField.getText() + keyPressed);
	}
}
