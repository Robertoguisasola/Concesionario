package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class VentaTest {

	private Cliente c;
	private Vehiculo ch;
	private Date fecha = new Date(0);
	private Venta v;
	private Venta prueba;
	private Venta empty;
	

	@Before
	public void setUp() throws Exception {
		c = new Cliente("roberto", "1234", "robertomargui@yahoo.es", "71708119F", "Roberto", "Guisasola", fecha, 0000);
		ch = new Vehiculo("Volvo", "GG", Colores.VERDE, 200, 4, 5, 0);
		v = new Venta(c, ch, 89000, "8219GZM", false, false);
		prueba = new Venta(v);
		empty = new Venta();
	}

	@Test
	public void testGetComprador() {
		assertEquals(c, v.getComprador());
		assertEquals(c, prueba.getComprador());
		assertEquals(null, empty.getComprador());
	}

	@Test
	public void testSetComprador() {
		Cliente cl = new Cliente("mikel", "1234", "mikel.romero@opendeusto.es", "20976509A", "Mikel", "Romero", fecha, 0);
v.setComprador(cl);
assertEquals(cl, v.getComprador());
	}

	@Test
	public void testGetVehiculo() {
assertEquals(ch, v.getVehiculo());
assertEquals(ch, v.getVehiculo());
assertEquals(null, empty.getVehiculo());
}

	@Test
	public void testSetVehiculo() {
Vehiculo vh = new Vehiculo("Nissan", "Juke", Colores.AZUL, 150, 4, 5, 0);
v.setVehiculo(vh);
assertEquals(vh, v.getVehiculo());
}

	@Test
	public void testGetPrecio() {
		assertEquals(89000, v.getPrecio());
		assertEquals(89000, v.getPrecio());
		assertEquals(0, empty.getPrecio());
		}

	@Test
	public void testSetPrecio() {
v.setPrecio(84000);
assertEquals(84000, v.getPrecio());
}

	@Test
	public void testGetMatricula() {
		assertEquals("8219GZM", v.getMatricula());
		assertEquals("8219GZM", v.getMatricula());
		assertEquals(null, empty.getMatricula());
		}

	@Test
	public void testSetMatricula() {
		v.setMatricula("1278DYS");
		assertEquals("1278DYS", v.getMatricula());
		}

	@Test
	public void testIsAutomatico() {
		if (v.isAutomatico()) {
			fail("El coche no es automático");
		} else {
assertEquals(false, v.isAutomatico());
		}
		
		if (prueba.isAutomatico()) {
			fail("El coche no es automático. Comprobar constructor copia");
		} else {
assertEquals(false, prueba.isAutomatico());
		}
		
		if (empty.isAutomatico()) {
			fail("El coche no es automático. Comprobar constructor vacío");
		} else {
assertEquals(false, empty.isAutomatico());
		}
	}

	@Test
	public void testSetAutomatico() {
v.setAutomatico(true);
assertEquals(true, v.isAutomatico());
}

	@Test
	public void testIsLucesLed() {
		if (v.isLucesLed()) {
			fail("El coche no tiene luces led");
		} else {
assertEquals(false, v.isLucesLed());
		}
		
		if (prueba.isLucesLed()) {
			fail("El coche no tiene luces led. Comprobar constructor copia");
		} else {
assertEquals(false, prueba.isLucesLed());
		}
		
		if (empty.isAutomatico()) {
			fail("El coche no es automático. Comprobar constructor vacío");
		} else {
assertEquals(false, empty.isAutomatico());
		}
	}	

	@Test
	public void testSetLucesLed() {
v.setLucesLed(true);
assertEquals(true, v.isLucesLed());
}

	@Test
	public void testToString() {
assertEquals(c.toString() + " ha comprado " + ch.toString() + " por 89000€, con matrícula 8219GZM", v.toString());	}

}
