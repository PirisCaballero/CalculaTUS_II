package com.mycompany.app.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mycompany.app.Users;
import com.mycompany.app.Connection.Connect;

public class Panel_consola extends JPanel{
	
	/**
	 * Betha 1.1
	 */
	private static final long serialVersionUID = 1L;
	JTextArea consola;
	JCheckBox checkConsola;

	// JScrollPane sp;

	private Users main_user;
	public Panel_consola(Users user) {
		main_user = user;
		this.setBounds(300 , 0 , 724 , 200);
		this.setLayout(null);
		
		
		
		//////Contenido
		JButton desbloc = new JButton("D");
		desbloc.setBounds(674,0,50,50);
		desbloc.setOpaque(true);
		consola = new JTextArea();
		// consola.setText("Inserte texto aqui...");
		consola.setBounds(0, 0, 724, 200);
		consola.setForeground(Color.green);
		consola.setBackground(Color.BLACK);
		consola.setCaretColor(Color.green);
		Font f = new Font("Serif", Font.BOLD, 15);
		consola.setFont(f);
		consola.setLineWrap(true);
		consola.setWrapStyleWord(true);
		consola.setMargin(new Insets(10, 10, 10, 10));
		consola.setCaretPosition(0);
		consola.setEnabled(false);
		addText(main_user.getNombre() + " >> BIENVENIDO A CALCULATUS II ");
		this.add(desbloc);
		this.add(consola);
		
		desbloc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connect cn = new Connect();
				boolean isA = cn.isAdmin(main_user);
				if(isA) {
					JOptionPane.showMessageDialog(null, "Es usted administrador, tiene acceso");
					consola.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "NO Es usted administrador, NO tiene acceso");
					consola.setEnabled(false);
				}
			}
		});

	}
	public void addText(String text) {
		consola.setText(text );
	}
}