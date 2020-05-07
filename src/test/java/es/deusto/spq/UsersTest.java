package es.deusto.spq;

import static org.junit.Assert.*;

import org.junit.*;

import es.deusto.spq.Users;
import es.deusto.spq.Users.Type;

public class UsersTest {

	static Users u1, u2;
	
	@BeforeClass
	public static void initialize() {
		u1 = new Users("Pedro", "Ben", "pb@gmail.com", "pb", 1, "null");
		u2 = new Users();
		u1.setDireccion("Parque 3");
		u1.setType(Type.Admin);
	}
	
	@Test
	public void testSetNombre() {
		u2.setNombre("Anna");
		assertEquals("Anna", u2.getNombre());
	}
	
	@Test
	public void testSetApellidos() {
		u2.setApellidos("Petra");
		assertEquals("Petra", u2.getApellidos());
	}
	
	@Test
	public void testSetDireccion() {
		u2.setDireccion("Calle parque");
		assertEquals("Calle parque", u2.getDireccion());
	}
	
	@Test
	public void testSetEmail() {
		u2.setEmail("annap@gmail.com");
		assertEquals("annap@gmail.com", u2.getEmail());
	}
	
	@Test
	public void testSetPass() {
		u2.setPass("ap");
		assertEquals("ap", u2.getPass());
	}
	
	@Test
	public void testSetType() {
		u2.setType(Type.trabajador);
		assertEquals(Type.trabajador, u2.getType());
	}
	
	@Test
	public void testSetAdmin() {
		u2.setAdmin(0);
		assertEquals(0, u2.getAdmin());
	}
	
	@Test
	public void testSetAdminEmail() {
		u2.setAdminEmail("pb@gmail.com");
		assertEquals("pb@gmail.com", u2.getAdminEmail());
	}
	
	@Test
	public void testToString() {
		String expected = "Users [nombre=Pedro, apellidos=Ben, email=pb@gmail.com, pass=pb, admin=1, adminemail=null";
		assertEquals(expected, u1.toString());
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Pedro", u1.getNombre());
	}
	
	@Test
	public void testGetApellidos() {
		assertEquals("Ben", u1.getApellidos());
	}
	
	@Test
	public void testGetDireccion() {
		assertEquals("Parque 3", u1.getDireccion());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("pb@gmail.com", u1.getEmail());
	}
	
	@Test
	public void testGetPass() {
		assertEquals("pb", u1.getPass());
	}
	
	@Test
	public void testGetType() {
		assertEquals(Type.Admin, u1.getType());
	}
	
	@Test
	public void testGetAdmin() {
		assertEquals(1, u1.getAdmin());
	}
	
	@Test
	public void testGetAdminEmail() {
		assertEquals("null", u1.getAdminEmail());
	}

}
