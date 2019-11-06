package model;

public class Venta {
	private Cliente comprador;
	private Vehiculo vehiculo;
	private int precio;
	
	public Venta(Cliente comprador, Vehiculo vehiculo, int precio) {
		super();
		this.comprador = comprador;
		this.vehiculo = vehiculo;
		this.precio = precio;
	}
	public Venta() {
		super();
		this.comprador = null;
		this.vehiculo = null;
		this.precio = 0;
	}
	public Venta(Venta v) {
		super();
		this.comprador = v.comprador;
		this.vehiculo = v.vehiculo;
		this.precio = v.precio;
	}
	
	public Cliente getComprador() {
		return comprador;
	}
	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Venta [comprador=" + comprador + ", vehiculo=" + vehiculo + ", precio=" + precio + "]";
	}
}	
