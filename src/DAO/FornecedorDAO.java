package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Entities.Categoria;
import Entities.Fornecedor;

public class FornecedorDAO implements Interface_DAO<Fornecedor> {
	
	@Override
	public boolean insert(Fornecedor object) {
		if(object instanceof Fornecedor) {
			Connection con = ConnectionFactory.getConnection();
			try {
				String query = "INSERT INTO fornecedores (\"nome\",\"cnpj\",\"id_endereco\",\"email\",\"telefone\") VALUES (?,?,?,?,?)";
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(0, object.getNome());
				pstm.setString(1, object.getCnpj());
				pstm.setInt(2, object.getEndereco().getId());
				pstm.setString(3, object.getEmail());
				pstm.setString(4, object.getTelefone());
				pstm.execute();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return false;
	}
	
	//Talvez verificar se conseguiu deletar algo
	@Override
	public boolean delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "DELETE FROM fornecedores WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, id);
			return pstm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*TODO: Desenvolver uma maneira de mudar o endereço
	 * set id_endereco
	 * criando um novo objeto endereco
	 */
	@Override
	public boolean update(Fornecedor object) {
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE fornecedores SET nome = ?,cnpj = ?, email = ?, telefone = ? WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(0, object.getNome());
			pstm.setString(1, object.getCnpj());
			pstm.setString(2, object.getEmail());
			pstm.setString(3, object.getTelefone());
			pstm.setInt(4, object.getId());
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	
	@Override
	public List<Fornecedor> list(int limit, int offset){
		Connection con = ConnectionFactory.getConnection();
		return null;
	}
	
	//TODO: Fazer join nessa select para criar o endereço
	@Override
	public Fornecedor get(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM fornecedores WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, id);
			ResultSet result = pstm.executeQuery();
			if(result.next()) {
				int id_fornecedor = result.getInt("id");
				String nome = result.getString("nome");
				String cnpj = result.getString("cnpj");
				String email = result.getString("email");
				String telefone = result.getString("telefone");
//				Fornecedor fornecedor = new Fornecedor(id_fornecedor, nome, cnpj, null, email, telefone);
//				return fornecedor;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
