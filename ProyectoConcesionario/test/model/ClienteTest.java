package model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	private Date fecha = new Date (0);
	private Cliente c;
	private Cliente prueba;
	private Cliente empty;

	@Before
	public void setUp() {
		c = new Cliente("roberto", "1234", "robertomargui@yahoo.es", "71708119F", "Roberto", "Guisasola", fecha, 0000);
		prueba = new Cliente(c);
		empty = new Cliente();
	}

	@Test
	public void testGetNumTarjeta() {
assertEquals(0000, c.getNumTarjeta());
assertEquals(0000, prueba.getNumTarjeta());
assertEquals(0000000000000000, empty.getNumTarjeta());
}

	@Test
	public void testSetNumTarjeta() {
		c.setNumTarjeta(75);
		assertEquals(75, c.getNumTarjeta());
	}

	@Test
	public void testToString() {
assertEquals("Roberto Guisasola, con DNI 71708119F y número de tarjeta 0", c.toString());
}

}
