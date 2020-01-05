package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehiculoTest {

	private Vehiculo v;
	private Vehiculo prueba;
	private Vehiculo empty;
	
	
	@Before
	public void setUp() {
		v = new Vehiculo("Volvo", "GG", Colores.VERDE, 200, 4, 5);
		prueba = new Vehiculo(v);
		empty = new Vehiculo();
		
	}
	
	@Test
	public void testGetMarca() {
		assertEquals("Volvo", v.getMarca());
		assertEquals("Volvo", prueba.getMarca());
		assertEquals(null, empty.getMarca());
	}
	
	@Test
	public void testSetMarca() {
		v.setMarca("Audi");
		assertEquals("Audi", v.getMarca());
	}
	
	@Test
	public void testGetModelo() {
		assertEquals("GG", v.getModelo());
		assertEquals("GG", prueba.getModelo());
		assertEquals(null, empty.getModelo());
	}
	
	@Test
	public void testSetModelo() {
		v.setModelo("AA");
		assertEquals("AA", v.getModelo());
	}
	
	@Test
	public void testGetColor() {
		assertEquals(Colores.VERDE, v.getColor());
		assertEquals(Colores.VERDE, prueba.getColor());
		assertEquals(null, empty.getColor());
	}
	
	@Test
	public void testSetColor() {
		v.setColor(Colores.AZUL);
		assertEquals(Colores.AZUL, v.getColor());
	}
	
	@Test
	public void testGetCaballos() {
		assertEquals(200, v.getCaballos());
		assertEquals(200, prueba.getCaballos());
		assertEquals(0, empty.getCaballos());
	}
	
	@Test
	public void testSetCaballos() {
		v.setCaballos(190);
		assertEquals(190, v.getCaballos());
	}
	
	@Test
	public void testGetNumRuedas() {
		assertEquals(4, v.getNumRuedas());
		assertEquals(4, prueba.getNumRuedas());
		assertEquals(0, empty.getNumRuedas());
	}
	
	@Test
	public void testSetNumRuedas() {
		v.setNumRuedas(3);
		assertEquals(3, v.getNumRuedas());
	}
	
	@Test
	public void testGetnPlazas() {
		assertEquals(5, v.getnPlazas());
		assertEquals(5, prueba.getnPlazas());
		assertEquals(0, empty.getnPlazas());
	}
	
	@Test
	public void testSetnPlazas() {
		v.setnPlazas(2);
		assertEquals(2, v.getnPlazas());
	}
	
	//TODO aaaa hacer test de setColor 
	@Test
	public void testSetColor(String string) {
		switch (string) {
		case "rojo":
			Colores colorR = Colores.ROJO;
			assertEquals(Colores.ROJO, colorR);
			break;
		default:
			break;
		}
		
	}
	
	
	

}