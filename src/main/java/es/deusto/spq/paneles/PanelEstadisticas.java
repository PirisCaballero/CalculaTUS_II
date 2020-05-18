package es.deusto.spq.paneles;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

/**
 * Muestra las diferentes estadisticas que se quieren buscar dependiendo
 * de un local o un producto. Se accede a traves del PanelUser y el boton 
 * "Ver estadisticas".
 */

public class PanelEstadisticas extends JPanel {

	private static final long serialVersionUID = 1L;
	Users u;
	private PanelDatos pd;
	private DefaultTableModel modelo;
	private int row = 0, col = 0;
	private ArrayList<Local> arrayLocal;
	private ArrayList<Producto> prMios;
	private String localSel="";
	Local l;
	
	double contadorAlimentacion = 0.0;
	double contadorSalud = 0.0;
	double contadorOcio = 0.0;
	double contadorTecnologia = 0.0;
	double contadorFacturas = 0.0;
	double contadorRopa = 0.0;
	double totalAlimentacion = 0.0;
	double totalSalud = 0.0;
	double totalOcio = 0.0;
	double totalTecnologia = 0.0;
	double totalFacturas = 0.0;
	double totalRopa = 0.0;
	
	JProgressBar pgbAlimentacion, pgbSalud, pgbOcio, pgbTecnologia, pgbFacturas, pgbRopa;
	
	JLabel lblAlimentacion, lblSalud, lblOcio, lblTecnologia, lblFacturas, lblRopa;
	
	Connect cn;
	
	Choice chTienda;
	Choice chTipoProducto;

	String data [][] = {{"", "", ""}};
	String columnas []= {"Tienda", "Producto", "Tipo"};
	
