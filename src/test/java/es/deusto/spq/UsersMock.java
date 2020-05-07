package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import es.deusto.spq.Users.Type;

public class UsersMock {

	@Mock
	Users u;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void testToString() {
		when(u.toString()).thenReturn(
				"Users [nombre=Pedro, apellidos=Ben, email=pb@gmail.com, pass=pb, admin=1, adminemail=null");
		assertEquals(u.toString(),
				"Users [nombre=Pedro, apellidos=Ben, email=pb@gmail.com, pass=pb, admin=1, adminemail=null");
	}

	@Test
	public void testGetNombre() {
		when(u.getNombre()).thenReturn("Mikel");
		assertEquals(u.getNombre(), "Mikel");
	}

	@Test
	public void testGetApellidos() {
		when(u.getApellidos()).thenReturn("Lopez");
		assertEquals(u.getApellidos(), "Lopez");
	}

	@Test
	public void testGetDireccion() {
		when(u.getNombre()).thenReturn("Avenida Amaia");
		assertEquals(u.getNombre(), "Avenida Amaia");
	}

	@Test
	public void testGetEmail() {
		when(u.getEmail()).thenReturn("eneko.perez@opendeusto.es");
		assertEquals(u.getEmail(), "eneko.perez@opendeusto.es");
	}

	@Test
	public void testGetPass() {
		when(u.getPass()).thenReturn("pb");
		assertEquals(u.getPass(), "pb");
	}

	@Test
	public void testGetType() {
		when(u.getType()).thenReturn(Type.Admin);
		assertEquals(u.getType(), Type.Admin);
	}

	@Test
	public void testGetAdmin() {
		when(u.getAdmin()).thenReturn(1);
		assertEquals(u.getAdmin(), 1);
	}

	@Test
	public void testGetAdminEmail() {
		when(u.getAdminEmail()).thenReturn("eneko.perez@opendeusto.es");
		assertEquals(u.getAdminEmail(), "eneko.perez@opendeusto.es");
	}

}
