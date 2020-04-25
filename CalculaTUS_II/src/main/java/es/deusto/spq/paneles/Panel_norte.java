package es.deusto.spq.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import es.deusto.spq.Users;
import es.deusto.spq.ventanas.Show_Tickets;
import es.deusto.spq.ventanas.VentanaLogin;
import es.deusto.spq.ventanas.Ventana_CalculaTUS_II;

public class Panel_norte extends JPanel {

	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame main_frame;
	private Icon icon;
	private Users main_user;
	private Show_Tickets pti;
	private JButton preguntas;
	public Panel_norte(Users user , JFrame fr , Show_Tickets pt) {
		this.main_frame = fr;
		this.main_user = user;
		this.setBounds(0 , 0 , main_frame.getWidth() , 50);
		this.setLayout(null);
		//this.setBorder( BorderFactory.createLineBorder(Color.green));
		this.setBackground(Color.white);
		this.pti = pt;
		
		///Contenido
		JButton exit = new JButton("Exit");
		exit.setBounds( main_frame.getWidth()-75 , 0 , 75 , 50 );
		
		icon = new ImageIcon( "src/main/java/es/deusto/spq/Resources/icons/final/addLocal.jpg" );
		JButton addLocal = new JButton(icon);
		addLocal.setBounds( 0 , 0 , 100 , 50 );
		addLocal.setBackground(Color.white);
		addLocal.setFocusPainted(false);
		
		icon = new ImageIcon( "src/main/java/es/deusto/spq/Resources/icons/final/addTicket.jpg" );
		JButton addTicket = new JButton(icon);
		addTicket.setBounds( 100 , 0 , 100 , 50 );
		addTicket.setFocusPainted(false);
		addTicket.setBackground(Color.white);
		
		icon = new ImageIcon( "src/main/java/es/deusto/spq/Resources/icons/final/addProduct.jpg" );
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
		logOut.setBounds( ftp.getLocation().x+ftp.getWidth() , 25 , 400 , 25 );
		
		preguntas = new JButton("?");
		preguntas.setBounds(logOut.getLocation().x+logOut.getWidth(), 25, 50, 25);
		
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
		this.add(preguntas);
		this.add(exit);
		
		///Listeners
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				main_frame.dispose();		
				System.exit(0);
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
					pti.dispose();
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
		admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_CalculaTUS_II.pc.setPanel(1);
			}
		});
		addTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_CalculaTUS_II.pc.setPanel(3);
			}
		});
		ftp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_CalculaTUS_II.pc.setPanel(4);
			}
		});
		userBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_CalculaTUS_II.pc.setPanel(6);
			}
		});
		preguntas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana_CalculaTUS_II.pc.setPanel(5);
			}
		});
	}
}