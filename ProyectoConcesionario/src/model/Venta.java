package model;

public class Venta {
	//TODO meter todos los valores de una venta
	
	protected Cliente comprador;
	protected Vehiculo vehiculo;
	protected int precio;
	protected String matricula;
	protected boolean automatico;
	protected boolean lucesLed;
	
	
	public Venta(Cliente comprador, Vehiculo vehiculo, int precio, String matricula) {
		super();
		this.comprador = comprador;
		this.vehiculo = vehiculo;
		this.precio = precio;
		this.matricula = matricula;
	}
	
	public Venta() {
		super();
		this.comprador = null;
		this.vehiculo = null;
		this.precio = 0;
		this.matricula = null;
	}
	
	public Venta(Venta v) {
		super();
		this.comprador = v.comprador;
		this.vehiculo = v.vehiculo;
		this.precio = v.precio;
		this.matricula = v.matricula;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Venta [comprador=" + comprador + ", vehiculo=" + vehiculo + ", precio=" + precio + ", matricula="
				+ matricula + "]";
	}
	
	
}	
