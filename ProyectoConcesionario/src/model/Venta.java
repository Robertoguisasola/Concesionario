package model;

public class Venta {
	
	protected Persona comprador;
	protected Vehiculo vehiculo;
	protected int precio;
	protected String matricula;
	protected boolean automatico;
	protected boolean lucesLed;
	
	
	public Venta(Persona comprador, Vehiculo vehiculo, int precio, String matricula, boolean automatico, boolean lucesLed) {
		super();
		this.comprador = comprador;
		this.vehiculo = vehiculo;
		this.precio = precio;
		this.matricula = matricula;
		this.automatico = automatico;
		this.lucesLed = lucesLed;
	}
	
	public Venta() {
		super();
		this.comprador = null;
		this.vehiculo = null;
		this.precio = 0;
		this.matricula = null;
		this.automatico = false;
		this.lucesLed = false;
	}
	
	public Venta(Venta v) {
		super();
		this.comprador = v.comprador;
		this.vehiculo = v.vehiculo;
		this.precio = v.precio;
		this.matricula = v.matricula;
		this.automatico = v.automatico;
		this.lucesLed = v.lucesLed;
	}
	
	public Persona getComprador() {
		return comprador;
	}
	
	public void setComprador(Persona comprador) {
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
	
	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public boolean isLucesLed() {
		return lucesLed;
	}

	public void setLucesLed(boolean lucesLed) {
		this.lucesLed = lucesLed;
	}

	@Override
	public String toString() {
		return comprador.toString() + " ha comprado " + vehiculo.toString() + " por " + precio + "€, con matrícula " + matricula;
	}	
}