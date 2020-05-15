package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.misusing.UnnecessaryStubbingException;
import org.mockito.junit.MockitoJUnitRunner;
import es.deusto.spq.Local;
import es.deusto.spq.connection.Connect;

@RunWith(MockitoJUnitRunner.class)
public class LocalTest {
	static Local local;
	static Local l2;
	static Connect c = new Connect();
	
	@BeforeClass
	public static void initialize()  throws UnnecessaryStubbingException{
		local = c.getLocalById(c.RecuperarUsuario("admin@root.es"), 189);
		l2 = c.getLocalById(c.RecuperarUsuario("admin@root.es"), 190);
	}
	
	@Test
	public void testGetNombre()  throws UnnecessaryStubbingException{
		assertTrue(local.getNombre().equals("Deusto"));
	}
	
	@Test
	public void testGetDireccion()  throws UnnecessaryStubbingException{
		assertTrue(local.getDireccion().equals("C/ Lehendakari "));	
	}
	
	@Test
	public void testGetDescripcion()  throws UnnecessaryStubbingException{
		assertTrue(local.getDescripcion().equals("Prueba"));	
	}
	
	@Test
	public void testGetCp()  throws UnnecessaryStubbingException{
		assertEquals(48001, local.getCp());	
	}
	
	@Test
	public void testSetID()  throws UnnecessaryStubbingException{
		l2.setId(3);
		assertEquals(3, l2.getId());
	}
	
	@Test
	public void testToString()  throws UnnecessaryStubbingException{
		String expected = "Nombre: Deusto Direccion: C/ Lehendakari  codigo postal: 48001";
		String actual = local.toString();
		assertEquals(expected, actual);
	}
	
}
