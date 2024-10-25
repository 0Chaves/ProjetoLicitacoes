package DAO;

import java.sql.Connection;
import java.util.List;

import Entities.Item;

public class ItemDAO implements Interface_DAO<Item> {

	@Override
	public boolean insert(Item object) {
		Connection con = ConnectionFactory.getConnection();
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Item object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> list(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
