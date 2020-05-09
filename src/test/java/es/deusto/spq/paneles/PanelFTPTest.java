package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class PanelFTPTest {
	
	static Connect c;
	static Users u;
	static PanelFTP pftp;
	
	@Before
	public void setUp() {
		c = new Connect();
		u = c.RecuperarUsuario("admin@root.es");
	}
	
	@Test
	public void testPanel_FTP() {
		pftp = new PanelFTP(u);
		assertFalse(pftp.equals(null));
	}
	
}
