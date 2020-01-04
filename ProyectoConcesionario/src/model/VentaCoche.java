package model;

public class VentaCoche extends Venta {

	protected boolean techoPanoramico;
	protected boolean traccion4x4;
	protected boolean modoDeportivo;
	
	public VentaCoche(Cliente comprador, Vehiculo vehiculo, int precio, String matricula, boolean techoPanoramico,
			boolean traccion4x4, boolean modoDeportivo) {
		super(comprador, vehiculo, precio, matricula);
		this.techoPanoramico = techoPanoramico;
		this.traccion4x4 = traccion4x4;
		this.modoDeportivo = modoDeportivo;
	}
	
	public VentaCoche() {
		super(null, null, 0, "");
		this.techoPanoramico = false;
		this.traccion4x4 = false;
		this.modoDeportivo = false; 
	}
	
	public VentaCoche(VentaCoche v) {
		super(v.comprador, v.vehiculo, v.precio, v.matricula);
		this.techoPanoramico = v.techoPanoramico;
		this.traccion4x4 = v.traccion4x4;
		this.modoDeportivo = v.modoDeportivo;
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
}