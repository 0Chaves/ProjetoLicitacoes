package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entities.Item;

public class ItemDAO implements Interface_DAO<Item> {

	@Override
	public boolean insert(Item object) {
		if(object instanceof Item) {
			Connection con = ConnectionFactory.getConnection();
			try {
				String query = "INSERT INTO itens (descricao, valor_unitario, id_fornecedor, id_categoria) VALUES (?,?,?,?)";
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(1, object.getDescricao());
				pstm.setDouble(2, object.getValor_unitario());
				pstm.setInt(3, object.getFornecedor().getId());
				pstm.setInt(4, object.getCategoria().getId());
				pstm.execute();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "DELETE FROM itens WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			return pstm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Item object) {
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE itens SET descricao = ?, valor_unitario = ?, id_fornecedor = ?, id_categoria = ? WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, object.getDescricao());
			pstm.setDouble(2, object.getValor_unitario());
			pstm.setInt(3, object.getFornecedor().getId());
			pstm.setInt(4, object.getCategoria().getId());
			pstm.setInt(5, object.getId());
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	@Override
	public List<Item> list(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item get(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM itens WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet result = pstm.executeQuery();
			if(result.next()) {
				int id_item = result.getInt("id");
				String descricao = result.getString("descricao");
				double valor_unitario = result.getDouble("valor_unitario");
				int id_fornecedor = result.getInt("id_fornecedor");
				int id_categoria = result.getInt("id_categoria");
				//TODO: Select com join para trazer o fornecedor e a categoria
//				Item item = new Item(id_item, descricao, valor_unitario, null, null);
//				return item;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}
