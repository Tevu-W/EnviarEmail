package dad.javafx.fxml.EnviarEmail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{

	EnviarEmailController controller;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		controller = new EnviarEmailController();
		
		Scene scene = new Scene(controller.getView(), 600, 400);
		
		Stage stage = new Stage();
		
		stage.setTitle("Enviar Email");
		stage.getIcons().add(new Image("email-send-icon-32x32.png"));
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
