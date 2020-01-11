package model;

public class VentaMoto extends Venta {
	//TODO hacer clase
	//TODO tttt hacer test
	
	protected boolean escape;
	protected boolean paramanos;
	protected boolean guardabarrosGrande;
	
	public VentaMoto(Persona comprador, Moto moto, int precio, boolean automatico,
			boolean lucesLed, boolean escape, boolean paramanos, boolean guardabarrosGrande) {
		super(comprador, moto, precio, automatico, lucesLed);
		this.escape = escape;
		this.paramanos = paramanos;
		this.guardabarrosGrande = guardabarrosGrande;
	}

	public VentaMoto() {
		super(null, null, 0, false, false);
		this.escape = false;
		this.paramanos = false;
		this.guardabarrosGrande = false;
	}

	public VentaMoto(VentaMoto v) {
		super(v.comprador, v.vehiculo, v.precio, v.automatico, v.lucesLed);
		this.escape = v.escape;
		this.paramanos = v.paramanos;
		this.guardabarrosGrande = v.guardabarrosGrande;
		this.matricula = v.getMatricula();
	}

	public boolean isEscape() {
		return escape;
	}

	public void setEscape(boolean escape) {
		this.escape = escape;
	}

	public boolean isParamanos() {
		return paramanos;
	}

	public void setParamanos(boolean paramanos) {
		this.paramanos = paramanos;
	}

	public boolean isGuardabarrosGrande() {
		return guardabarrosGrande;
	}

	public void setGuardabarrosGrande(boolean guardabarrosGrande) {
		this.guardabarrosGrande = guardabarrosGrande;
	}

	public Moto getMoto() {
		return (Moto) vehiculo;
	}
}