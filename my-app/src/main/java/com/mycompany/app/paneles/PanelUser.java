package com.mycompany.app.paneles;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mycompany.app.Local;
import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;

public class PanelUser extends JPanel {

	JButton btnDescuento;
	int admin;
	Users user;

	private ArrayList<Local> userList = new ArrayList<Local>();
	private Panel_Datos pd;

	public PanelUser(Users u, Panel_Datos pdts) {
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 574, 470);
		this.setVisible(true);
		this.user = u;
		this.pd = pdts;

		btnDescuento = new JButton("Userrrrrrrrrrrrrrrrrrrrrrrrr");
		btnDescuento.setBounds(178, 35, 200, 23);
		add(btnDescuento);

		btnDescuento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Refreshing...");

			}
		});
	}
}
