import javafx.scene.control.Button;

public class YourButton extends Button {
	public YourButton() {
		super();
		this.setText("Teu botão");
	}
	
	@Override
	public String toString(){
		return this.getText();
	}
}
