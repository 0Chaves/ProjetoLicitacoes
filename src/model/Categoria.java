package model;

import java.io.IOException;

public class Categoria {
	private int id;
	private String nome;
	
	//Construtor para cadastrar um novo fornecedor (id gerado pelo BD)
	public Categoria(String nome) {
		try {
			setNome(nome);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Construtor para buscar um fornecedor (recupera o id fornecido pelo BD)
	public Categoria(int id, String nome) {
		this(nome);
		setId(id);
	}

	//GETTERS
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}

	//SETTERS
	private void setNome(String nome) throws IOException {
		//Verificar se possui espaço no nome e dar erro caso possua
		if(nome.indexOf(" ") == -1) throw new IOException("A categoria deve ser um unico nome");
		this.nome = nome.toUpperCase();
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
