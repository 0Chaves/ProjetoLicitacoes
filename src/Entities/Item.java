package Entities;

import java.util.Objects;

public class Item {
	private int id;
	private String descricao;
	private Fornecedor fornecedor;
	private Categoria categoria;
	private double valor_unitario;
	
	//Construtor para cadastrar um novo fornecedor (id gerado pelo BD)
	public Item (String descricao, double valor_unitario, Fornecedor fornecedor, Categoria categoria) {
		setDescricao(descricao);
		setValor_unitario(valor_unitario);
		setFornecedor(fornecedor);
		setCategoria(categoria);
	}
	
	//Construtor para buscar um fornecedor (recupera o id fornecido pelo BD)
	public Item (int id, String descricao, double valor_unitario, Fornecedor fornecedor, Categoria categoria) {
		setId(id);
		setDescricao(descricao);
		setValor_unitario(valor_unitario);
		setFornecedor(fornecedor);
		setCategoria(categoria);
	}

	//GETTERS
	public String getDescricao() {
		return descricao;
	}
	public double getValor_unitario() {
		return valor_unitario;
	}
	public int getId() {
		return id;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public Categoria getCategoria() {
		return categoria;
	}

	//SETTERS
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	private void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	private void setId(int id) {
		this.id = id;
	}
	private void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	private void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(descricao, other.descricao)
				&& Double.doubleToLongBits(valor_unitario) == Double.doubleToLongBits(other.valor_unitario);
	}
	
	
}
