package com.mycompany.app.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mycompany.app.Users;
import com.mycompany.app.ventanas.VentanaLogin;
import com.mycompany.app.ventanas.Ventana_CalculaTUS_II;

public class Panel_norte extends JPanel {

	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame main_frame;
	private Icon icon;
	private Users main_user;
	public Panel_norte(Users user , JFrame fr) {
		this.main_frame = fr;
		this.main_user = user;
		this.setBounds(0 , 0 , main_frame.getWidth() , 50);
		this.setLayout(null);
		this.setBorder( BorderFactory.createLineBorder(Color.green));
		this.setBackground(Color.white);
		
		///Contenido
		JButton exit = new JButton("Exit");
		exit.setBounds( main_frame.getWidth()-75 , 0 , 75 , 50 );
		
		icon = new ImageIcon( "src/main/java/com/mycompany/app/Resources/icons/final/addLocal.jpg" );
		JButton addLocal = new JButton(icon);
		addLocal.setBounds( 0 , 0 , 100 , 50 );
		addLocal.setBackground(Color.white);
		addLocal.setFocusPainted(false);
		
		icon = new ImageIcon( "src/main/java/com/mycompany/app/Resources/icons/final/addTicket.jpg" );
		JButton addTicket = new JButton(icon);
		addTicket.setBounds( 100 , 0 , 100 , 50 );
		addTicket.setFocusPainted(false);
		addTicket.setBackground(Color.white);
		
		icon = new ImageIcon( "src/main/java/com/mycompany/app/Resources/icons/final/addProduct.jpg" );
		JButton addProducto = new JButton(icon);
		addProducto.setBounds( 200 , 0 , 100 , 50 );
		addProducto.setBackground(Color.white);
		addProducto.setFocusPainted(false);
		
		JButton admin = new JButton("Admin");
		admin.setBounds( 300 , 0 , 100 , 25 );
		
		JButton userBut = new JButton("User");
		userBut.setBounds( 300 , 25 , 100 , 25 );
		
		JButton ftp = new JButton("FTP");
		ftp.setBounds( 400 , 0 , 100 , 25 );
		
		JButton sql = new JButton("SQL");
		sql.setBounds( 400 , 25 , 100 , 25 );
		
		JLabel usuario = new JLabel( main_user.getEmail() );
		usuario.setBounds( ftp.getLocation().x+ftp.getWidth() , 0 , 450 , 25 );
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton logOut = new JButton("Log Out");
		logOut.setBounds( ftp.getLocation().x+ftp.getWidth() , 25 , 450 , 25 );
		
		////añadir al panel
		this.add(ftp);
		this.add(sql);
		this.add(addProducto);
		this.add(userBut);
		this.add(admin);
		this.add(logOut);
		this.add(addTicket);
		this.add(addLocal);
		this.add(usuario);
		this.add(exit);
		
		///Listeners
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				main_frame.dispose();		
			}
		});
		logOut.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cerrando sesion...");
				JOptionPane cerrar = new JOptionPane();
				int resp = cerrar.showConfirmDialog(null, "¿Seguro que quieres salir?", "Aviso",
						JOptionPane.YES_NO_OPTION);
				if (resp == 0) {
					main_frame.dispose();
					VentanaLogin vtnLogin = new VentanaLogin();
					vtnLogin.setVisible(true);
				}
			}
		});
		addLocal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_CalculaTUS_II.pc.setPanel(0);
			}
		});
		addProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_CalculaTUS_II.pc.setPanel(2);
			}
		});
	}
}
