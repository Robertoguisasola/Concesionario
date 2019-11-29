package model;

public class Coche extends Vehiculo {

	protected boolean techoPanoramico;
	protected boolean traccion4x4;
	protected boolean modoDeportivo;
	
	public Coche(int numRuedas, int caballos, int nPlazas, Colores color, String marca, String modelo,
			boolean automatico, boolean lucesLed, boolean techoPanoramico, boolean traccion4x4,
			boolean modoDeportivo) {
		super(numRuedas, caballos, nPlazas, color, marca, modelo, automatico, lucesLed);
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
		super(c.numRuedas, c.caballos, c.nPlazas, c.color, c.marca, c.modelo, c.automatico, c.lucesLed);
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
				+ modoDeportivo + ", numRuedas=" + numRuedas + ", caballos=" + caballos + ", nPlazas=" + nPlazas
				+ ", color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", automatico=" + automatico
				+ ", lucesLed=" + lucesLed + "]";
	}
}