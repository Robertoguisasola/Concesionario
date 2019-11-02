package model;

public class Moto extends Vehiculo {

	private boolean estructuraProtectora;
	private int grosorRuedas;
	
	public Moto(String matricula, int numRuedas, int caballos, int nPlazas, String color, String marca, String modelo,
			 boolean automatico, boolean lucesLed, boolean estructuraProtectora, int grosorRuedas) {
		super(matricula, numRuedas, caballos, nPlazas, color, marca, modelo, automatico, lucesLed);
		this.estructuraProtectora = estructuraProtectora;
		this.grosorRuedas = grosorRuedas;
	}

	public Moto() {
		super();
		this.estructuraProtectora = false;
		this.grosorRuedas = 0;
	}

	public Moto(Moto m) {
		super(m.matricula, m.numRuedas, m.caballos, m.nPlazas, m.color, m.marca, m.modelo, m.automatico, m.lucesLed);
		this.estructuraProtectora = m.estructuraProtectora;
		this.grosorRuedas = m.grosorRuedas;
	}

	public boolean isEstructuraProtectora() {
		return estructuraProtectora;
	}

	public void setEstructuraProtectora(boolean estructuraProtectora) {
		this.estructuraProtectora = estructuraProtectora;
	}

	public int getGrosorRuedas() {
		return grosorRuedas;
	}

	public void setGrosorRuedas(int grosorRuedas) {
		this.grosorRuedas = grosorRuedas;
	}

	@Override
	public String toString() {
		return "Moto [estructuraProtectora=" + estructuraProtectora + ", grosorRuedas=" + grosorRuedas + ", matricula="
				+ matricula + ", numRuedas=" + numRuedas + ", caballos=" + caballos + ", nPlazas=" + nPlazas
				+ ", color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", automatico=" + automatico
				+ ", lucesLed=" + lucesLed + "]";
	}
	


	
	
}
