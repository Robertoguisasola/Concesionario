package model;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class ConcesionarioTest {
	//TODO hacer todos los test necesarios
	
	private Concesionario c;
	
	@Before
	public void setUp() {
		c = new Concesionario();
		c.cargarTrabajadores();
	}
	
	//TODO Test del método de añadir clientes
	@Test
	public void testCargarTrabajadores() {
		Iterator<Trabajador>it = c.getTrabajadores().iterator();		
	
		try {
			File f = new File("ficheros/trabajadores.csv");
			Scanner sc = new Scanner(f);

			while(sc.hasNextLine() && it.hasNext()) {
				String linea = sc.nextLine();				
				//Cada campo está partido por ;
				Trabajador cmp = new Trabajador();
				Trabajador t = it.next();
				
				String[] campos = linea.split(";");// recibe un argumento y devuleve un array de Strings 
				
				cmp.setLogin(campos[0]);
				cmp.setPassword(campos[1]);
				cmp.setEmail(campos[2]);
				cmp.setdNI(campos[3]);
				cmp.setNombre(campos[4]);
				cmp.setApellidos(campos[5]);
				cmp.setFechaNacimientoString((campos[6]));
				cmp.setSueldo(Integer.parseInt(campos[7]));
				
				assertEquals(cmp.getLogin(), t.getLogin());
				assertEquals(cmp.getPassword(), t.getPassword());
				assertEquals(cmp.getEmail(), t.getEmail());
				assertEquals(cmp.getdNI(), t.getdNI());
				assertEquals(cmp.getNombre(), t.getNombre());
				assertEquals(cmp.getApellidos(), t.getApellidos());
				assertEquals(cmp.getSueldo(), t.getSueldo());
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
