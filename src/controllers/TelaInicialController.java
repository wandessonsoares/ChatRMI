package controllers;

import cliente.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import views.Chat;
import views.TelaInicial;

public class TelaInicialController {

    @FXML
    private Button btEntrar;

    @FXML
    private TextField txIpServidor;

    @FXML
    private TextField txNome;

    @FXML
    void entrar(ActionEvent event) {
    	try {
    		String nome = txNome.getText();
    		String ip = txIpServidor.getText();
    		
    		Cliente cliente = new Cliente(nome, ip);
			
    		new Chat(cliente).start(new Stage());
			TelaInicial.STAGE.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void enter(ActionEvent event) {
    	try {
    		String nome = txNome.getText();
    		String ip = txIpServidor.getText();
    		
    		Cliente cliente = new Cliente(nome, ip);
    		
    		new Chat(cliente).start(new Stage());
    		TelaInicial.STAGE.close();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}