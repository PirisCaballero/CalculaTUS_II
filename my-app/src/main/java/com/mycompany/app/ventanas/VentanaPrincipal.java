package com.mycompany.app.ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	
	JLabel lblNombreUser, lblEneko, lblAitor, lblErik, lblIratxe, lblEstadistica;
	JButton btnLogout;
	JTextField txt;
	JTabbedPane tpTabbed;
	
	public VentanaPrincipal() {
		
		this.setSize(800,600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CalculaTUS II");
		
		
		//Creacion del panel para introducir el logo
		JPanel panelLogo = new JPanel();
		add(panelLogo);
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.CYAN);
		panelLogo.setBounds(10, 10, 220, 80);
		this.setVisible(true);
		panelLogo.setVisible(true);
		
		//Creacion del panel superior derecho con el boton de logout y nombre de usuario
		JPanel panelLogout = new JPanel();
		add(panelLogout);
		panelLogout.setLayout(null);
		panelLogout.setBounds(550, 10, 220, 80);
		this.setVisible(true);
		panelLogout.setVisible(true);
		
		
		//Inicializacion de tabbedpane
		tpTabbed = new JTabbedPane();
		tpTabbed.setVisible(true);
		tpTabbed.setLayout(null);
		
		//Creacion de paneles que contiene el tabbed pane
		JPanel panelTabbedUser = new JPanel();
		panelTabbedUser.setLayout(null);
		panelTabbedUser.setBackground(Color.CYAN);
		panelTabbedUser.setBounds(10, 100, 220, 360);
		this.setVisible(true);
		panelTabbedUser.setVisible(true);
		panelTabbedUser.add(tpTabbed);
		
		
		
		JPanel panelTabbedAdmin = new JPanel();
		panelTabbedAdmin.setLayout(null);
		panelTabbedAdmin.setBackground(Color.WHITE);
		panelTabbedAdmin.setBounds(10, 100, 220, 360);
		this.setVisible(true);
		panelTabbedAdmin.setVisible(true);
		tpTabbed.addTab("Admin", panelTabbedAdmin);
		
		
		JPanel panelTabbedFTP = new JPanel();
		panelTabbedFTP.setLayout(null);
		panelTabbedFTP.setBackground(Color.ORANGE);
		panelTabbedFTP.setBounds(10, 100, 220, 360);
		this.setVisible(true);
		panelTabbedFTP.setVisible(true);
		tpTabbed.addTab("FTP", panelTabbedFTP);
		
		
		
		//Creacion del panel con los nombres de los autores del codigo
		JPanel panelAutores = new JPanel();
		add(panelAutores);
		panelAutores.setLayout(null);
		panelAutores.setBackground(Color.WHITE);
		panelAutores.setBounds(10, 470, 220, 80);
		this.setVisible(true);
		panelAutores.setVisible(true);
		
		//Creacion del panel de posibles estadisticas
		JPanel panelEstadisticas = new JPanel();
		add(panelEstadisticas);
		panelEstadisticas.setLayout(null);
		panelEstadisticas.setBackground(Color.WHITE);
		panelEstadisticas.setBounds(240, 470, 400, 80);
		this.setVisible(true);
		panelEstadisticas.setVisible(true);
				
		//Creacion del panel de contenido
		JPanel panelContenido = new JPanel();
		add(panelContenido);
		panelContenido.setLayout(null);
		panelContenido.setBackground(Color.WHITE);
		panelContenido.setBounds(240, 100, 530, 360);
		this.setVisible(true);
		panelContenido.setVisible(true);
		
		
		lblNombreUser = new JLabel();
		lblNombreUser.setText("Usuario");
		lblNombreUser.setBounds(30, 15, 10, 10);
		lblNombreUser.setSize(50, 30);
		
		btnLogout = new JButton();
		btnLogout.setText("Log Out");
		btnLogout.setBounds(120, 10, 10, 10);
		btnLogout.setSize(80, 40);
		
		
		btnLogout.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cerrando sesion...");
				JOptionPane cerrar = new JOptionPane();
				int resp = cerrar.showConfirmDialog(null, "¿Seguro que quieres salir?", "Aviso", JOptionPane.YES_NO_OPTION);
				if(resp==0) {
					setVisible(false);
					VentanaLogin vtnLogin = new VentanaLogin();
					vtnLogin.setVisible(true);
				}
				
			}
		});
		
		lblAitor = new JLabel();
		lblAitor.setText("Aitor Piris");
		lblAitor.setBounds(10, 10, 10, 10);
		lblAitor.setSize(100, 15);
		
		lblEneko = new JLabel();
		lblEneko.setText("Eneko Perez");
		lblEneko.setBounds(10, 25, 10, 10);
		lblEneko.setSize(100, 15);
		
		lblErik = new JLabel();
		lblErik.setText("Erik Martinez");
		lblErik.setBounds(10, 40, 10, 10);
		lblErik.setSize(100, 15);
		
		lblIratxe = new JLabel();
		lblIratxe.setText("Iratxe Campo");
		lblIratxe.setBounds(10, 55, 10, 10);
		lblIratxe.setSize(100, 15);
		
		lblEstadistica = new JLabel();
		lblEstadistica.setText("Estadisticas");
		lblEstadistica.setSize(100, 15);
		
		
		add(tpTabbed);

		panelAutores.add(lblAitor);
		panelAutores.add(lblEneko);
		panelAutores.add(lblErik);
		panelAutores.add(lblIratxe);
		
		panelLogout.add(btnLogout);
		
		panelLogout.add(lblNombreUser);
		
		panelEstadisticas.add(lblEstadistica);
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal pr = new VentanaPrincipal();
		pr.setVisible(true);
	}
}
