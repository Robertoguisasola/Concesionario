package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotoTest {
	private Moto m;
	private Moto prueba;
	private Moto empty;
	
	@Before
	public void setUp() throws Exception{
		m = new Moto("Honda", "x", Colores.ROJO, 15, 2, 2, 1000, false);
		prueba = new Moto(m);
		empty = new Moto();
	}

	@Test
	public void testIsEstructuraProtectora() {
		assertEquals(false, m.isEstructuraProtectora());
		assertEquals(false, prueba.isEstructuraProtectora());
		assertEquals(false, empty.isEstructuraProtectora());
	}
	
	@Test
	public void testEstructuraProtectora() {
		m.setEstructuraProtectora(true);
		assertEquals(true, m.isEstructuraProtectora());
	}
	
	@Test
	public void testToString() {
		assertEquals("Honda x rojo tiene 15cv y 2 plazas, sin estructura protectora", m.toString());
	}
	@Test
	public void venderMoto() {
		assertEquals("Honda x rojo sin estructura protectora, 15cv y 2 plazas", m.venderMoto());
	}

}
