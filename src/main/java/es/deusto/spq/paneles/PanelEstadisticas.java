package es.deusto.spq.paneles;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class PanelEstadisticas extends JPanel {

	private static final long serialVersionUID = 1L;
	Users u;
	private PanelDatos pd;
	private DefaultTableModel modelo;
	private ArrayList<Local> arrayLocal;
	private ArrayList<Producto> arrayProducto;
	
	Connect cn;
	
	Choice chTienda;
	Choice chTipoProducto;
	
	JButton btnBuscar;
	JLabel lblTienda, lblTipoProducto;
	
	public PanelEstadisticas(Users us, PanelDatos pdts) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 574, 470);
		this.setVisible(true);
		this.u = us;
		this.pd = pdts;
		
		JLabel lblTitulo = new JLabel("Estadisticas");
		lblTitulo.setBounds(50, 11, 433, 56);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		Font auxFont = lblTitulo.getFont();
		lblTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		add(lblTitulo);
		
		lblTienda = new JLabel("Introduce la tienda por la que quieres filtrar:");
		lblTienda.setBounds(10, 130, 250, 30);
		add(lblTienda);
		
		lblTipoProducto = new JLabel("Introduce el tipo de producto a filtrar:");
		lblTipoProducto.setBounds(10, 170, 250, 30);
		add(lblTipoProducto);
		
		cn = new Connect();
		
		chTienda = new Choice();
		chTienda.setBounds(270, 130, 200, 20);
		arrayLocal = cn.getLocales(u);
		for(Local t: arrayLocal) {
			chTienda.add(t.getNombre());
		}
		add(chTienda);
		
		chTipoProducto = new Choice();
		chTipoProducto.setBounds(270, 170, 200, 20);
//		for(Local i:arrayLocal) {
//			arrayProducto=(cn.getProductsByLocal(u, i.getId()));
//		}
//		for(Producto pr: arrayProducto) {
//			chTipoProducto.add(pr.getNombre());
//		}
		add(chTipoProducto);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(200, 280, 80, 30);
		add(btnBuscar);
	}
}
