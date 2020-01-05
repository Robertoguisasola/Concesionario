package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TrabajadorTest {
	
	private Date fecha = new Date(0);
	private Trabajador t;
	private Trabajador prueba;
	private Trabajador empty;
	private Trabajador admin;
	

	@Before
	public void setUp() throws Exception {
		t = new Trabajador("roberto", "1234", "robertomargui@yahoo.es", "71708119F", "Roberto", "Guisasola", fecha, 2200, false);
		prueba = new Trabajador(t);
		empty = new Trabajador();
		admin = new Trabajador("admin", "admin", "admin@concesionario.es", "00000000T", "Gerente", "Concesionario", fecha, 5000, true);
	}

	@Test
	public void testGetSueldo() {
		assertEquals(2200, t.getSueldo());
		assertEquals(2200, prueba.getSueldo());
		assertEquals(0, empty.getSueldo());
		assertEquals(5000, admin.getSueldo());
	}

	@Test
	public void testSetSueldo() {
		t.setSueldo(3000);
		assertEquals(3000, t.getSueldo());
	}

	@Test
	public void testIsAdmin() {
		if (t.isAdmin()) {
			fail("T no es administrador");
		} else {
			assertEquals(false, t.isAdmin());
		}

		if (prueba.isAdmin()) {
			fail("Prueba no es administrador, es una copia de t. Revisa el constructor copia");
		} else {
			assertEquals(false, prueba.isAdmin());
		}

		if (empty.isAdmin()) {
			fail("El trabajador vacío no es administrador. Revisa el constructor vacío");
		} else {
			assertEquals(false, empty.isAdmin());
		}

		if (admin.isAdmin()) {
			assertEquals(true, admin.isAdmin());
		} else {
			fail("El admin si que es administrador. Revisa los constructores");
		}
	}

	@Test
	public void testSetAdmin() {
		t.setAdmin(true);
		if (!t.isAdmin()) {
			fail("El setter de administrador no funciona correctamente");
		}
	}

	@Test
	public void testToString() {
		assertEquals("Roberto Guisasola con DNI 71708119F no es administrador y posee un sueldo de 2200€", t.toString());
		assertEquals("Gerente Concesionario con DNI 00000000T es administrador y posee un sueldo de 5000€", admin.toString());
	}
}