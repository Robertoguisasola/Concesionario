package model;

public class Vehiculo {

	protected String marca;
	protected String modelo;
	protected Colores color;
	protected int caballos;
	protected int numRuedas;
	protected int nPlazas;
	protected boolean automatico;
	protected boolean lucesLed;
	protected String urlFoto;
	
	public Vehiculo(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas,
			boolean automatico, boolean lucesLed, String urlFoto) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.numRuedas = numRuedas;
		this.nPlazas = nPlazas;
		this.automatico = automatico;
		this.lucesLed = lucesLed;
		this.urlFoto = urlFoto;
	}

	public Vehiculo() {
		super();
		this.marca = null;
		this.modelo = null;
		this.color = null;
		this.caballos = 0;
		this.numRuedas = 0;
		this.nPlazas = 0;
		this.automatico = false;
		this.lucesLed = false;
		this.urlFoto = "";
	}

	public Vehiculo(Vehiculo v) {
		super();
		this.marca = v.marca;
		this.modelo = v.modelo;
		this.color = v.color;
		this.caballos = v.caballos;
		this.numRuedas = v.numRuedas;
		this.nPlazas = v.nPlazas;
		this.automatico = v.automatico;
		this.lucesLed = v.lucesLed;
		this.urlFoto = v.urlFoto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Colores getColor() {
		return color;
	}

	public void setColor(Colores color) {
		this.color = color;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public boolean isLucesLed() {
		return lucesLed;
	}

	public void setLucesLed(boolean lucesLed) {
		this.lucesLed = lucesLed;
	}
	
	public String getUrlFoto() {
		return urlFoto;
	}
	
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", caballos=" + caballos
				+ ", numRuedas=" + numRuedas + ", nPlazas=" + nPlazas + ", automatico=" + automatico + ", lucesLed="
				+ lucesLed + "urlFoto="+ urlFoto +"]";
	}
	
	
	
}