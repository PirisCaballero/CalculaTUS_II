package es.deusto.spq;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.Users;
import es.deusto.spq.Users.Type;

public class UsersTest {

	@Test
	public void test() {// comprobacion de los getters y seter de la clase usuario
		Users usuario = new Users("erik", "martinez", "erik@gmail.com", "erik", 1, "null");
		usuario.setAdmin(1);
		Users u2 = new Users();
		u2.setType(Type.trabajador);
		assertTrue(u2.getType().equals(Type.trabajador));
		u2.setDireccion("GRAN VIA");
		assertTrue(u2.getDireccion().equals("GRAN VIA"));
		usuario.setType(Type.Admin);
		assertTrue(usuario.getType().equals(Type.Admin));
		
		Boolean resultado;
		assertEquals(1, usuario.getAdmin());
		String b = usuario.getAdminEmail();
		resultado = b.equals("null");
		assertTrue(resultado);
		String c = usuario.getApellidos();
		resultado = c.equals("martinez");
		assertTrue(resultado);
		String d = usuario.getPass();
		resultado = d.equals("erik");
		assertTrue(resultado);
		String e = usuario.getNombre();
		resultado = e.equals("erik");
		assertTrue(resultado);
		// ---------setters-------
		usuario.setAdmin(0);
		usuario.setAdminEmail("erik@gmail.com");
		usuario.setApellidos("martinez");
		usuario.setEmail("nada");
		usuario.setPass("pass");
		usuario.setNombre("nadie");
		assertEquals(0, usuario.getAdmin());
		String b2 = usuario.getAdminEmail();
		resultado = b2.equals("erik@gmail.com");
		assertTrue(resultado);
		String c2 = usuario.getApellidos();
		resultado = c2.equals("martinez");
		assertTrue(resultado);
		String d2 = usuario.getPass();
		resultado = d2.equals("pass");
		assertTrue(resultado);
		String e2 = usuario.getNombre();
		resultado = e2.equals("nadie");
		assertTrue(resultado);
		String f = usuario.getEmail();
		resultado = f.equals("nada");
		assertTrue(resultado);

		assertTrue(usuario.toString().equals("Users [nombre=nadie, apellidos=martinez, email=nada, pass=pass, admin=0, adminemail=erik@gmail.com"));

	}

}
