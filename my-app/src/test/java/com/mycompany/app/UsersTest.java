package com.mycompany.app;

 
import static org.junit.Assert.*;

import org.junit.Test;

import com.mycompany.app.Users;

public class UsersTest {

	@Test
	public void test() {//comprobacion de los getters y seter de la  clase usuario
		Users usuario=new Users("erik", "martinez", "erik@gmail.com", "erik",1, "null");
		Boolean resultado;
		int a=usuario.getAdmin();
		resultado=(a==1);
		assertTrue(resultado);	
		String b=usuario.getAdminEmail();
		resultado=b.equals("null");
		assertTrue(resultado);
		String c =usuario.getApellidos();
		resultado=c.equals("martinez");
		assertTrue(resultado);
		String d=usuario.getPass();
		resultado=d.equals("erik");
		assertTrue(resultado);
		String e=usuario.getNombre();
		resultado= e.equals("erik");
		assertTrue(resultado);
		//---------setters-------
		usuario.setAdmin(0);
		usuario.setAdminEmail("erik@gmail.com");
		usuario.setApellidos("martinez");
		usuario.setEmail("nada");
		usuario.setPass("pass");
		usuario.setNombre("nadie");
		int a2=usuario.getAdmin();
		resultado=(a2==0);
		assertTrue(resultado);
		String b2=usuario.getAdminEmail();
		resultado=b2.equals("erik@gmail.com");
		assertTrue(resultado);
		String c2 =usuario.getApellidos();
		resultado=c2.equals("martinez");
		assertTrue(resultado);
		String d2=usuario.getPass();
		resultado=d2.equals("pass");
		assertTrue(resultado);
		String e2=usuario.getNombre();
		resultado= e2.equals("nadie");
		assertTrue(resultado);
		String f=usuario.getEmail();
		resultado=f.equals("nada");
		assertTrue(resultado);
		
		
		
	}

}
