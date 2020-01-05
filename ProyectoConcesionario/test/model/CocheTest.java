package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CocheTest {
	
	private Coche c;
	private Coche prueba;
	private Coche empty;
	
	@Before
	public void setUp() throws Exception{
		c = new Coche("Volvo", "GG", Colores.VERDE, 200, 4, 5, true);
		prueba = new Coche(c);
		empty = new Coche();
	}

	@Test
	public void testIsMotorDiesel() {
		assertEquals(true, c.isMotorDiesel());
		assertEquals(true, prueba.isMotorDiesel());
		assertEquals(false, empty.isMotorDiesel());
	}
	
	@Test
	public void testSetMotorDiesel() {
		c.setMotorDiesel(true);
		assertEquals(true, c.isMotorDiesel());
	}
	
	@Test
	public void testToString() {
		assertEquals("Volvo GG VERDE, 200cv", c.toString());
	}
	
}