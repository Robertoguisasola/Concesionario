package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Moto2Test {

	private Moto2 m2;
	private Moto2 prueba;
	private Moto2 empty;
	
	@Before
	public void setUp() throws Exception{
		m2 = new Moto2("Honda", "x", Colores.ROJO, 15, 2, 2, 1000, false, 5000);
		prueba = new Moto2(m2);
		empty = new Moto2();
	}

	@Test
	public void testGetKilometros() {
		assertEquals(5000, m2.getKilometros());
		assertEquals(5000, prueba.getKilometros());
		assertEquals(0, empty.getKilometros());
	}
	
	
	@Test
	public void testToString() {
		assertEquals("Honda x rojo tiene 15cv y 2 plazas, sin estructura protectora y 5000 kilómetros reales", m2.toString());
	}
	

}
