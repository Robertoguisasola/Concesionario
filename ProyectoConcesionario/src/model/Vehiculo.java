package model;

public class Vehiculo {
	
	protected String matricula;
	protected int numRuedas;
	protected int caballos;
	protected int nPlazas;
	protected String color;
	protected String marca;
	protected String modelo;
	protected boolean motorDiesel;
	protected boolean automatico;
	protected boolean lucesLed;
	
	
	public Vehiculo(String matricula, int numRuedas, int caballos, int nPlazas, String color, String marca,
			String modelo, boolean motorDiesel, boolean automatico, boolean lucesLed) {
		super();
		this.matricula = matricula;
		this.numRuedas = numRuedas;
		this.caballos = caballos;
		this.nPlazas = nPlazas;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.motorDiesel = motorDiesel;
		this.automatico = automatico;
		this.lucesLed = lucesLed;
	}


	public Vehiculo() {
		super();
		this.matricula = "";
		this.numRuedas = 0;
		this.caballos = 0;
		this.nPlazas = 0;
		this.color = "";
		this.marca = "";
		this.modelo = "";
		this.motorDiesel = false;
		this.automatico = false;
		this.lucesLed = false;
	}


	public Vehiculo(Vehiculo v) {
		super();
		this.matricula = v.matricula;
		this.numRuedas = v.numRuedas;
		this.caballos = v.caballos;
		this.nPlazas = v.nPlazas;
		this.color = v.color;
		this.marca = v.marca;
		this.modelo = v.modelo;
		this.motorDiesel = v.motorDiesel;
		this.automatico = v.automatico;
		this.lucesLed = v.lucesLed;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public boolean isMotorDiesel() {
		return motorDiesel;
	}

	public void setMotorDiesel(boolean motorDiesel) {
		this.motorDiesel = motorDiesel;
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

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", numRuedas=" + numRuedas + ", caballos=" + caballos + ", nPlazas="
				+ nPlazas + ", color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", motorDiesel="
				+ motorDiesel + ", automatico=" + automatico + ", lucesLed=" + lucesLed + "]";
	}
}