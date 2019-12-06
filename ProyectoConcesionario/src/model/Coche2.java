package model;

public class Coche2 extends Coche {
	
	private int kilometros;

	public Coche2(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, String urlFoto,
			boolean motorDiesel, int kilometros) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, urlFoto, motorDiesel);
		this.kilometros = kilometros;
	}

	public Coche2() {
		super("", "", null, 0, 0, 0, null, false);
		this.kilometros = 0;
	}

	public Coche2(Coche2 c) {
		super(c.marca, c.modelo, c.color, c.caballos, c.numRuedas, c.nPlazas, c.urlFoto, c.motorDiesel);
		this.kilometros = c.kilometros;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	@Override
	public String toString() {
		return "Coche2 [kilometros=" + kilometros + ", motorDiesel=" + motorDiesel + ", marca=" + marca + ", modelo="
				+ modelo + ", color=" + color + ", caballos=" + caballos + ", numRuedas=" + numRuedas + ", nPlazas="
				+ nPlazas + ", urlFoto=" + urlFoto + "]";
	}

}