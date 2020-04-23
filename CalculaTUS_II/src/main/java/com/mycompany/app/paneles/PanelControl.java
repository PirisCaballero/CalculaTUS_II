package com.mycompany.app.paneles;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mycompany.app.Users;
import com.mycompany.app.connection.Connect;

public class PanelControl extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel lblSeleccionar;private JLabel lblTitulo;
	private JButton btnRefresh;
	private Choice choiceUsuario;
	private Users user;
	private Panel_Datos dts;
	
	public PanelControl(Users u, Panel_Datos pdts) {
		this.setBounds(0 , 0 , 574 , 470);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setVisible(true);
		this.user = u;
		this.dts = pdts;
		
		lblTitulo = new JLabel("Gestión de cuentas");
		lblTitulo.setBounds(50, 11, 433, 56);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		Font auxFont = lblTitulo.getFont();
		lblTitulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		add(lblTitulo);
		
		btnRefresh = new JButton("Mostrar datos");
		btnRefresh.setBounds(this.getWidth()/2-105, 150, 150, 50);
		btnRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		add(btnRefresh);
				
		lblSeleccionar = new JLabel();
		lblSeleccionar.setText("Escoge una cuenta:");
		lblSeleccionar.setBounds(29, 100, 140, 30);
		this.add(lblSeleccionar);
		
		choiceUsuario = new Choice();
		Connect cn = new Connect();
		ArrayList<Users> ul = cn.getUsers_byAdmin(user);
		for(Users us : ul) {
			choiceUsuario.add(us.getEmail());
		}
		choiceUsuario.setBounds(180, 100, 170, 30);
		this.add(choiceUsuario);
		
	}
	
}
