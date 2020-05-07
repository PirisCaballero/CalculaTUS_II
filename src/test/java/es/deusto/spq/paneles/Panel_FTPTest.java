package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class Panel_FTPTest {
	
	static Connect c;
	static Users u;
	static Panel_FTP pftp;
	
	@Before
	public void setUp() {
		c = new Connect();
		u = c.Recuperar_usuario("admin@root.es");
	}
	
	@Test
	public void testPanel_FTP() {
		pftp = new Panel_FTP(u);
		assertFalse(pftp.equals(null));
	}
	
}
