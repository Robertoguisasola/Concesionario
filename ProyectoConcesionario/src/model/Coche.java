package model;

public class Coche extends Vehiculo {

	protected boolean techoPanoramico;
	protected boolean traccion4x4;
	protected boolean modoDeportivo;

	public Coche(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas,
			boolean automatico, boolean lucesLed, boolean techoPanoramico, boolean traccion4x4, boolean modoDeportivo) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, automatico, lucesLed);
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
		super(c.marca, c.modelo, c.color, c.caballos, c.numRuedas, c.nPlazas, c.automatico, c.lucesLed);
		this.techoPanoramico = c.techoPanoramico;
		this.traccion4x4 = c.traccion4x4;
		this.modoDeportivo = c.modoDeportivo;
	}

	public boolean isTechoPanoramico() {
		return techoPanoramico;
	}

	public void setTechoPanoramico(boolean techoPanoramico) {
		this.techoPanoramico = techoPanoramico;
	}

	public boolean isTraccion4x4() {
		return traccion4x4;
	}

	public void setTraccion4x4(boolean traccion4x4) {
		this.traccion4x4 = traccion4x4;
	}

	public boolean isModoDeportivo() {
		return modoDeportivo;
	}

	public void setModoDeportivo(boolean modoDeportivo) {
		this.modoDeportivo = modoDeportivo;
	}

	@Override
	public String toString() {
		return "Coche [techoPanoramico=" + techoPanoramico + ", traccion4x4=" + traccion4x4 + ", modoDeportivo="
				+ modoDeportivo + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", caballos="
				+ caballos + ", numRuedas=" + numRuedas + ", nPlazas=" + nPlazas + ", automatico=" + automatico
				+ ", lucesLed=" + lucesLed + "]";
	}

	
}