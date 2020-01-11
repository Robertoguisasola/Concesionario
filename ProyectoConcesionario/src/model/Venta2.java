package model;

public class Venta2 extends Venta implements SegundaMano{

	private int kilometros;

	public Venta2(Persona comprador, Vehiculo vehiculo, int precio, int kilometros) {
		super(comprador, vehiculo, precio, false, false);
		this.kilometros = kilometros;
	}

	public Venta2() {
		super(null, null, 0, false, false);
		this.kilometros = 0;
	}

	public Venta2(Venta2 v) {
		super(v.comprador, v.vehiculo, v.precio, false, false);
		this.kilometros = v.kilometros;
	}

	public int getKilometros() {
		return kilometros;
	}

	@Override
	public void numKilometros(int kilometros) {
		this.kilometros = kilometros;
	}




}
