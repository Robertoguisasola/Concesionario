package model;

public class Vehiculo {

	protected String marca;
	protected String modelo;
	protected Colores color;
	protected int caballos;
	protected int numRuedas;
	protected int nPlazas;
	protected int precio;

	public Vehiculo(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, int precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.numRuedas = numRuedas;
		this.nPlazas = nPlazas;
		this.precio = precio;
	}

	public Vehiculo() {
		super();
		this.marca = null;
		this.modelo = null;
		this.color = null;
		this.caballos = 0;
		this.numRuedas = 0;
		this.nPlazas = 0;
		this.precio = 0;
	}

	public Vehiculo(Vehiculo v) {
		super();
		this.marca = v.marca;
		this.modelo = v.modelo;
		this.color = v.color;
		this.caballos = v.caballos;
		this.numRuedas = v.numRuedas;
		this.nPlazas = v.nPlazas;
		this.precio = v.precio;
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
		return marca + " " + modelo + " " + getColorString() + " tiene " + caballos + "cv y " + nPlazas + " plazas";
	}

	public void setColorString(String string) {
		switch (string) {
		case "rojo":
			Colores colorR = Colores.ROJO;
			setColor(colorR);
			break;
		case "azul":
			Colores colorA = Colores.AZUL;
			setColor(colorA);
			break;
		case "gris":
			Colores colorG = Colores.GRIS;
			setColor(colorG);
			break;
		case "blanco":
			Colores colorB = Colores.BLANCO;
			setColor(colorB);
			break;
		case "negro":
			Colores colorN = Colores.NEGRO;
			setColor(colorN);
			break;
		case "verde":
			Colores colorV = Colores.VERDE;
			setColor(colorV);
		default:
			break;  
		}
	}	

	public String getColorString() {
		return color.toString().toLowerCase();
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}


}