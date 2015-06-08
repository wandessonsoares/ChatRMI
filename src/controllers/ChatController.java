package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.TableModel;
import servidor.Servidor;
import views.Chat;
import cliente.ICliente;

public class ChatController implements Initializable{
	
	private StringBuffer msgs = new StringBuffer();
	
	@FXML
    private TextArea txChat;

    @FXML
    private Button btEnviar;

    @FXML
    private AnchorPane apChat;

    @FXML
    private AnchorPane apOnline;

    @FXML
    private TextField txMensagem;

    @FXML
    private Button btPrivado;
    
    @FXML
    private ImageView imgAtualizar;
    
    @FXML
    private TableView<TableModel> tbOnline;
    
    @FXML
    private TableColumn tcUsuarios;
    
    @FXML
    private Label lbNome;


    @FXML
    void atualizar(MouseEvent event) {
    	
    	
    	ObservableList<TableModel> usuarios = FXCollections.observableArrayList();
    	
    	try {
			ArrayList<ICliente> usuariosOnline = Chat.CLIENTE.listarUsuarios();
			for (ICliente u : usuariosOnline) {
				usuarios.add(new TableModel(u.getName()));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	tcUsuarios.setCellValueFactory(new PropertyValueFactory("nome"));
    	
    	tbOnline.setItems(usuarios);
    }
    
    @FXML
    void enviarMsgEnter(ActionEvent event) {
    	
    	try {
			ArrayList<ICliente> usuariosOnline = Chat.CLIENTE.listarUsuarios();
			for (ICliente u : usuariosOnline) {
				
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	msgs.append("Olá! \n");
    	
    	txChat.setText(msgs.toString());
    }

    @FXML
    void enviarMsg(ActionEvent event) {
    	
    	String msg = txMensagem.getText();
    	
    	try {
			String conversa = Chat.CLIENTE.broadcast(msg);
			txChat.setText(conversa);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
    	lbNome.setText(Chat.CLIENTE.getName());
    	
    	ObservableList<TableModel> usuarios = FXCollections.observableArrayList();
    	
    	try {
    		
    		// preenchendo lista de usuarios online
			ArrayList<ICliente> usuariosOnline = Chat.CLIENTE.listarUsuarios();
			for (ICliente u : usuariosOnline) {
				usuarios.add(new TableModel(u.getName()));
			}
			tcUsuarios.setCellValueFactory(new PropertyValueFactory("nome"));
	    	tbOnline.setItems(usuarios);
	    	
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void editarNome(MouseEvent event) {
    	System.out.println("editar nome");
    }
}

