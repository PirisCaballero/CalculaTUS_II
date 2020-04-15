package com.mycompany.app.paneles;

import java.awt.Color;

import javax.swing.*;

import com.mycompany.app.Users;

public class Panel_Central extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	private Users main_user;
	private Panel_Local pl; private Panel_Bienvenida pb;
	private Panel_producto pp;
	
	public Panel_Central(Users user , Panel_Datos pd) {
		this.main_user = user;
		this.setBounds( 500 , 50 , 574 , 470);
		this.setBackground(Color.blue);
		this.setVisible(true);
		this.setLayout(null);
		
		pl = new Panel_Local();
		pp = new Panel_producto(main_user , pd);
		pb = new Panel_Bienvenida(main_user);
		this.add(pb);
		pb.setVisible(true);
	}
	
	public void setPanel(int panel) {
		switch (panel) {
		case 0:
			System.out.println("Panel Local");
			add(pl);
			pl.setVisible(true);
			try {
				pp.setVisible(false); pb.setVisible(false);
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			this.repaint();
			break;
		case 2:
			System.out.println("Panel Producto");
			pp.setVisible(true);
			try {
				pl.setVisible(false);pb.setVisible(false);
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
