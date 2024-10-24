package Entities;

public class Categoria {
	private int id;
	private String nome;
	
	public Categoria(String nome) {
		setNome(nome);
	}
	
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
	private void setId(int id) {
		this.id = id;
	}
	
}
