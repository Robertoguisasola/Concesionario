package model;

public class Usuario {
	
	private String login;
	private String password;
	private String email;
	
	public Usuario() {
		
	}

	public Usuario(String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public Usuario(Usuario u) {
		super();
		this.login = u.login;
		this.password = u.password;
		this.email = u.email;
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

	@Override
	public String toString() {
		return "El usuario cuyo nombre de usuario es: " + login + ", tiene como contraseña: " + password + 
				"y como email: " + email;
	}
	
	
	
}
