package Entities;

public class Endereco {
	private String UF;
	private String municipio;
	private String rua;
	private int numero;
	
	public Endereco (String UF, String municipio, String rua, String numero) {
		setUF(UF);
		setMunicipio(municipio);
		setRua(rua);
		setNumero(numero);
	}

	public String getUF() {
		return UF;
	}

	public String getMunicipio() {
		return municipio;
	}

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	private void setUF(String uF) {
		UF = uF;
	}

	private void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	private void setRua(String rua) {
		this.rua = rua;
	}

	private void setNumero(String numero) {
		this.numero = Integer.parseInt(numero);
	}
	
}
