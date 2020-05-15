package es.deusto.spq.paneles;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Local;
import es.deusto.spq.Producto;
import es.deusto.spq.Ticket;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;

public class PanelEstadisticas extends JPanel {

	private static final long serialVersionUID = 1L;
	Users u;
	private PanelDatos pd;
	private DefaultTableModel modelo;
	private ArrayList<Local> arrayLocal;
	private ArrayList<Producto> arrayProducto;
	private String localSel="";
	private JTable tablaProductos;
	
	Connect cn;
	
	Choice chTienda;
	Choice chTipoProducto;

	Object[][] data = {};
	String columnas []= {"Usuario", "Tienda", "Tipo", "Porcentaje"};
	
	JButton btnBuscar, btnRefrescar;
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
		for(String s: cn.getCategorias()) {
			chTipoProducto.add(s);
		}
		add(chTipoProducto);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(140, 280, 80, 30);
		add(btnBuscar);
		
		btnRefrescar = new JButton("Refresh");
		btnRefrescar.setBounds(260, 280, 80, 30);
		add(btnRefrescar);
		
		btnRefrescar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}
	
	public void refresh() {
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
	}
	public void buscar() {
		double porcentajeAlimentación = 0.0;
		double porcentajeSalHig = 0.0;
		double porcentajeOcio = 0.0;
		double porcentajeTecnologia = 0.0;
		double porcentajeFacturas = 0.0;
		double porcentajeRopa = 0.0;
		ArrayList<Producto> pr = new ArrayList<Producto>();
		ArrayList<Ticket> arrayTicket = new ArrayList<Ticket>();
		arrayTicket = cn.getTicketsByUser(u);
		for(int i = 0; i < arrayTicket.size();i++) {
			int t = arrayTicket.get(i).getID_Lugar_Compra();
			pr = cn.getProductsByTicket(u, t);
			if(pr.get(i).getCategoria()=="Alimentacion") porcentajeAlimentación+=1;
			else if(pr.get(i).getCategoria()=="Salud/Higiene") porcentajeSalHig+=1;
			else if(pr.get(i).getCategoria()=="Ocio") porcentajeOcio+=1;
			else if(pr.get(i).getCategoria()=="Tecnologia") porcentajeTecnologia+=1;
			else if(pr.get(i).getCategoria()=="Facturas") porcentajeFacturas+=1;
			else if(pr.get(i).getCategoria()=="Ropa") porcentajeRopa+=1;
			else {
				JOptionPane.showConfirmDialog(null, "No hay tickets");
			}
			pr.get(i).getCategoria();
		}
		double total = porcentajeAlimentación+porcentajeFacturas+porcentajeOcio+ porcentajeRopa+porcentajeSalHig+porcentajeTecnologia;
		porcentajeAlimentación = porcentajeAlimentación/total*100;
		porcentajeSalHig = porcentajeSalHig/total*100;
		porcentajeOcio = porcentajeOcio/total*100;
		porcentajeTecnologia = porcentajeTecnologia/total*100;
		porcentajeFacturas = porcentajeFacturas/total*100;
		porcentajeRopa = porcentajeRopa/total*100;
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnas);
		tablaProductos = new JTable(dtm);
		tablaProductos.setBounds(20, 240, 500, 180);
		tablaProductos.setSize(490, 100);
		tablaProductos.setPreferredScrollableViewportSize(new Dimension(490, 100));
		for(int i =0; i < total;i++) {
			data[i][0] = arrayTicket.get(i).getNombreUsuario();
			data[i][1] = arrayTicket.get(i).getID_Lugar_Compra();
			data[i][2] = pr.get(i).getCategoria();
			if(pr.get(i).getCategoria()=="Alimentacion") data[i][3] = porcentajeAlimentación;
			else if(pr.get(i).getCategoria()=="Salud/Higiene") data[i][3] = porcentajeSalHig;
			else if(pr.get(i).getCategoria()=="Ocio") data[i][3] = porcentajeOcio;
			else if(pr.get(i).getCategoria()=="Tecnologia") data[i][3] = porcentajeTecnologia;
			else if(pr.get(i).getCategoria()=="Facturas") data[i][3] = porcentajeFacturas;
			else if(pr.get(i).getCategoria()=="Ropa") data[i][3] = porcentajeRopa;
			
		}
		JScrollPane scrollPane = new JScrollPane(tablaProductos);
		this.add(scrollPane, BorderLayout.CENTER);
		pd.setData(dtm);
	}
}
