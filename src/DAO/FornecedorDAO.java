package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entities.ConnectionFactory;
import Entities.Fornecedor;

public class FornecedorDAO implements Interface_DAO<Fornecedor> {
	
	@Override
	public boolean insert(Fornecedor object) {
		if(object instanceof Fornecedor) {
			Connection con = ConnectionFactory.getConnection();
			try {
				//Buscar o ID do ultimo endereço inserido no BD
				String query_last_id = "SELECT id FROM endereco ORDER BY id DESC LIMIT 1";
				PreparedStatement pstm = con.prepareStatement(query_last_id);
				ResultSet last_id = pstm.executeQuery();
				last_id.next();
				
				//Insere o fornecedor no banco de dados
				String query = "INSERT INTO fornecedores (nome,cnpj,id_endereco,email,telefone) VALUES (?,?,?,?,?)";
				pstm = con.prepareStatement(query);
				pstm.setString(0, object.getNome());
				pstm.setString(1, object.getCnpj());
				pstm.setInt(2, last_id.getInt("id"));
				pstm.setString(3, object.getEmail());
				pstm.setString(4, object.getTelefone());
				return pstm.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public boolean delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		return true;
	}
	
	@Override
	public boolean update(Fornecedor object) {
		Connection con = ConnectionFactory.getConnection();
		return true;
	}
	
	@Override
	public List<Fornecedor> list(int limit, int offset){
		Connection con = ConnectionFactory.getConnection();
		return null;
	}
	
	@Override
	public Fornecedor get(int id) {
		Connection con = ConnectionFactory.getConnection();
		return null;
	}
}
