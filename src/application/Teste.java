package application;

import java.io.IOException;

import DAO.FornecedorDAO;
import model.Endereco;
import model.Fornecedor;

public class Teste {

	public static void main(String[] args) {
		   // Create an instance of Endereco
        Endereco endereco = new Endereco("SP", "São Paulo", "Rua Exemplo", 123);

        // Create an instance of Fornecedor
        try {
            Fornecedor fornecedor = new Fornecedor("Fornecedor Exemplo", "12.345.678/0001-90", endereco, "email@exemplo.com", "(11) 1234-5678");
            Fornecedor fornecedor2 = new Fornecedor("Fornecedor Exemplo", "12.345.678/0001-90", endereco, "novoemail@exemplo.com", "(11) 1234-5678");

            // Create an instance of FornecedorDAO
            FornecedorDAO fornecedorDAO = new FornecedorDAO();

            // Insert the fornecedor into the database
            boolean insertResult = fornecedorDAO.insert(fornecedor);
            System.out.println("Insert result: " + insertResult);

            // Update the fornecedor's email
            boolean updateResult = fornecedorDAO.update(fornecedor2);
            System.out.println("Update result: " + updateResult);

            // Retrieve the fornecedor from the database
            Fornecedor retrievedFornecedor = fornecedorDAO.get(fornecedor.getId());
            System.out.println("Retrieved Fornecedor: " + retrievedFornecedor);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
