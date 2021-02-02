import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import datos.Barco;
import datos.Evento;
import datos.Marea;
import datos.TipoBarco;
import datos.TipoEvento;

public class TestExamen {

	Barco barco;
	GregorianCalendar cal;
	Evento evSalida;
	GregorianCalendar cal2;
	Evento evEntrada ;

	@Before
	public void setUp() throws Exception {
		barco = new Barco("Albacora", "test@test.com", "Alb", TipoBarco.PS, "Atlántico");
		cal = new GregorianCalendar(2020,10,15,10,30);	//15/11/2020
		evSalida = new Evento(barco.getCodigo(), cal, TipoEvento.EXITED);
		cal2 = new GregorianCalendar(2020,10,20,15,00); //20/11/2020
		evEntrada = new Evento(barco.getCodigo(), cal2, TipoEvento.ENTERED);
	}

	@Test
	public void testNombreMarea() { //InicialOceano_CodigoBarco_DDMMYYYSalida
		//T2a - No modificar el test
		Marea marea = new Marea(barco, evSalida, evEntrada);
		assertEquals("A_Alb_15102020Salida", marea.getNombre());
	}
	
	@Test
	public void testCalculoDias(){
		//T2b
		Marea marea = new Marea(barco, evSalida, evEntrada);
		assertEquals(5, marea.getDias());
	}
	
	@Test
	public void testFormatoFechaEvento(){
		//T2c
		fail("Not implemented yet!");
	}
	
	@Test
	public void testNombreEmailBarco(){
		//T2d
		fail("Not implemented yet!");
		
	}
}
