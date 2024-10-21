package Entities;
import java.io.IOException;
import java.util.Objects;

public class Fornecedor {
	private String nome;
	private String cnpj;
	private Endereco endereco;
	private String email;
	private String telefone;
	
	public Fornecedor(String nome, String cnpj, Endereco endereco, String email, String telefone) throws IOException {
			setNome(nome);
			setCnpj(cnpj);
			setEndereco(endereco);
			setEmail(email);
			setTelefone(telefone);	
	}
	
	
	public String getNome() {
		return nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	private void setNome(String nome) throws IOException {
		if(nome==null) throw new IOException("Nome deve ser preenchido");
		this.nome = nome;
	}
	private void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	private void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(cnpj, other.cnpj);
	}
	
	
	
}
