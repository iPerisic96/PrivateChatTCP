package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LogIn extends Stage {

	private Button btnLogIn;
	private Button btnSignUp;
	private TextField tfUsername;
	private PasswordField pfPassword;
	private Label lblUsername;
	private Label lblPassword;
	private Label lblMessage;
	private ArrayList<String> usernames = new ArrayList<>();
	private ArrayList<String> passwords = new ArrayList<>();
	
	public void readFile (){
			try {
				Scanner sc = new Scanner(new File("baza.txt"));
				while(sc.hasNextLine()){
					String str = sc.nextLine();
					String[] strNiz = str.split(",");
					usernames.add(strNiz[0]);
					passwords.add(strNiz[1]);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public LogIn() {
		
		readFile();
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(8);
		gridPane.setVgap(8);
		gridPane.setPadding(new Insets(10));
		
		btnLogIn = new Button("Log In");
		btnSignUp = new Button("Sign Up");
		
		HBox btnBox = new HBox(8);
		btnBox.getChildren().setAll(btnLogIn, btnSignUp);
		
		tfUsername = new TextField();
		pfPassword = new PasswordField();
		lblUsername = new Label("Username:");
		lblPassword = new Label("Password:");
		lblMessage = new Label();
		lblMessage.setTextFill(Color.RED);
		
		HBox messageBox = new HBox();
		messageBox.getChildren().add(lblMessage);
		messageBox.setAlignment(Pos.CENTER);
		
		gridPane.add(lblUsername, 0, 0);
		gridPane.add(tfUsername, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		gridPane.add(pfPassword, 1, 1);
		gridPane.add(messageBox, 0, 2, 2, 1);
		gridPane.add(btnBox, 1, 3);
		
		btnSignUp.setOnAction(e -> new SignUp(this));
		
		btnLogIn.setOnAction(e -> {
			if (tfUsername.getText().equals("") && pfPassword.getText().equals("")){
				lblMessage.setText("Insert Username and Password!");
			}
			
			else if (tfUsername.getText().equals(""))
				lblMessage.setText("Insert Username!");
			
			else if (pfPassword.getText().equals(""))
				lblMessage.setText("Insert Password!");
		
			else 
				lblMessage.setText("");
			
			System.out.println(usernames);
			
			if(usernames.contains(tfUsername.getText()) && passwords.contains(pfPassword.getText())){
				new ListClient(this);
				this.close();
			}
			
		});
		
		Scene scene = new Scene(gridPane);
		this.setScene(scene);
		this.setWidth(320);
		this.setHeight(230);
		setTitle("LogIn");
		show();
		
	}

	public Button getBtnLogIn() {
		return btnLogIn;
	}

	public void setBtnLogIn(Button btnLogIn) {
		this.btnLogIn = btnLogIn;
	}

	public TextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(TextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public PasswordField getPfPassword() {
		return pfPassword;
	}

	public void setPfPassword(PasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}

	public Button getBtnSignUp() {
		return btnSignUp;
	}

	public void setBtnSignUp(Button btnSignUp) {
		this.btnSignUp = btnSignUp;
	}

	public Label getLblUsername() {
		return lblUsername;
	}

	public void setLblUsername(Label lblUsername) {
		this.lblUsername = lblUsername;
	}

	public Label getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(Label lblPassword) {
		this.lblPassword = lblPassword;
	}

	public Label getLblMessage() {
		return lblMessage;
	}

	public void setLblMessage(Label lblMessage) {
		this.lblMessage = lblMessage;
	}

	public ArrayList<String> getUsernames() {
		return usernames;
	}

	public void setUsernames(ArrayList<String> usernames) {
		this.usernames = usernames;
	}

	public ArrayList<String> getPasswords() {
		return passwords;
	}

	public void setPasswords(ArrayList<String> passwords) {
		this.passwords = passwords;
	}
	
	
	
}
