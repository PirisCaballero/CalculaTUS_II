package es.deusto.spq.paneles;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Local;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;



public class PanelAdmin extends JPanel{
	JLabel lblCambiarTipo, lblUsuarioAsociado;
	Choice choiceAdmin, choiceUsuario;
	JButton btnGuardar, btnRefresh;
	int admin;
	Users user;
	
	private ArrayList<Local> userList = new ArrayList<Local>();
	private Panel_Datos pd;
	public PanelAdmin(Users u , Panel_Datos pdts){
		this.setLayout(null);
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 574, 470);
		this.setVisible(true);
		this.user = u;
		this.pd = pdts;
		
		lblCambiarTipo = new JLabel();
		lblCambiarTipo.setText("Cambiar tipo de usuario:");
		lblCambiarTipo.setBounds(29, 90, 140, 30);
		this.add(lblCambiarTipo);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(178, 35, 89, 23);
		add(btnRefresh);
		
		lblUsuarioAsociado = new JLabel();
		lblUsuarioAsociado.setText("Elige un usuario:");
		lblUsuarioAsociado.setBounds(29, 120, 140, 30);
		this.add(lblUsuarioAsociado);
		
		choiceUsuario = new Choice();
		Connect cn = new Connect();
		ArrayList<Users> ul = cn.getUsers_byAdmin(user);
		for(Users us : ul) {
			choiceUsuario.add(us.getEmail());
		}
		choiceUsuario.setBounds(222, 120, 170, 30);
		this.add(choiceUsuario);
		
		choiceAdmin = new Choice();
		choiceAdmin.add("-----------");
		choiceAdmin.add("Administrador");
		choiceAdmin.add("Usuario");
		choiceAdmin.setBounds(222, 90, 170, 30);
		this.add(choiceAdmin);

		btnGuardar = new JButton();
		btnGuardar.setText("Guardar");
		btnGuardar.setBounds(111, 206, 50, 10);
		btnGuardar.setSize(80, 30);
		
		
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(choiceAdmin.getSelectedItem() + "  ||  " + choiceUsuario.getSelectedItem());
				Connect conn = new Connect();
				int admin = 2;
				if( choiceAdmin.getSelectedItem().equals("Administrador") ) {
					admin = 1;
				}else if( choiceAdmin.getSelectedItem().equals("Usuario") ) {
					admin = 0;
				}else {
					JOptionPane.showMessageDialog(null, "Debes de introducir un tipo de usuario");
				}
				if( admin < 2 ) {
					boolean cambio_efectivo = conn.cambio_de__tipo_de_usuario(user, choiceUsuario.getSelectedItem(), admin); 
					System.out.println(cambio_efectivo);
					if(cambio_efectivo) {
						JOptionPane.showMessageDialog(null, "El cambio de tipo de cuenta ha sido efectivo");
					}else {
						JOptionPane.showMessageDialog(null, "El cambio de tipo de cuenta NO ha sido efectivo");
					}
				}
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Refreshing...");
				choiceUsuario.removeAll();
				Connect cn = new Connect();
				ArrayList<Users> ul = cn.getUsers_byAdmin(user);
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.setColumnCount(2);
				String [] nomcolumns = { "Nombre" , "Correo" };
				modelo.setColumnIdentifiers(nomcolumns);
				for(Users u : ul) {
					System.out.println(u.getEmail());
					choiceUsuario.add(u.getEmail());
				}
				modelo.setRowCount(ul.size());
				for(int i = 0; i<ul.size() ; i++) {
					 modelo.setValueAt(ul.get(i).getNombre(), i, 0);
					 modelo.setValueAt(ul.get(i).getEmail(), i, 1);
				}
				pd.setData(modelo);
			}
		});
		
		
		this.add(btnGuardar);
	}
}