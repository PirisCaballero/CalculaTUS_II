package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.*;

import es.deusto.spq.Users;

public class Panel_FTPTest {

	static Users u;
	static Panel_FTP pftp;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Ben", "Bon", "benbon@gmail.com", "eo", 0, "admin@root.es");
	}
	
	@Test
	public void testPanel_FTP() {
		pftp = new Panel_FTP(u);
		assertFalse(pftp.equals(null));
	}
	
}
