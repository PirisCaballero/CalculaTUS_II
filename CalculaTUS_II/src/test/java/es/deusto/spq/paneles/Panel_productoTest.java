package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import javax.swing.JTable;

import org.junit.*;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class Panel_productoTest {

	static Panel_producto ppr;
	static Users u;
	static Panel_Datos pd;
	static JTable tabla_productos;
	static Local local;
	static Connect c;
	static Producto prod;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		pd = new Panel_Datos();
		Object[][] datos = {};
		String[] column_names = { "Nombre" , "Precio" , "Local" };
		tabla_productos = new JTable( datos , column_names );
		local = new Local("Eroski", "Alguna", 232, "");
		local.setId(0);
		ArrayList<Local> locListTable = new ArrayList<Local>();
		locListTable.add(local);
		prod = new Producto("pan", 2.0, 1);
		ArrayList<Producto> prodList = new ArrayList<Producto>();
		prodList.add(prod);
		c = new Connect();
		ArrayList<Producto> prList = c.getProducts_byLocal(u, local.getId()); 
		prList.add(prod);
	}
	
	@Test
	public void testPanel_producto() {
		ppr = new Panel_producto(u, pd);
		assertFalse(pd.equals(null));
	}
	
	@Test
	public void testDataToTable() {
		ppr.dataToTable(local.getId(), tabla_productos);
	}
}
