package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableModel {
	private StringProperty nome;

	public TableModel(){}
	
	public TableModel(String nome) {
		this.nome = new SimpleStringProperty(nome);
	}

	public StringProperty nomeProperty() {
		return nome;
	}
}
