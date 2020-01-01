package model;

public class Coche extends Vehiculo {

	protected boolean motorDiesel;

	public Coche(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, boolean motorDiesel) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas);
		this.motorDiesel = motorDiesel;
	}

	public Coche() {
		super("", "", null, 0, 0, 0);
		this.motorDiesel = false;
	}

	public Coche(Coche c) {
		super(c.marca, c.modelo, c.color, c.caballos, c.numRuedas, c.nPlazas);
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
		return marca + " " + modelo + " " + color + ", " + caballos + "cv";
	}
}