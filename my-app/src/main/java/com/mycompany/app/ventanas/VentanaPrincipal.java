package com.mycompany.app.ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	
	JLabel lblNombreUser, lblEneko, lblAitor, lblErik, lblIratxe, lblEstadistica;
	JButton btnLogout, btnLocal, btnHacerTicket, btnVerTickets, btnVerProductos, btnVerEstadistica;
	JTextField txt;
	JTabbedPane tpTabbed;
	JPanel panelLocal, panelCrearTicket, panelVerTickets, panelVerProductos, panelVerEstadisticas;
	
	public VentanaPrincipal() {
		
		this.setSize(800,600);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CalculaTUS II");
		
		
		//Creacion del panel para introducir el logo
		JPanel panelLogo = new JPanel();
		add(panelLogo);
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.CYAN);
		panelLogo.setBounds(10, 10, 220, 80);
		panelLogo.setVisible(true);
		
		//Creacion del panel superior derecho con el boton de logout y nombre de usuario
		JPanel panelLogout = new JPanel();
		add(panelLogout);
		panelLogout.setLayout(null);
		panelLogout.setBounds(550, 10, 220, 80);
		panelLogout.setVisible(true);
		
		
		//Inicializacion de tabbedpane
		tpTabbed = new JTabbedPane();
		tpTabbed.setBounds(10, 100, 220, 360);
		
		//Creacion de paneles que contiene el tabbed pane
		JPanel panelTabbedUser = new JPanel();
		panelTabbedUser.setBackground(Color.BLUE);	
		panelTabbedUser.setLayout(null);
		
		
		JPanel panelTabbedAdmin = new JPanel();
		panelTabbedAdmin.setBackground(Color.WHITE);
		
		
		JPanel panelTabbedFTP = new JPanel();
		panelTabbedFTP.setBackground(Color.ORANGE);
		
		tpTabbed.addTab("User", panelTabbedUser);
		tpTabbed.addTab("Admin", panelTabbedAdmin);
		tpTabbed.addTab("FTP", panelTabbedFTP);
		
		
		
		//Creacion del panel con los nombres de los autores del codigo
		JPanel panelAutores = new JPanel();
		add(panelAutores);
		panelAutores.setLayout(null);
		panelAutores.setBackground(Color.WHITE);
		panelAutores.setBounds(10, 470, 220, 80);
		panelAutores.setVisible(true);
		
		//Creacion del panel de posibles estadisticas
		JPanel panelEstadisticas = new JPanel();
		add(panelEstadisticas);
		panelEstadisticas.setLayout(null);
		panelEstadisticas.setBackground(Color.WHITE);
		panelEstadisticas.setBounds(240, 470, 400, 80);
		panelEstadisticas.setVisible(true);
		
		//Panel para el logo de Deusto
		JPanel panelDeusto = new JPanel();
		add(panelDeusto);
		panelDeusto.setLayout(null);
		panelDeusto.setBackground(Color.RED);
		panelDeusto.setBounds(650, 470, 120, 80);
		panelDeusto.setVisible(true);
		
		
		JLabel img = new JLabel();
		ImageIcon image = new ImageIcon("deusto-logo.png");
		img.setSize(100, 80);
		img.setVisible(true);
		img.setIcon(image);
		panelDeusto.add(img);
		
		
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
		
		
		//ZONA PARA LOS BOTONES DEL PANEL USUARIO
		btnLocal = new JButton();
		btnLocal.setText("Registrar local");
		btnLocal.setBounds(20, 30, 10, 10);
		btnLocal.setSize(tpTabbed.getWidth()-45, 30);
		
		btnHacerTicket = new JButton();
		btnHacerTicket.setText("Hacer ticket");
		btnHacerTicket.setBounds(20, 90, 10, 10);
		btnHacerTicket.setSize(tpTabbed.getWidth()-45, 30);
		
		btnVerTickets = new JButton();
		btnVerTickets.setText("Ver tickets");
		btnVerTickets.setBounds(20, 150, 10, 10);
		btnVerTickets.setSize(tpTabbed.getWidth()-45, 30);
		
		btnVerProductos = new JButton();
		btnVerProductos.setText("Ver productos");
		btnVerProductos.setBounds(20, 210, 10, 10);
		btnVerProductos.setSize(tpTabbed.getWidth()-45, 30);
		
		btnVerEstadistica = new JButton();
		btnVerEstadistica.setText("Ver estadistica");
		btnVerEstadistica.setBounds(20, 270, 10, 10);
		btnVerEstadistica.setSize(tpTabbed.getWidth()-45, 30);
		
		
		panelLocal = new JPanel();
		panelLocal.setLayout(null);
		panelLocal.setBackground(Color.PINK);
		panelLocal.setBounds(240, 100, 530, 360);
		
		panelCrearTicket = new JPanel();
		panelCrearTicket.setLayout(null);
		panelCrearTicket.setBackground(Color.BLACK);
		panelCrearTicket.setBounds(240, 100, 530, 360);
		
		panelVerTickets = new JPanel();
		panelVerTickets.setLayout(null);
		panelVerTickets.setBackground(Color.WHITE);
		panelVerTickets.setBounds(240, 100, 530, 360);
		
		panelVerProductos = new JPanel();
		panelVerProductos.setLayout(null);
		panelVerProductos.setBackground(Color.PINK);
		panelVerProductos.setBounds(240, 100, 530, 360);
		
		panelVerEstadisticas = new JPanel();
		panelVerEstadisticas.setLayout(null);
		panelVerEstadisticas.setBackground(Color.BLACK);
		panelVerEstadisticas.setBounds(240, 100, 530, 360);
		
		//FUNCION DE LOS BOTONES
		btnLocal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelLocal.setVisible(true);
				add(panelLocal);
				repaint();
				if(panelCrearTicket.isVisible()) {
					panelCrearTicket.setVisible(false);
				}
				else if(panelVerTickets.isVisible()) {
					panelVerTickets.setVisible(false);
				}
				else if(panelVerProductos.isVisible()) {
					panelVerProductos.setVisible(false);
				}
				else if(panelVerEstadisticas.isVisible()) {
					panelVerEstadisticas.setVisible(false);
				}
			}
		});
		
		btnHacerTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelCrearTicket.setVisible(true);
				add(panelCrearTicket);
				repaint();
				if(panelLocal.isVisible()) {
					panelLocal.setVisible(false);
				}
				else if(panelVerTickets.isVisible()) {
					panelVerTickets.setVisible(false);
				}
				else if(panelVerProductos.isVisible()) {
					panelVerProductos.setVisible(false);
				}
				else if(panelVerEstadisticas.isVisible()) {
					panelVerEstadisticas.setVisible(false);
				}
			}
		});
		
		btnVerTickets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelVerTickets.setVisible(true);
				add(panelVerTickets);
				repaint();
				if(panelLocal.isVisible()) {
					panelLocal.setVisible(false);
				}else if(panelCrearTicket.isVisible()) {
					panelCrearTicket.setVisible(false);
				}
				else if(panelVerProductos.isVisible()) {
					panelVerProductos.setVisible(false);
				}
				else if(panelVerEstadisticas.isVisible()) {
					panelVerEstadisticas.setVisible(false);
				}
			}
		});
		
		btnVerProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelVerProductos.setVisible(true);
				add(panelVerProductos);
				repaint();
				if(panelLocal.isVisible()) {
					panelLocal.setVisible(false);
				}else if(panelCrearTicket.isVisible()) {
					panelCrearTicket.setVisible(false);
				}
				else if(panelVerTickets.isVisible()) {
					panelVerTickets.setVisible(false);
				}
				else if(panelVerEstadisticas.isVisible()) {
					panelVerEstadisticas.setVisible(false);
				}
				
			}
		});
		
		btnVerEstadistica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelVerEstadisticas.setVisible(true);
				add(panelVerEstadisticas);
				repaint();
				if(panelLocal.isVisible()) {
					panelLocal.setVisible(false);
				}else if(panelCrearTicket.isVisible()) {
					panelCrearTicket.setVisible(false);
				}
				else if(panelVerTickets.isVisible()) {
					panelVerTickets.setVisible(false);
				}
				else if(panelVerProductos.isVisible()) {
					panelVerProductos.setVisible(false);
				}
				
				
			}
		});
		
		
		panelTabbedUser.add(btnLocal);
		panelTabbedUser.add(btnHacerTicket);
		panelTabbedUser.add(btnVerTickets);
		panelTabbedUser.add(btnVerProductos);
		panelTabbedUser.add(btnVerEstadistica);
		
		
		
		
		//ZONA PARA BOTONES PANEL ADMIN
		
		
		
		//ZONA PARA BOTONES PANEL FTP
		
		
		
		
		add(tpTabbed);

		panelAutores.add(lblAitor);
		panelAutores.add(lblEneko);
		panelAutores.add(lblErik);
		panelAutores.add(lblIratxe);
		
		panelLogout.add(btnLogout);
		
		panelLogout.add(lblNombreUser);
		
		panelEstadisticas.add(lblEstadistica);
		repaint();
		
	}
	
	
	public static void main(String[] args) {
		VentanaPrincipal pr = new VentanaPrincipal();
		pr.setVisible(true);
	}
}
