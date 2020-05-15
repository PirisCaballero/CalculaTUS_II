package es.deusto.spq.paneles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.*;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class PanelProductoTest {

	static PanelProducto ppr;
	static Users u;
	static PanelDatos pd;
	static JTable tabla_productos;
	static Local local;
	static Connect c;
	static Producto prod;
	
	@BeforeClass
	public static void initialize() {
		u = new Users("Admin", "Root", "admin@root.es", "root", 1, "null");
		pd = new PanelDatos();
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
		ArrayList<Producto> prList = c.getProductsByLocal(u, local.getId()); 
		prList.add(prod);
	}
	
	@Test
	public void testPanelProducto() {
		ppr = new PanelProducto(u, pd);
		assertFalse(pd.equals(null));
	}
	
	@Test
	public void testDataToTable() {
		System.out.println(local.getId());
		System.out.println(tabla_productos.isEnabled());
		
		ppr = new PanelProducto(u, pd);
		assertEquals(DefaultTableModel.class, ppr.dataToTable(local.getId(), tabla_productos).getClass());
	}
}
