package datos;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Barco {
	//Atributos de la clase
	private String codigo;
	private String nombre;
	private String email;
	private TipoBarco tipo;
	private String oceano;
	private ArrayList<Marea> lMareas;
	
	public Barco(String nombre, String email, String codigo, TipoBarco tipo, String oceano) {
		if(nombre == null){
			throw new NullPointerException("Nombre es nulo");
		}
		Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		if(email != null && pattern.matcher(email).matches()){
			this.email = email;
		}	    
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
		this.oceano = oceano;
		this.lMareas = new ArrayList<Marea>();
	}
	
	//Métodos get/set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public TipoBarco getTipo() {
		return tipo;
	}
	public void setTipo(TipoBarco tipo) {
		this.tipo = tipo;
	}
	public String getOceano() {
		return oceano;
	}
	public void setOceano(String oceano) {
		this.oceano = oceano;
	}
	public ArrayList<Marea> getlMareas() {
		return lMareas;
	}
	public void resetMareas() {
		this.lMareas = new ArrayList<Marea>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
