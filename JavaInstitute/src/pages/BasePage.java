package pages;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class BasePage {
	Stage stage;
	Scene scene;
	BorderPane bp;
	
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public BorderPane getBp() {
		return bp;
	}
	public void setBp(BorderPane bp) {
		this.bp = bp;
	}

	public BasePage(Stage stage) {
		super();
		bp = new BorderPane();
		bp.setStyle("-fx-font-family: 'Arial';");
		scene = new Scene(bp, 800, 600);
		init();
		layout();
		setAction();		
		this.stage = stage;
		this.stage.setScene(scene); 
		this.stage.show();
		
	}

	public abstract void init();
	public abstract void layout();
	public abstract void setAction(); 
	
}