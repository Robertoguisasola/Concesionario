package model;

public class Coche extends Vehiculo {

	private boolean techoPanoramico;
	private boolean traccion4x4;
	private boolean modoDeportivo;
	
	
	public Coche(String matricula, int numRuedas, int caballos, int nPlazas, String color, String marca, String modelo,
			boolean motorDiesel, boolean automatico, boolean lucesLed, boolean techoPanoramico, boolean traccion4x4,
			boolean modoDeportivo) {
		super(matricula, numRuedas, caballos, nPlazas, color, marca, modelo, motorDiesel, automatico, lucesLed);
		this.techoPanoramico = techoPanoramico;
		this.traccion4x4 = traccion4x4;
		this.modoDeportivo = modoDeportivo;
	}


	public Coche() {
		super();
		this.techoPanoramico = false;
		this.traccion4x4 = false;
		this.modoDeportivo = false;
	}


	public Coche(Coche c) {
		super(c.matricula, c.numRuedas, c.caballos, c.nPlazas, c.color, c.marca, c.modelo, c.motorDiesel, c.automatico, c.lucesLed);
		this.techoPanoramico = c.techoPanoramico;
		this.traccion4x4 = c.traccion4x4;
		this.modoDeportivo = c.modoDeportivo;
	}
	
	
	
	

	
}
