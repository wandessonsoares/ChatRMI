package views;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TelaInicial extends Application{
	
	public static Stage STAGE;
	
	@Override
	public void start(Stage stage) throws Exception {
		STAGE = stage;
		
		stage.setTitle("IFPB Messenger - Entrar");
		
		Parent root = 
				FXMLLoader.load(getClass().getResource("tela_inicial.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
