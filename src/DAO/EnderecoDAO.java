package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Entities.Endereco;

public class EnderecoDAO implements Interface_DAO<Endereco> {

	@Override
	public boolean insert(Endereco object) {
		if(object instanceof Endereco) {
			Connection con = ConnectionFactory.getConnection();
			String query = "INSERT INTO endereco (\"UF\",municipio, rua, numero) VALUES (?,?,?,?)";
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
				return true;
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return false;
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

	@Override
	public boolean update(Endereco object) {
		Connection con = ConnectionFactory.getConnection();
		String query = "UPDATE endereco SET \"UF\" = ?, municipio = ?, rua = ?, numero = ? WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco get(int id) {
		Connection con = ConnectionFactory.getConnection();
		String query = "SELECT * FROM endereco WHERE id = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(0, id);
			ResultSet result = pstm.executeQuery();
			while(result.next()) {
				int id_fornecedor = result.getInt("id");
				String uf = result.getString("UF");
				String municipio = result.getString("municipio");
				String rua = result.getString("rua");
				int numero = result.getInt("numero");
				Endereco endereco = new Endereco(id_fornecedor, uf, municipio, rua, numero);
				return endereco;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}
