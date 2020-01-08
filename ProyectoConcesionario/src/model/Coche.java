package model;

public class Coche extends Vehiculo {

	protected boolean motorDiesel;

	public Coche(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas, int precio, boolean motorDiesel) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, precio);
		this.motorDiesel = motorDiesel;
	}

	public Coche() {
		super("", "", null, 0, 0, 0, 0);
		this.motorDiesel = false;
	}

	public Coche(Coche c) {
		super(c.marca, c.modelo, c.color, c.caballos, c.numRuedas, c.nPlazas, c.precio);
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
		String diesel;
		
		if (motorDiesel) {
			diesel = "con motor diesel";
		} else {
			diesel = "con motor de gasolina";
		}
		return marca + " " + modelo + " " + getColorString() + " tiene " + caballos + "cv y " + nPlazas + " plazas, " + diesel;
	}
}