	JButton btnBuscar, btnRefrescar;
	JLabel lblTienda, lblTipoProducto;
	
	
	/**
	 * Construye el panel en el que se mostraran las estadisticas del usuario registrado
	 * @param us
	 * @param pdts
	 */
	public PanelEstadisticas(Users us, PanelDatos pdts) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 574, 470);
		this.setVisible(true);
		this.u = us;
		this.pd = pdts;
		
		modelo = new DefaultTableModel(data, columnas);
		
		JLabel lblTitulo = new JLabel("Estadisticas");
		lblTitulo.setBounds(50, 11, 433, 56);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		Font auxFont = lblTitulo.getFont();
		lblTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		add(lblTitulo);
		
		lblTienda = new JLabel("Introduce la tienda por la que quieres filtrar:");
		lblTienda.setBounds(10, 100, 250, 30);
		add(lblTienda);
		
		lblTipoProducto = new JLabel("Introduce el tipo de producto a filtrar:");
		lblTipoProducto.setBounds(10, 150, 250, 30);
		add(lblTipoProducto);
		
		
		cn = new Connect();
		
		chTienda = new Choice();
		chTienda.setBounds(270, 100, 200, 20);
		arrayLocal = cn.getLocales(u);
		for(Local t: arrayLocal) {
			chTienda.add(t.getNombre());
		}
		add(chTienda);
		
		chTipoProducto = new Choice();
		chTipoProducto.setBounds(270, 150, 200, 20);
		for(String s: cn.getCategorias()) {
			chTipoProducto.add(s);
		}
		add(chTipoProducto);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(140, 190, 80, 30);
		add(btnBuscar);
		
		btnRefrescar = new JButton("Refresh");
		btnRefrescar.setBounds(260, 190, 80, 30);
		add(btnRefrescar);
		
		lblAlimentacion = new JLabel("Alimentación");
		lblAlimentacion.setBounds(60, 240, 150, 20);
		add(lblAlimentacion);
		
		pgbAlimentacion = new JProgressBar();
		pgbAlimentacion.setBounds(240, 240, 200, 20);
		pgbAlimentacion.setStringPainted(true);
		add(pgbAlimentacion);
		
		lblFacturas = new JLabel("Facturas");
		lblFacturas.setBounds(60, 270, 150, 20);
		add(lblFacturas);
		
		pgbFacturas = new JProgressBar();
		pgbFacturas.setBounds(240, 270, 200, 20);
		pgbFacturas.setStringPainted(true);
		add(pgbFacturas);
		
		lblOcio = new JLabel("Ocio");
		lblOcio.setBounds(60, 300, 150, 20);
		add(lblOcio);
		
		pgbOcio = new JProgressBar();
		pgbOcio.setBounds(240, 300, 200, 20);
		pgbOcio.setStringPainted(true);
		add(pgbOcio);
		
		lblRopa = new JLabel("Ropa");
		lblRopa.setBounds(60, 330, 150, 20);
		add(lblRopa);
		
		pgbRopa = new JProgressBar();
		pgbRopa.setBounds(240, 330, 200, 20);
		pgbRopa.setStringPainted(true);
		add(pgbRopa);
		
		lblSalud = new JLabel("Salud");
		lblSalud.setBounds(60, 360, 150, 20);
		add(lblSalud);
		
		pgbSalud = new JProgressBar();
		pgbSalud.setBounds(240, 360, 200, 20);
		pgbSalud.setStringPainted(true);
		add(pgbSalud);
		
		lblTecnologia = new JLabel("Tecnología");
		lblTecnologia.setBounds(60, 390, 150, 20);
		add(lblTecnologia);
		
		pgbTecnologia = new JProgressBar();
		pgbTecnologia.setBounds(240, 390, 200, 20);
		pgbTecnologia.setStringPainted(true);
		add(pgbTecnologia);
		
		btnRefrescar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buscar();
				
			}
		});
	}
	
	/**
	 * Este metodo refresca los choices y las estadísticas
	 */
	public void refresh() {
		contadorAlimentacion = 0;
		contadorFacturas = 0;
		contadorOcio = 0;
		contadorRopa = 0;
		contadorSalud = 0;
		contadorTecnologia = 0;
		
		totalAlimentacion = 0;
		totalFacturas = 0;
		totalOcio = 0;
		totalRopa = 0;
		totalSalud = 0;
		totalTecnologia = 0;
		
		pgbAlimentacion.setValue((int)totalAlimentacion);
		pgbFacturas.setValue((int)totalFacturas);
		pgbOcio.setValue((int)totalOcio);
		pgbRopa.setValue((int)totalRopa);
		pgbSalud.setValue((int)totalSalud);
		pgbTecnologia.setValue((int)totalTecnologia);
		
		localSel = chTienda.getSelectedItem();
		chTienda.removeAll();
		Connect cn = new Connect();
		arrayLocal.clear();
		arrayLocal = cn.getLocales(u);
		for (Local l : arrayLocal) {
			chTienda.add(l.getNombre());
		}
		Local local = cn.getLocalByName(u, localSel);
		cn.getProductsByLocal(u, local.getId());
		
		for (int i = 0; i <= modelo.getRowCount(); i++) {
			modelo.removeRow(i);
		}
		pd.setData(modelo);
		
	}
	
	/**
	 * Este metodo actualiza los progressbar en funcion de las compras hechas de cada categoria
	 */
	public void buscar() {
		contadorAlimentacion = 0;
		contadorFacturas = 0;
		contadorOcio = 0;
		contadorRopa = 0;
		contadorSalud = 0;
		contadorTecnologia = 0;
		
		totalAlimentacion = 0;
		totalFacturas = 0;
		totalOcio = 0;
		totalRopa = 0;
		totalSalud = 0;
		totalTecnologia = 0;
		
	
		
		ArrayList<Producto> pr = cn.getProductsByLocal(u, cn.getLocalByName(u, chTienda.getSelectedItem()).getId());
		for (int i = 0; i < pr.size(); i++) {
			System.out.println(pr.get(i).getCategoria());
			if(pr.get(i).getCategoria().equals(chTipoProducto.getSelectedItem())) {
				modelo.setRowCount(modelo.getRowCount()+1);
				modelo.setValueAt(chTienda.getSelectedItem(), row, col);
				modelo.setValueAt(pr.get(i).getNombre(), row, col+1);
				modelo.setValueAt(pr.get(i).getCategoria(), row, col+2);
				row+=1;
				pd.setData(modelo);
				
			}
		}
		
		prMios = cn.getProductsByUser(u);
		
		for (int i = 0; i < prMios.size(); i++) {
			System.out.println(prMios.get(i).getCategoria());
			if(prMios.get(i).getCategoria().equals("Alimentacion"))
				contadorAlimentacion = contadorAlimentacion + 1;
			if(prMios.get(i).getCategoria().equals("Salud/Higiene")) contadorSalud = contadorSalud + 1;
			if(prMios.get(i).getCategoria().equals("Ocio")) contadorOcio = contadorOcio + 1 ;
			if(prMios.get(i).getCategoria().equals("Tecnologia")) contadorTecnologia = contadorTecnologia + 1 ;
			if(prMios.get(i).getCategoria().equals("Facturas")) contadorFacturas = contadorFacturas + 1 ;
			if(prMios.get(i).getCategoria().equals("Ropa")) contadorRopa = contadorRopa + 1 ;
			
		}
		
		totalAlimentacion = contadorAlimentacion/prMios.size()*100;
		totalFacturas = contadorFacturas/prMios.size()*100;
		totalOcio = contadorOcio/prMios.size()*100;
		totalRopa = contadorRopa/prMios.size()*100;
		totalSalud = contadorSalud/prMios.size()*100;
		totalTecnologia = contadorTecnologia/prMios.size()*100;
		
		pgbAlimentacion.setValue((int)totalAlimentacion);
		pgbFacturas.setValue((int)totalFacturas);
		pgbOcio.setValue((int)totalOcio);
		pgbRopa.setValue((int)totalRopa);
		pgbSalud.setValue((int)totalSalud);
		pgbTecnologia.setValue((int)totalTecnologia);
		
	}
}
