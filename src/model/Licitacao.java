package model;

import java.util.ArrayList;
import java.util.List;

public class Licitacao {
	private String pregao;
	private List<Item_licitacao> lista_itens;
	
	public Licitacao (String pregao) {
		setPregao(pregao);
		lista_itens = new ArrayList<>();
	}
	
	//SETTERS
	private void setPregao(String pregao) {
		//TODO:	//Regex para ser no formato 00/0000 (ou 000/0000 ?)
		this.pregao = pregao;
	}

	private void setLista_itens(List lista_itens) {
		this.lista_itens = lista_itens;
	}
	

	//GETTERS
	public String getPregao() {
		return pregao;
	}

	public List getLista_itens() {
		return lista_itens;
	}
	
	
	//Método para adicionar um novo item a lista de itens da licitação
	public boolean add_item_licita(Item produto, Fornecedor fornecedor, double valor_unitario, int quantidade_maxima, int quantidade_solicitada) {
		Item_licitacao novo_item = new Item_licitacao(produto, fornecedor, valor_unitario, quantidade_maxima, quantidade_solicitada);
		this.lista_itens.add(novo_item);
		return true;
	}
	
	
	
	
	//Classe que armazena um item da licitação
	private class Item_licitacao{
		private Item produto;
		private Fornecedor fornecedor;
		private double valor_unitario;
		private int quantidade_maxima;
		private int quantidade_solicitada;
		//private int quantidade_restante; //Implementar no futuro
		
		public Item_licitacao (Item produto, Fornecedor fornecedor, double valor_unitario, int quantidade_maxima, int 		quantidade_solicitada) {
			
		}
		
		//SETTERS
		//TODO:
		// verificações de erro nos setters, lançamento de exceptions
		private void setId_produto(Item produto) {
			this.produto = produto;
		}

		private void setId_fornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}

		private void setValor_unitario(double valor_unitario) {
			this.valor_unitario = valor_unitario;
		}

		private void setQuantidade_maxima(int quantidade_maxima) {
			this.quantidade_maxima = quantidade_maxima;
		}

		private void setQuantidade_solicitada(int quantidade_solicitada) {
			this.quantidade_solicitada = quantidade_solicitada;
		}

		//GETTERS
		
		public Item getProduto() {
			return produto;
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public double getValor_unitario() {
			return valor_unitario;
		}

		public int getQuantidade_maxima() {
			return quantidade_maxima;
		}

		public int getQuantidade_solicitada() {
			return quantidade_solicitada;
		}
		
		/*
		 * TODO:
		 * equals()
		 * toString()*/
	}
	
}
