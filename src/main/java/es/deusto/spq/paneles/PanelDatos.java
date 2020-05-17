package es.deusto.spq.paneles;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel que se encuentra a la izquierda en la VentanaCalculaTUSII, tiene
 * la capacidad de mostrar informacion en un tabla de tres columnas dependiendo
 * de lo que se le pida a traves de botones de otros paneles.
 */

public class PanelDatos extends JPanel{

	/**
	 * Betha1.1
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;private JTable tabla;
	/**
	 * Este panel contiene una tabla en la que se muestran datos de los diferentes metodos de los paneles dentro del contenedor
	 */
	public PanelDatos() {
		this.setBounds( 0 , 50 , 500 , 470 );
		this.setVisible(true);
		//this.setBorder(BorderFactory.createLineBorder(Color.green));
		//this.setBackground(Color.green);
		
		///Contenido
		String nombres_col[] = {"Columna 1" , "Columna 2" , "Columna 3"};
		String Data[][] = {
				{ "" , "" , "" }
				
		};
		modelo = new DefaultTableModel(Data, nombres_col);
		tabla = new JTable(modelo);
		tabla.setSize(380 , 470);
		tabla.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds( 0 , 0 , 400 , 470 );
		
		add(scrollPane);
	}
	/**
	 * Este metodo establece el modelo de datos que se va a introducir en la tabla
	 * @param mod
	 */
	public void setData(DefaultTableModel mod) {
		this.modelo = mod;
		tabla.setModel(modelo);
		tabla.repaint();
	}
}
