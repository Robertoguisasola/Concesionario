package model;

public class Moto2 extends Moto implements SegundaMano {

	private int kilometros;

	public Moto2(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, int precio,
			boolean estructuraProtectora, int kilometros) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, precio, estructuraProtectora);
		this.kilometros = kilometros;
	}

	public Moto2() {
		super(null, null, null, 0, 0, 0, 0, false);
		this.kilometros = 0;
	}

	public Moto2(Moto2 m) {
		super(m.marca, m.modelo, m.color, m.caballos, m.numRuedas, m.nPlazas, m.precio, m.estructuraProtectora);
		this.kilometros = m.kilometros;
	}

	public int getKilometros() {
		return kilometros;
	}

	@Override
	public String toString() {
		String estructura;

		if (estructuraProtectora) {
			estructura = "con ";
		} else {
			estructura = "sin ";
		}
		return marca + " " + modelo + " " + getColorString() + " tiene " + caballos + "cv y " + nPlazas + " plazas, " + estructura + "estructura protectora y " + kilometros + " kilómetros reales";
	}

	@Override
	public void numKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public String venderMoto2() {
		return marca + " " + modelo + " " + getColorString() + estructuraProtectoraString() + ", " + caballos + " cv y " + nPlazas + " plazas y " + kilometros + " kilómetros reales";
	}
}