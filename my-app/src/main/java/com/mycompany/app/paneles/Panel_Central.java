package com.mycompany.app.paneles;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.app.Users;
import com.mycompany.app.ventanas.Show_Tickets;

public class Panel_Central extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private Panel_Local pl; private Panel_Bienvenida pb;
	private Panel_FTP pftp;
	private Panel_producto pp; private PanelAdmin pa;private Panel_Ticket pt; private PanelUser pu; private PanelPreguntas pg;
	private final String nombres_col[] = {"Columna 1" , "Columna 2" , "Columna 3"};
	private final String Data[][] = {
			{ "" , "" , "" }
			
	};
	private JScrollPane sc;
	private final DefaultTableModel DefaultModel = new DefaultTableModel( Data , nombres_col );
	private Panel_Datos pDat;
	public Panel_Central(Users user , Panel_Datos pd) {
		this.main_user = user;
		this.setBounds( 500 , 50 , 574 , 470);
		this.setBackground(Color.blue);
		this.setVisible(true);
		this.setLayout(null);
		this.pDat = pd;
		pl = new Panel_Local(main_user);
		pp = new Panel_producto(main_user , pd);
		pb = new Panel_Bienvenida(main_user);
		pa = new PanelAdmin(main_user , pd);
		pu = new PanelUser(main_user, pd); //no se si es pd ¿?¿?¿??¿¿?¿?¿?¿?¿?¿??¿¿?¿?
		pt = new Panel_Ticket(main_user, pDat);
		pftp = new Panel_FTP(main_user);
		pg = new PanelPreguntas();
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
				pa.setVisible(false);pt.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);sc.setVisible(false);pb.setVisible(false);
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
				pl.setVisible(false);pt.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);sc.setVisible(false);pb.setVisible(false);
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
				pa.setVisible(false);sc.setVisible(false);pl.setVisible(false);pt.setVisible(false);pu.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
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
				sc.setVisible(false);pa.setVisible(false);pl.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
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
				pa.setVisible(false);sc.setVisible(false);pl.setVisible(false);pt.setVisible(false);pp.setVisible(false);pu.setVisible(false);pb.setVisible(false);
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
				pa.setVisible(false);pl.setVisible(false);pt.setVisible(false);pu.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
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
				pa.setVisible(false);pl.setVisible(false);pt.setVisible(false);sc.setVisible(false);pp.setVisible(false);pftp.setVisible(false);pb.setVisible(false);
			}catch (Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			break;
		default:
			break;
		
		}
	}
	public Panel_producto getPanelProd() {
		return this.pp;
	}
	public Show_Tickets getPanel_Ticket() {
		return this.pt.getFrameTickets();
	}

}
