package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class VentaCocheTest {
	
	//TODO tttt meter coches de 2ª mano, motos...
	private Cliente c;
	private Coche ch;
	private Date fecha = new Date(0);
	private VentaCoche v;
	private VentaCoche prueba;
	private VentaCoche empty;
	

	@Before
	public void setUp() throws Exception {
		c = new Cliente("roberto", "1234", "robertomargui@yahoo.es", "71708119F", "Roberto", "Guisasola", fecha, 0000);
		ch = new Coche("Volvo", "GG", Colores.VERDE, 200, 4, 5, 0, true);
		v = new VentaCoche(c, ch, 89000, "8219GZM", false, false, false, true, false);
		prueba = new VentaCoche(v);
		empty = new VentaCoche();
	}

	@Test
	public void testIsTechoPanoramico() {
		if (v.isTechoPanoramico()) {
			fail("La venta no tiene el techo panorámico");
		} else {
			assertEquals(false, v.isTechoPanoramico());
		}
		
		if (prueba.isTechoPanoramico()) {
			fail("La venta no tiene el techo panorámico. Comprobar constructor copia");
		} else {
			assertEquals(false, v.isTechoPanoramico());
		}
		
		if (empty.isTechoPanoramico()) {
			fail("La venta no tiene el techo panorámico. Comprobar constructor vacío");
		} else {
			assertEquals(false, v.isTechoPanoramico());
		}
		
		}

	@Test
	public void testSetTechoPanoramico() {
		v.setTechoPanoramico(true);
		if (!(v.isTechoPanoramico())) {
			fail("La venta no tiene el techo panorámico");
		} else {
			assertEquals(true, v.isTechoPanoramico());
		}
	}

	@Test
	public void testIsTraccion4x4() {
		if (!(v.isTraccion4x4())) {
			fail("La venta tiene tracción 4X4");
		} else {
			assertEquals(true, v.isTraccion4x4());
		}	
		
		if (!(prueba.isTraccion4x4())) {
			fail("La venta tiene tracción 4X4. Comprobar constructor copia");
		} else {
			assertEquals(true, prueba.isTraccion4x4());
		}
		
		if (empty.isTraccion4x4()) {
			fail("La venta no tiene tracción 4X4. Comprobar constructor vacío");
		} else {
			assertEquals(false, empty.isTraccion4x4());
		}
	}

	@Test
	public void testSetTraccion4x4() {
v.setTraccion4x4(false);
assertEquals(false, v.isTraccion4x4());
}

	@Test
	public void testIsModoDeportivo() {
		if (v.isModoDeportivo()) {
			fail("La venta no tiene modo deportivo");
		} else {
			assertEquals(false, v.isModoDeportivo());
		}	
		
		if (prueba.isModoDeportivo()){
			fail("La venta no tiene modo deportivo. Comprobar constructor copia");
		} else {
			assertEquals(true, prueba.isTraccion4x4());
		}
		
		if (empty.isModoDeportivo()) {
			fail("La venta no tiene modo deportivo. Comprobar constructor vacío");
		} else {
			assertEquals(false, empty.isTraccion4x4());
		}
}

	@Test
	public void testSetModoDeportivo() {
		v.setModoDeportivo(true);
		assertEquals(true, v.isModoDeportivo());
		}
}