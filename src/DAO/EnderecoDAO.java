package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Categoria;
import Entities.Endereco;

public class EnderecoDAO implements Interface_DAO<Endereco> {

	@Override
	public boolean insert(Endereco object) {
		Connection con = ConnectionFactory.getConnection();
		String query = "INSERT INTO endereco (\"UF\", municipio, rua, numero) VALUES (?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(0, object.getUF());
			pstm.setString(1, object.getMunicipio());
			pstm.setString(2, object.getRua());
			pstm.setInt(3, object.getNumero());
			pstm.execute();
			ResultSet generated_id = pstm.getResultSet();
			if(generated_id.next()) {
				object.setId(generated_id.getInt("id"));
			}
			generated_id.close();
			
			/*TODO:
			 * Implementar Lista e inserir o objeto na lista
			 */
			return true;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		/*TODO:
		 * Criar outras Exceptions para retornar False caso ocorra invalidação de input
		 * 
		 * Perguntar por que nao pode botar um return false aqui********
		 */
	}

	@Override
	public boolean delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "DELETE FROM endereco WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, id);
			return pstm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/*TODO:
	 * Criar um objeto temporario para fazer essa alteração
	 */
	@Override
	public boolean update(Endereco object) {
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE endereco SET \"UF\" = ?, municipio = ?, rua = ?, numero = ? WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(0, object.getUF());
			pstm.setString(1, object.getMunicipio());
			pstm.setString(2, object.getRua());
			pstm.setInt(3, object.getNumero());
			pstm.setInt(4, object.getId());
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	@Override
	public List<Endereco> list(int limit, int offset) {
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM endereco LIMIT ? OFFSET ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, limit);
			pstm.setInt(1, offset);
			ResultSet resultSet = pstm.executeQuery();
			List<Endereco> list = new ArrayList();
			Endereco endereco;
			while(resultSet.next()) {
				int id_fornecedor = resultSet.getInt("id");
				String uf = resultSet.getString("UF");
				String municipio = resultSet.getString("municipio");
				String rua = resultSet.getString("rua");
				int numero = resultSet.getInt("numero");
				endereco = new Endereco(id_fornecedor, uf, municipio, rua, numero);
				list.add(endereco);
			}
			return list;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Endereco get(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM endereco WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, id);
			ResultSet resultSet = pstm.executeQuery();
			if(resultSet.next()) {
				int id_fornecedor = resultSet.getInt("id");
				String uf = resultSet.getString("UF");
				String municipio = resultSet.getString("municipio");
				String rua = resultSet.getString("rua");
				int numero = resultSet.getInt("numero");
				Endereco endereco = new Endereco(id_fornecedor, uf, municipio, rua, numero);
				return endereco;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}
