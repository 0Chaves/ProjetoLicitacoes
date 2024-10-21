package Entities;

import java.sql.Connection;
import java.util.List;

public class FornecedorDAO {
	
	public static boolean inserir(Fornecedor fornecedor) {
			Connection con = ConnectionFactory.getConnection();
			return true;
	}
	
	public static boolean update(Fornecedor f) {
		return true;
	}
	
	public static boolean delete(int id) {
		return true;
	}
	
	public static List<Fornecedor> listar(){
		return null;
	}
}
