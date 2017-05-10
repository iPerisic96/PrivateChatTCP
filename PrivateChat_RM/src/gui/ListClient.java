package gui;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListClient extends Stage{

	private ListView<String> users = new ListView<>();
	private LogIn login;
	
	public ListClient(LogIn login) {
		this.login = login;
		
		GridPane root = new GridPane();
		
		login.readFile();
		users.setItems(FXCollections.observableArrayList(login.getUsernames()));
		System.out.println(login.getUsernames());
		root.add(users, 0, 0);
		
		Scene scene = new Scene(root);
		setScene(scene);
		show();
	}
}
