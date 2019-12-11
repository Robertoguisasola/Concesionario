package model;

public class Vehiculo {

	protected String marca;
	protected String modelo;
	protected Colores color;
	protected int caballos;
	protected int numRuedas;
	protected int nPlazas;
	//TODO poner imagen como string y al seleccionar que imagen quieres, que la copie a img y guarde esa ruta de img
	
	public Vehiculo(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.numRuedas = numRuedas;
		this.nPlazas = nPlazas;
	}

	public Vehiculo() {
		super();
		this.marca = null;
		this.modelo = null;
		this.color = null;
		this.caballos = 0;
		this.numRuedas = 0;
		this.nPlazas = 0;
	}

	public Vehiculo(Vehiculo v) {
		super();
		this.marca = v.marca;
		this.modelo = v.modelo;
		this.color = v.color;
		this.caballos = v.caballos;
		this.numRuedas = v.numRuedas;
		this.nPlazas = v.nPlazas;
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

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", caballos=" + caballos
				+ ", numRuedas=" + numRuedas + ", nPlazas=" + nPlazas + "]";
	}
}