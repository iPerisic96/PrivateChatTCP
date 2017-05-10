package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUp extends Stage {

	private Label lblUsername;
	private Label lblPassword;
	private Label lblPasswordConfirm;
	private TextField tfUsername;
	private PasswordField tfPassword;
	private PasswordField tfPasswordConfirm;
	private Button btnSubmit;
	private Label lblPassworMatch;
	private Label lblUsernameTaken;
	private LogIn login;
	
	public SignUp(LogIn login) {
		
		this.login = login;
		
		this.setHeight(370);
		this.setWidth(340);
		this.initModality(Modality.APPLICATION_MODAL);
		
		GridPane root = new GridPane();
		
		lblUsername = new Label("Username:");
		lblPassword = new Label("Password:");
		lblPasswordConfirm = new Label("Reenter password:");
		lblPassworMatch = new Label();
		lblUsernameTaken = new Label();
		
		lblUsernameTaken.setTextFill(Color.RED);
		lblPassworMatch.setTextFill(Color.RED);
		
		tfUsername = new TextField();
		tfPassword = new PasswordField();
		tfPasswordConfirm = new PasswordField();
		
		btnSubmit = new Button("Submit");
		
		VBox vBox = new VBox(8);
		vBox.getChildren().addAll(lblUsername, tfUsername, lblUsernameTaken, lblPassword, tfPassword, lblPasswordConfirm, tfPasswordConfirm, lblPassworMatch, btnSubmit);
		vBox.setAlignment(Pos.CENTER);
		
		root.add(vBox, 0, 0);
		root.setAlignment(Pos.CENTER);
		
		btnSubmit.setOnAction(e -> {
			
			if (!(tfPassword.getText().equals(tfPasswordConfirm.getText()))){
				lblPassworMatch.setText("Passwords don't match!");
			}
			else 
				lblPassworMatch.setText("");
				
			if (login.getUsernames().contains(tfUsername.getText())){ // ako je zauzeto korisnicko ime, ostavljam za kasnije
				lblUsernameTaken.setText("Username is already taken :(");
			}
			try {
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("baza.txt", true)));
				writer.println(tfUsername.getText() + "," + tfPassword.getText());
				writer.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		});
		
		Scene scene = new Scene(root);
		setScene(scene);
		setTitle("User registration");
		showAndWait();
		
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

	public Label getLblPasswordConfirm() {
		return lblPasswordConfirm;
	}

	public void setLblPasswordConfirm(Label lblPasswordConfirm) {
		this.lblPasswordConfirm = lblPasswordConfirm;
	}

	public TextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(TextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public TextField getTfPassword() {
		return tfPassword;
	}

	public PasswordField getTfPasswordConfirm() {
		return tfPasswordConfirm;
	}

	public void setTfPasswordConfirm(PasswordField tfPasswordConfirm) {
		this.tfPasswordConfirm = tfPasswordConfirm;
	}

	public Button getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(Button btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public void setTfPassword(PasswordField tfPassword) {
		this.tfPassword = tfPassword;
	}
	
	
}
