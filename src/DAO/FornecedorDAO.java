package DAO;

import java.sql.Connection;
import java.util.List;

import Entities.ConnectionFactory;
import Entities.Fornecedor;

public class FornecedorDAO {
	
	public boolean insert(Fornecedor object) {
		Connection con = ConnectionFactory.getConnection();
		return true;
	}
	
	public boolean delete(int id) {
		return true;
	}
	public boolean update(Fornecedor object) {
		return true;
	}
	public List<Fornecedor> list(int limit, int offset){
		return null;
	}
	public Fornecedor get(int id) {
		return null;
	}
}
