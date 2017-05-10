package gui;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Stage{

	private TextField tfMessage;
	private TextArea taChatMessage;
	
	public ChatWindow(String clientName) {
		BorderPane root = new BorderPane();
	
		tfMessage = new TextField();
		taChatMessage = new TextArea();
		
		tfMessage.setPromptText("Type a message...");
		
		taChatMessage.setPrefHeight(300);
		taChatMessage.setEditable(false);
		taChatMessage.setWrapText(true);
		
		tfMessage.setOnAction(e ->{
			taChatMessage.appendText("Me: " + tfMessage.getText() + "\n\n");
			if (taChatMessage.getText().startsWith("Me")){
				taChatMessage.setStyle("-fx-text-fill: #1e88e5; -fx-font-size: 18px;");
			}
			tfMessage.clear();
		});
		
		
		this.setWidth(350);
		this.setHeight(400);
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(taChatMessage, tfMessage);
		
		root.setCenter(vBox);
		
		Scene scene = new Scene(root);
		setScene(scene);
		setTitle("Chat with " + clientName);
		show();
	}

	public TextField getTfMessage() {
		return tfMessage;
	}

	public void setTfMessage(TextField tfMessage) {
		this.tfMessage = tfMessage;
	}

	public TextArea getTaChatMessage() {
		return taChatMessage;
	}

	public void setTaChatMessage(TextArea taChatMessage) {
		this.taChatMessage = taChatMessage;
	}
	
}
