package model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PersonaTest {

	private Date fecha = new Date(0);
	private Persona p;
	private Persona prueba;
	private Persona empty;

	@Before
	public void setUp() {
		p = new Persona("roberto", "1234", "robertomargui@yahoo.es", "71708119F", "Roberto", "Guisasola", fecha);
		prueba = new Persona(p);
		empty = new Persona();
	}

	@Test
	public void testGetLogin() {
		assertEquals("roberto", p.getLogin());
		assertEquals("roberto", prueba.getLogin());
		assertEquals("", empty.getLogin());
	}

	@Test
	public void testSetLogin() {
		p.setLogin("mikel");
		assertEquals("mikel", p.getLogin());
	}

	@Test
	public void testGetPassword() {
		assertEquals("1234", p.getPassword());
		assertEquals("1234", prueba.getPassword());
		assertEquals("", empty.getPassword());
	}

	@Test
	public void testSetPassword() {
		p.setPassword("probando");
		assertEquals("probando", p.getPassword());
	}

	@Test
	public void testGetEmail() {
		assertEquals("robertomargui@yahoo.es", p.getEmail());
		assertEquals("robertomargui@yahoo.es", prueba.getEmail());
		assertEquals("", empty.getEmail());
	}

	@Test
	public void testSetEmail() {
		p.setEmail("mikel.romero@opendeusto.es");
		assertEquals("mikel.romero@opendeusto.es", p.getEmail());
	}

	@Test
	public void testGetdNI() {
		assertEquals("71708119F", p.getdNI());
		assertEquals("71708119F", prueba.getdNI());
		assertEquals("", empty.getdNI());
	}

	@Test
	public void testSetdNI() {
		p.setdNI("20976509A");
		assertEquals("20976509A", p.getdNI());
	}

	@Test
	public void testGetNombre() {
		assertEquals("Roberto", p.getNombre());
		assertEquals("Roberto", prueba.getNombre());
		assertEquals("", empty.getNombre());
	}

	@Test
	public void testSetNombre() {
		p.setNombre("Mikel");
		assertEquals("Mikel", p.getNombre());
	}

	@Test
	public void testGetApellidos() {
		assertEquals("Guisasola", p.getApellidos());
		assertEquals("Guisasola", prueba.getApellidos());
		assertEquals("", empty.getApellidos());
	}

	@Test
	public void testSetApellidos() {
		p.setApellidos("Romero");
		assertEquals("Romero", p.getApellidos());
	}

	@Test
	public void testGetFechaNacimiento() {
		assertEquals(fecha, p.getFechaNacimiento());
		assertEquals(fecha, prueba.getFechaNacimiento());
		assertEquals(null, empty.getFechaNacimiento());
	}

	@Test
	public void testGetFechaNacimientoString() {
		assertEquals("01/01/1970", p.getFechaNacimientoString());
		assertEquals("01/01/1970", prueba.getFechaNacimientoString());
	}

	@Test
	public void testSetFechaNacimiento() {
		Date f = new Date(0);
		p.setFechaNacimiento(f);
		assertEquals(f, p.getFechaNacimiento());
	}

	@Test
	public void testSetFechaNacimientoString() throws ParseException {
		p.setFechaNacimientoString("5/5/2005");
		assertEquals("05/05/2005", p.getFechaNacimientoString());
	}
}