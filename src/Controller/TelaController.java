package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class TelaController {
	private Stage stage;
	private Scene scene;
	private VBox root;

    @FXML
    private Button trocarTela_InserirFornecedor;

    @FXML
    private Button trocarTela_InserirItem;

    @FXML
    void trocar_tela_inserir_fornecedor(ActionEvent event) {
    	try {
			root = (VBox)FXMLLoader.load(getClass().getResource("/application/TelaInserirFornecedor.fxml"));
			scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

    @FXML
    void trocar_tela_inserir_item(ActionEvent event) {
    	try {
    		root = (VBox)FXMLLoader.load(getClass().getResource("/application/TelaInserirItem.fxml"));
    		scene = new Scene(root);
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		stage.setScene(scene);
			stage.show();
    	} catch (IOException e) {
    	 	e.printStackTrace();
    	}
    }

    
}
