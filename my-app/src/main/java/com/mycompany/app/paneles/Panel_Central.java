package com.mycompany.app.paneles;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.app.Users;

public class Panel_Central extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private Panel_Local pl; private Panel_Bienvenida pb;
	private Panel_producto pp; private PanelAdmin pa;
	private final String nombres_col[] = {"Columna 1" , "Columna 2" , "Columna 3"};
	private final String Data[][] = {
			{ "" , "" , "" }
			
	};
	private final DefaultTableModel DefaultModel = new DefaultTableModel( Data , nombres_col );
	private Panel_Datos pDat;
	public Panel_Central(Users user , Panel_Datos pd) {
		this.main_user = user;
		this.setBounds( 500 , 50 , 574 , 470);
		this.setBackground(Color.blue);
		this.setVisible(true);
		this.setLayout(null);
		this.pDat = pd;
		
		pl = new Panel_Local();
		pp = new Panel_producto(main_user , pd);
		pb = new Panel_Bienvenida(main_user);
		pa = new PanelAdmin(main_user , pd);
		this.add(this.pDat);
		pb.setVisible(true);
	}
	
	public void setPanel(int panel) {
		switch (panel) {
		case 0:
			System.out.println("Panel Local");
			add(pl);
			pl.setVisible(true);
			try {
				this.pDat.setData(DefaultModel);
				pp.setVisible(false); pb.setVisible(false);pa.setVisible(false);
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			this.repaint();
			break;
		case 1:
			this.pDat.setData(DefaultModel);
			System.out.println("Admin");
			this.add(pa);
			pa.setVisible(true);
			try {
				pp.setVisible(false); pb.setVisible(false);pl.setVisible(false);
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
				pl.setVisible(false);pb.setVisible(false);pa.setVisible(false);
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			add(pp);
			this.repaint();
			break;
		default:
			break;
		}
	}
	public Panel_producto getPanelProd() {
		return this.pp;
	}

}
