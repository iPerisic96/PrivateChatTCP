package gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListClient extends Stage{

	private ListView<String> users = new ListView<>();
	private LogIn login;
	private Label lblMessage;
	
	public ListClient(LogIn login) {
		this.login = login;
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(15));
		root.setVgap(8);
		
		lblMessage = new Label("Choose a user to chat with:");
		
		users.setItems(FXCollections.observableArrayList(login.getUsernames()));
		System.out.println(login.getUsernames());
		root.add(lblMessage, 0, 0);
		root.add(users, 0, 1);
		
		users.setOnMouseClicked(e -> {
			if (e.getClickCount() == 2){
				new ChatWindow(users.getSelectionModel().getSelectedItem());
			}
		});
		
		Scene scene = new Scene(root);
		setScene(scene);
		setTitle("User list");
		show();
	}

	public ListView<String> getUsers() {
		return users;
	}

	public void setUsers(ListView<String> users) {
		this.users = users;
	}

	public LogIn getLogin() {
		return login;
	}

	public void setLogin(LogIn login) {
		this.login = login;
	}

	public Label getLblMessage() {
		return lblMessage;
	}

	public void setLblMessage(Label lblMessage) {
		this.lblMessage = lblMessage;
	}
	
	 
}
