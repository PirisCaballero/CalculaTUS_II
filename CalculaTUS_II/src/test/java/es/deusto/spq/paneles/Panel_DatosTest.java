package es.deusto.spq.paneles;

import static org.junit.Assert.assertFalse;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.*;

public class Panel_DatosTest {

	static DefaultTableModel modelo;
	
	@BeforeClass
	public static void initialize() {
		String nombres_col[] = {"Columna 1" , "Columna 2" , "Columna 3"};
		String Data[][] = {
				{ "" , "" , "" }
				
		};
		modelo = new DefaultTableModel(Data, nombres_col);
	}
	
	
	@Test
	public void testPanel_Datos() {
		
		Panel_Datos pd = new Panel_Datos();
		pd.setData(modelo);
		assertFalse(pd.equals(null));
	}
	
}
