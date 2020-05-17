package es.deusto.spq.paneles;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.ShowTickets;

/**
 * Panel donde se superposicionan los paneles que dan opcion a 
 * registrar local, añadir ticket, añadir producto, y los paneles
 * PanelAdmin, PanelUser y PanelFTP.
 */

public class PanelCentral extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private PanelLocal pl; private PanelControl pcont; private PanelBienvenida pb;
	private PanelFTP pftp;
	private PanelProducto pp; private PanelEstadisticas pe; private PanelAdmin pa;private PanelTicket pt; private PanelUser pu; private PanelPreguntas pg;
	private final String nombres_col[] = {"Columna 1" , "Columna 2" , "Columna 3"};
	private final String Data[][] = {
			{ "" , "" , "" }
			
	};
	private JScrollPane sc;
	private final DefaultTableModel DefaultModel = new DefaultTableModel( Data , nombres_col );
	private PanelDatos pDat;
	public PanelCentral(Users user , PanelDatos pd) {
		this.main_user = user;
		this.setBounds( 500 , 50 , 574 , 470);
		this.setBackground(Color.blue);
		this.setVisible(true);
		this.setLayout(null);
		this.pDat = pd;
		pl = new PanelLocal(main_user);
		pp = new PanelProducto(main_user , pd);
		pb = new PanelBienvenida(main_user);
		System.out.println("Iratxe " + main_user.getNombre());
		pa = new PanelAdmin(main_user , pd);
		pu = new PanelUser(main_user, pd); //no se si es pd ¿?¿?¿??¿¿?¿?¿?¿?¿?¿??¿¿?¿?
		pt = new PanelTicket(main_user, pDat);
		pftp = new PanelFTP(main_user);
		pg = new PanelPreguntas();
		pe = new PanelEstadisticas(main_user, pd);
		pcont = new PanelControl(main_user, pDat);
		sc = new JScrollPane(pg);
		pb.setVisible(true);
		this.add(pb);
		this.repaint();
	}
	
	public void setPanel(int panel) {
		switch (panel) {
		case 0:
			System.out.println("Panel Local");
			pl.setVisible(true);
			this.pDat.setData(DefaultModel);
			try {
				pe.setVisible(false);pa.setVisible(false);pcont.setVisible(false);pt.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);sc.setVisible(false);pb.setVisible(false);
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			this.add(pl);
			this.repaint();
			break;
		case 1:
			this.pDat.setData(DefaultModel);
			System.out.println("Admin");
			this.add(pa);
			pa.setVisible(true);
			try {
				pe.setVisible(false);pl.setVisible(false);pcont.setVisible(false);pt.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);sc.setVisible(false);pb.setVisible(false);
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			this.repaint();
			break;
		case 2:
			this.pDat.setData(DefaultModel);
			System.out.println("Panel Producto");
			pp.setVisible(true);
			try {
				pe.setVisible(false);pa.setVisible(false);pcont.setVisible(false);sc.setVisible(false);pl.setVisible(false);pt.setVisible(false);pu.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			add(pp);
			this.repaint();
			break;
		case 3:
			System.out.println("Prueba + " + panel);
			this.pDat.setData(DefaultModel);
			System.out.println("Añadir ticket");
			pt.setVisible(true);
			try {
				pe.setVisible(false);sc.setVisible(false);pcont.setVisible(false);pa.setVisible(false);pl.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}add(pt);
			this.repaint();
			break;
		case 4:
			System.out.println("Prueba + " + panel);
			this.pDat.setData(DefaultModel);
			System.out.println("Conexion FTP");
			add(pftp);
			pftp.setVisible(true);
			try {
				pe.setVisible(false);pa.setVisible(false);pcont.setVisible(false);sc.setVisible(false);pl.setVisible(false);pt.setVisible(false);pp.setVisible(false);pu.setVisible(false);pb.setVisible(false);
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			this.repaint();
			break;
		case 5:
			System.out.println("Preguntas");
			sc.setVisible(true);
			sc.setBounds(0, 0, pp.getWidth()-5, 470);
			this.add(sc);
			try {
				pe.setVisible(false);pa.setVisible(false);pcont.setVisible(false);pl.setVisible(false);pt.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			this.repaint();
			break;
		case 6:
			System.out.println("Panel Usuario");
			this.pDat.setData(DefaultModel);
			this.add(pu);
			pu.setVisible(true);
			try {
				pe.setVisible(false);pa.setVisible(false);pcont.setVisible(false);pl.setVisible(false);pt.setVisible(false);sc.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
			}catch (Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			break;
		case 7:
			System.out.println("Panel control Usuario");			
			add(pcont);
			pcont.setVisible(true);
			try {
				pe.setVisible(false);pa.setVisible(false);pu.setVisible(false);pl.setVisible(false);pt.setVisible(false);sc.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
			}catch (Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			this.repaint();
			break;
		case 8:
			this.pDat.setData(DefaultModel);
			add(pe);
			pe.setVisible(true);
			try {
				pcont.setVisible(false);pa.setVisible(false);pu.setVisible(false);pl.setVisible(false);pt.setVisible(false);sc.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
			}catch (Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			this.repaint();
			break;
		default:
			break;
		
		}
	}
	public PanelProducto getPanelProd() {
		return this.pp;
	}
	public ShowTickets getPanelTicket() {
		return PanelTicket.getFrameTickets();
	}

}
