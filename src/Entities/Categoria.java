package Entities;

public class Categoria {
	private int id;
	private String nome;
	
	//Construtor para cadastrar um novo fornecedor (id gerado pelo BD)
	public Categoria(String nome) {
		setNome(nome);
	}
	
	//Construtor para buscar um fornecedor (recupera o id fornecido pelo BD)
	public Categoria(int id, String nome) {
		setId(id);
		setNome(nome);
	}

	//GETTERS
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}

	//SETTERS
	private void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
