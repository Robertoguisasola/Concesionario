package model;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

public class Coche2Test {
	private Coche2 c2;
	private Coche2 prueba;
	private Coche2 empty;
	
	@Before
	public void setUp() throws Exception{
		c2 = new Coche2("Volvo", "XC90", Colores.AZUL, 200, 4, 5, 0, true, 20000);
		prueba = new Coche2(c2);
		empty = new Coche2();
	}

	@Test
	public void testIsMotorDiesel() {
		assertEquals(true, c2.isMotorDiesel());
		assertEquals(true, prueba.isMotorDiesel());
		assertEquals(false, empty.isMotorDiesel());
	}
	
	@Test
	public void testSetMotorDiesel() {
		c2.setMotorDiesel(true);
		assertEquals(true, c2.isMotorDiesel());
	}
	
	@Test
	public void testToString() {
		assertEquals("Volvo XC90 azul tiene 200cv y 5 plazas, con motor diesel y 20000 kilómetros reales", c2.toString());
	}
	@Test
	public void venderCoche() {
		assertEquals("Volvo XC90 azul con motor diesel, 200cv y 5 plazas", c2.venderCoche());
	}

}