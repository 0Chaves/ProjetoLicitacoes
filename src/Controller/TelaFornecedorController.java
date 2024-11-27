package Controller;

import java.io.IOException;

import DAO.FornecedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import model.Endereco;
import model.Fornecedor;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.KeyEvent;

public class TelaFornecedorController {

	private Stage stage;
	private Scene scene;
	private AnchorPane root;
	
	@FXML
    private Button botao_enviar;
	
    @FXML
    private Button botao_voltar;
    
    @FXML
    private TextArea inputCnpj;

    @FXML
    private TextArea inputEmail;

    @FXML
    private TextArea inputMunicipio;

    @FXML
    private TextArea inputNome;

    @FXML
    private TextArea inputNumero;

    @FXML
    private TextArea inputRua;

    @FXML
    private TextArea inputTelefone;

    @FXML
    private TextArea inputUf;


    @FXML
    void voltar(ActionEvent event) {
    	try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/TelaInicial.fxml"));
			scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
    
    @FXML
    void enviar(ActionEvent event) {
    	try {
    		Endereco endereco = new Endereco(inputUf.getText(), inputMunicipio.getText(), inputRua.getText(), Integer.parseInt(inputNumero.getText()));
    		Fornecedor f = new Fornecedor(inputNome.getText(), inputCnpj.getText(), endereco, inputEmail.getText(), inputTelefone.getText());
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
