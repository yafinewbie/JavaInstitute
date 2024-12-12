package pages;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPage extends BasePage{
	
	GridPane gpLogin;
	Button login;
	Label logoText;
	Label email;
	Label password;
	TextField txtEmail;
	PasswordField txtPass;

	
	public LoginPage(Stage stage) {
		super(stage);
		stage.setTitle("JavaInstitute | Login Page");
	}

	@Override
	public void init() {	
		login = new Button("login");
		logoText = new Label("Java Institute");
		logoText.setFont(Font.font(24));
		email = new Label("Email");
		email.setFont(Font.font(16));
		password = new Label("Password");
		password.setFont(Font.font(16));
		txtEmail= new TextField();
		txtPass = new PasswordField();
	}

	@Override
	public void layout() {
		gpLogin = new GridPane();
		gpLogin.setStyle("-fx-padding: 20; -fx-alignment: center;");
		
		gpLogin.add(logoText, 0, 0, 2, 1);
        gpLogin.add(email, 0, 1);
        gpLogin.add(txtEmail, 1, 1);
        gpLogin.add(password, 0, 2);
        gpLogin.add(txtPass, 1, 2);
        gpLogin.add(login, 1, 3);

        gpLogin.setVgap(20);
        gpLogin.setHgap(20);

        gpLogin.setAlignment(Pos.CENTER);
        gpLogin.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        getBp().setCenter(gpLogin);
		
	}

	@Override
	public void setAction() {
		// TODO Auto-generated method stub
		
	}

}
