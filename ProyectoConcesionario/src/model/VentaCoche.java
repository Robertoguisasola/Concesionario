package model;

public class VentaCoche extends Venta {

	//TODO zzzz crear constructor vacío, copia y getters y setters
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
}
