package model;

public class Coche2 extends Coche {
	
	private int kilometros;

	public Coche2(String marca, String modelo, Colores color, int caballos, int numRuedas, int nPlazas,
			boolean automatico, boolean lucesLed, String urlFoto, boolean techoPanoramico, boolean traccion4x4, boolean modoDeportivo,
			int kilometros) {
		super(marca, modelo, color, caballos, numRuedas, nPlazas, automatico, lucesLed, urlFoto, techoPanoramico, traccion4x4,
				modoDeportivo);
		this.kilometros = kilometros;
	}

	public Coche2() {
		super();
		this.kilometros = 0;
	}

	public Coche2(Coche2 c) {
		super(c.marca, c.modelo, c.color, c.caballos, c.numRuedas, c.nPlazas, c.automatico, c.lucesLed, c.urlFoto, c.techoPanoramico, c.traccion4x4,
				c.modoDeportivo);
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
		return "Coche2 [kilometros=" + kilometros + ", techoPanoramico=" + techoPanoramico + ", traccion4x4="
				+ traccion4x4 + ", modoDeportivo=" + modoDeportivo + ", numRuedas=" + numRuedas + ", caballos="
				+ caballos + ", nPlazas=" + nPlazas + ", color=" + color + ", marca=" + marca + ", modelo=" + modelo
				+ ", automatico=" + automatico + ", lucesLed=" + lucesLed + "]";
	}
}