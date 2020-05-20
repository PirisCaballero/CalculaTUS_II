package es.deusto.spq.Utils;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


public class UtilsTest {
	
	static Utils u;
	@Before
	public void initialize() {
		//TODO
		u = new Utils();
	}
	@Test
	public void TestPropertiesReader() {
		String exp = "Aitor Piris";
		assertEquals(exp, u.propertiesReader("Product_Owner"));
		assertEquals(null, u.propertiesReader("AtributoFalso"));
	}
	@Test
	public void TestgetServerData() {
		HashMap<String , String> arr = new HashMap<>();
		assertEquals(arr.getClass(), u.getServerData().getClass());
	}
}
