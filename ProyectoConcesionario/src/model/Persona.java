package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
	
	//TODO no parsea la fecha para los test

	protected String login;
	protected String password;
	protected String email;
	protected String dNI;
	protected String nombre;
	protected String apellidos;
	protected Date fechaNacimiento;
	public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Persona(String login, String password, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.dNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona() {
		super();
		this.login = "";
		this.password = "";
		this.email = "";
		this.dNI = "";
		this.nombre = "";
		this.apellidos = "";
		this.fechaNacimiento = null;
	}

	public Persona(Persona p) {
		super();
		this.login = p.login;
		this.password = p.password;
		this.email = p.email;
		this.dNI = p.dNI;
		this.nombre = p.nombre;
		this.apellidos = p.apellidos;
		this.fechaNacimiento = p.fechaNacimiento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getdNI() {
		return dNI;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getFechaNacimientoString() {
		return df.format(fechaNacimiento);
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setFechaNacimientoString (String fechaNacimiento) throws ParseException {
		this.fechaNacimiento = df.parse(fechaNacimiento);
	}
}