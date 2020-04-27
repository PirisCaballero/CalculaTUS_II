package es.deusto.spq.connection;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPFile;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.Users;

public class ConnectFTPTest {
	private String str1 , str2;
	private Users us , usF;
	private ConnectFTP ftp;
	@Before
	public void initialize() {
		str1 = "áéíóú";
		str2 = "aeiou";
		us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		ftp = new ConnectFTP(us);
	}

	@Test
	public void teststripAccents() {
		assertEquals(str2, ConnectFTP.stripAccents(str1));
		assertEquals(null, ConnectFTP.stripAccents(""));
		assertEquals(null, ConnectFTP.stripAccents(null));
	}
	@Test
	public void testOpenConexion() {
		us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		ftp = new ConnectFTP(us);
		assertTrue(ftp.OpenConexion());
		
		usF = new Users("Admin", "Root", "admin@root.com", "root", 1, "null");
		ftp = new ConnectFTP(usF);
		assertFalse(ftp.OpenConexion());
		
		usF = null;
		ftp = new ConnectFTP(usF);
		assertFalse(ftp.OpenConexion());
	}
	@Test
	public void testcloseConnection() {
		us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		ftp = new ConnectFTP(us);
		assertTrue(ftp.closeConnection());
		
		usF = new Users("Admin", "Root", "admin@root.com", "root", 1, "null");
		ftp = new ConnectFTP(usF);
		assertFalse(ftp.closeConnection());
		
		usF = null;
		ftp = new ConnectFTP(usF);
		assertFalse(ftp.closeConnection());
	}
	@Test
	public void testregisUserFolder() {
		Double r = Math.random();
		String nom = "pruebaAdmin"+r;
		us = new Users("Admin", "Root", nom+"@root.es", "root", 1, "null");
		Connect c = new Connect();
		c.RegisUser(us);
		ftp = new ConnectFTP(us);
		assertTrue(ftp.regisUserFolder());
		
		us = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		ftp = new ConnectFTP(us);
		assertFalse(ftp.regisUserFolder());
		
		usF = new Users("Admin", "Root", "admin@root.com", "root", 1, "null");
		ftp = new ConnectFTP(usF);
		assertFalse(ftp.regisUserFolder());
		
		usF = null;
		ftp = new ConnectFTP(usF);
		assertFalse(ftp.regisUserFolder());
	}
	@Test
	public void testuploadFile() {
		File f = new File("src/main/java/es/deusto/spq/resources/icons/casa.jpg");
		assertTrue(ftp.uploadFile(f, "\\"+us.getEmail()+"\\"));
		assertFalse(ftp.uploadFile(null, ""));
		File f2 = new File("src/main/java/es/deusto/spq/resources/icons/NOEXISTE.jpg"); //Path que no existe
		assertFalse(ftp.uploadFile(f2, "\\"+us.getEmail()+"\\"));
		String path2 = "\\"+us.getEmail()+"blabla\\";//Path en el servidor que NO existe
		assertFalse(ftp.uploadFile(f2, path2));
	}
	@Test
	public void testdownloadFile() {
		String path = "src/main/java/es/deusto/spq/resources/pruebasTest";//path bueno
		String path2 = "src/java/es/deusto/spq/resources/pruebas";//path malo
		assertTrue(ftp.downloadFile(path));
		assertFalse(ftp.downloadFile(path2));
		assertFalse(ftp.downloadFile(""));
	}
	@Test
	public void testgetUserFolders() {
		ArrayList<FTPFile> fol = new ArrayList<FTPFile>();
		String path = "\\"+us.getEmail()+"\\";//path que existe
		assertEquals(fol.getClass(), ftp.getUserFolders(path).getClass());
		assertEquals(null, ftp.getUserFolders(null));
	}
	@Test
	public void testgetUserFiles() {
		ArrayList<FTPFile> fol = new ArrayList<FTPFile>();
		String path = "\\"+us.getEmail()+"\\";//path que existe
		assertEquals(fol.getClass(), ftp.getUserFiles(path).getClass());
		assertEquals(null, ftp.getUserFiles(null));
	}
	@Test
	public void testcreateDir() {
		Double r = Math.random();
		String nom = "\\carpet"+r;
		String path = "\\"+us.getEmail()+nom+"\\";
		assertEquals(true , ftp.createDir(path));
		assertEquals(false, ftp.createDir(null));/**/
	}
}
