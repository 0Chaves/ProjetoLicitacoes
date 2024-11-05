package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Categoria;

public class CategoriaDAO implements Interface_DAO<Categoria>{

	@Override
	public boolean insert(Categoria object) {
		Connection con = ConnectionFactory.getConnection();
		String query = "INSERT INTO categorias (nome) VALUES (?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(0, object.getNome());
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
		 */
	}

	
	/*TODO:
	 * Criar uma dupla verificação antes de excluir uma categoria ou adaptar os itens para outra categoria ou excluir todos
	 */
	@Override
	public boolean delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "DELETE FROM categorias WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, id);
			return pstm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Categoria object) {
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE categorias SET nome = ? WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(0, object.getNome());
			pstm.setInt(1, object.getId());
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	@Override
	public List list(int limit, int offset) {
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM categorias LIMIT ? OFFSET ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, limit);
			pstm.setInt(1, offset);
			ResultSet resultSet = pstm.executeQuery();
			List<Categoria> list = new ArrayList();
			Categoria categoria;
			while(resultSet.next()) {
				int id_categoria = resultSet.getInt("id");
				String nome_categoria = resultSet.getString("nome");
				categoria = new Categoria(id_categoria, nome_categoria);
				list.add(categoria);
			}
			return list;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		//Por que não pode retornar null?????
	}

	@Override
	public Categoria get(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM categorias WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, id);
			ResultSet resultSet = pstm.executeQuery();
			if(resultSet.next()) {
				int id_categoria = resultSet.getInt("id");
				String nome_categoria = resultSet.getString("nome");
				Categoria categoria = new Categoria(id_categoria, nome_categoria);
				return categoria;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
