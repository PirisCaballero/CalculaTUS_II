package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

import static org.mockito.Mockito.*;

public class PanelFTPTest {
	
	static Connect c;
	static Users u;
	static PanelFTP pftp;
	
	PanelFTP pftp2 = mock(PanelFTP.class);
	
	@Before
	public void setUp() {
		c = new Connect();
		u = c.RecuperarUsuario("admin@root.es");
	}
	
	@Test(expected = NullPointerException.class) // ¡¡¡¡¡¡¡¡¡¡¡¡¡
	public void testPanel_FTP() {
		pftp = new PanelFTP(u);
		assertFalse(pftp.equals(null));
	}
	
	@Test
	public void testDownload() {
		when(pftp2.Download()).thenReturn(true);
		assertTrue(pftp2.Download());
	}
	
	@Test
	public void testUpload() {
		when(pftp2.Upload()).thenReturn(true);
		assertTrue(pftp2.Upload());
	}
	
	@Test
	public void testAddFolder() {
		when(pftp2.AddFolder()).thenReturn(true);
		assertTrue(pftp2.AddFolder());
	}
	
	@Test
	public void testAddFolderFunc() {
		when(pftp2.addFolderFunc(null)).thenReturn(true);
		assertTrue(pftp2.addFolderFunc(null));
	}
	
	
	
}
