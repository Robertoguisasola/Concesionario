package model;

public class Coche2 extends Coche implements SegundaMano{

	private int kilometros;

	public Coche2(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, int precio,
			boolean motorDiesel, int kilometros) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, precio, motorDiesel);
		this.kilometros = kilometros;
	}

	public Coche2() {
		super("", "", null, 0, 0, 0, 0, false);
		this.kilometros = 0;
	}

	public Coche2(Coche2 c) {
		super(c.marca, c.modelo, c.color, c.caballos, c.numRuedas, c.nPlazas, c.precio, c.motorDiesel);
		this.kilometros = c.kilometros;
	}

	public int getKilometros() {
		return kilometros;
	}

	@Override
	public String toString() {
		return marca + " " + modelo + " " + getColorString() + " tiene " + caballos + "cv y " + nPlazas + " plazas," + motorDieselString() + " y " + kilometros + " kilómetros reales";
	}

	@Override
	public void numKilometros(int kilometros) {
		this.kilometros = kilometros;	
	}

	public String venderCoche2() {
		return marca + " " + modelo + " " + getColorString() + motorDieselString() + ", " + caballos + " cv y " + nPlazas + " plazas y " + kilometros + " kilómetros reales";
	}
}