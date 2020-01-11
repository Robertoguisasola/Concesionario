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
		c = new Coche("Volvo", "XC90", Colores.AZUL, 200, 4, 5, 0, true);
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
		assertEquals("Volvo XC90 azul tiene 200cv y 5 plazas, con motor diesel", c.toString());
	}
	@Test
	public void venderCoche() {
		assertEquals("Volvo XC90 azul con motor diesel, 200cv y 5 plazas", c.venderCoche());
	}
}