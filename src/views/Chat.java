package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import cliente.Cliente;

public class Chat extends Application{
	public static Stage STAGE_CHAT;
	private Cliente cliente;
	public static Cliente CLIENTE;
	
	public Chat(Cliente cliente) {
		this.cliente = cliente;
		CLIENTE = getCliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public void start(Stage stage) throws Exception {
		STAGE_CHAT = stage;
		
		stage.setTitle("IFPB Messenger - Chat");
		
		Parent root = 
				FXMLLoader.load(getClass().getResource("chat.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {		
		launch(args);
	}
}
