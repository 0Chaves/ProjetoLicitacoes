package application;

<<<<<<< HEAD
import java.io.IOException;

=======
import DAO.EnderecoDAO;
>>>>>>> c58654f2e3add104cdbd2af289c1f4d0bdb28d9b
import DAO.FornecedorDAO;
import model.Endereco;
import model.Fornecedor;

<<<<<<< HEAD
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
=======
import java.io.IOException;

public class Teste {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("SP", "São Paulo", "Rua Exemplo", 123);

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        boolean enderecoInsertResult = enderecoDAO.insert(endereco);
        System.out.println("Endereco insert result: " + enderecoInsertResult);

        try {
            Fornecedor fornecedor = new Fornecedor("Fornecedor Exemplo", "12.345.678/0001-90", endereco, "email@exemplo.com", "(11) 1234-5678");
            Fornecedor fornecedor2 = new Fornecedor(1,"Fornecedor Exemplo", "12.345.678/0001-90", endereco, "novoemail@exemplo.com", "(11) 1234-5678");

            FornecedorDAO fornecedorDAO = new FornecedorDAO();

            boolean insertResult = fornecedorDAO.insert(fornecedor);
            System.out.println("Insert result: " + insertResult);

            boolean updateResult = fornecedorDAO.update(fornecedor2);
            System.out.println("Update result: " + updateResult);

            Fornecedor retrievedFornecedor = fornecedorDAO.get(fornecedor2.getId());
>>>>>>> c58654f2e3add104cdbd2af289c1f4d0bdb28d9b
            System.out.println("Retrieved Fornecedor: " + retrievedFornecedor);

        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
	}

}
=======
    }
}
>>>>>>> c58654f2e3add104cdbd2af289c1f4d0bdb28d9b
