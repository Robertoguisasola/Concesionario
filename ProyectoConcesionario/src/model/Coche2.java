package model;

public class Coche2 extends Coche {
	
	private int kilometros;

	public Coche2(int numRuedas, int caballos, int nPlazas, Colores color, String marca, String modelo,
			boolean automatico, boolean lucesLed, boolean techoPanoramico, boolean traccion4x4, boolean modoDeportivo,
			int kilometros) {
		super(numRuedas, caballos, nPlazas, color, marca, modelo, automatico, lucesLed, techoPanoramico,
				traccion4x4, modoDeportivo);
		this.kilometros = kilometros;
	}

	public Coche2() {
		super(0, 0, 0, null, "", "", false, false, false,false, false);
		this.kilometros = 0;
	}

	public Coche2(Coche2 c) {
		super(c.numRuedas, c.caballos, c.nPlazas, c.color, c.marca, c.modelo, c.automatico, c.lucesLed,
				c.techoPanoramico, c.traccion4x4, c.modoDeportivo);
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