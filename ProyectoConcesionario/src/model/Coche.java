package model;

public class Coche extends Vehiculo {

	protected boolean motorDiesel;

	public Coche(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, String urlFoto,
			boolean motorDiesel) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, urlFoto);
		this.motorDiesel = motorDiesel;
	}

	public Coche() {
		super("", "", null, 0, 0, 0, null);
		this.motorDiesel = false;
	}

	public Coche(Coche c) {
		super(c.marca, c.modelo, c.color, c.caballos, c.numRuedas, c.nPlazas, c.urlFoto);
		this.motorDiesel = c.motorDiesel;
	}

	public boolean isMotorDiesel() {
		return motorDiesel;
	}

	public void setMotorDiesel(boolean motorDiesel) {
		this.motorDiesel = motorDiesel;
	}

	@Override
	public String toString() {
		return "Coche [motorDiesel=" + motorDiesel + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", caballos=" + caballos + ", numRuedas=" + numRuedas + ", nPlazas=" + nPlazas + ", urlFoto="
				+ urlFoto + "]";
	}
	
}