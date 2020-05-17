package es.deusto.spq.paneles;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import javax.activation.MailcapCommandMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.Ticket;
import es.deusto.spq.Users;
import es.deusto.spq.connection.Connect;
import es.deusto.spq.ventanas.VentanaCalculaTUSII;

/**
 * Panel que da ocpion a ver los tickets de otros usuarios.
 * Se accede desd el panelUser, con el boton "Control parental".
 */

public class PanelControl extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel lblSeleccionar;private JLabel lblTitulo;
	private JButton btnDatos; private JButton btnVolver;
	private Choice choiceUsuario;
	private Users user;
	private PanelDatos dts;
	private Connect cn;
	
	public PanelControl(Users u, PanelDatos pdts) {
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
		
		btnDatos = new JButton("Mostrar datos");
		btnDatos.setBounds(this.getWidth()/2-105, 150, 150, 50);
		btnDatos.setHorizontalAlignment(SwingConstants.CENTER);
		add(btnDatos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(this.getWidth()/2-105, 250, 150, 50);
		btnVolver.setHorizontalAlignment(SwingConstants.CENTER);
		add(btnVolver);
				
		lblSeleccionar = new JLabel();
		lblSeleccionar.setText("Escoge una cuenta:");
		lblSeleccionar.setBounds(29, 100, 140, 30);
		this.add(lblSeleccionar);
		
		choiceUsuario = new Choice();
		cn = new Connect();
		ArrayList<Users> ul = cn.getUsersByAdmin(user);
		if( user.getAdmin() == 1 ) {
			for(Users us : ul) {
				choiceUsuario.add(us.getEmail());
			}
		}
		choiceUsuario.setBounds(180, 100, 170, 30);
		this.add(choiceUsuario);
		
		
		
		btnDatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setDatos();
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCalculaTUSII.pc.setPanel(6);
			}
		});
	}
	
	
	public void setDatos() {
		ArrayList<Ticket> t = cn.getTicketsByUser(cn.RecuperarUsuario(choiceUsuario.getSelectedItem()));
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return true;};
		};
		
		modelo.setColumnCount(3);
		String [] nomColumns = {"Nombre", "Fecha", "Precio"};
		modelo.setColumnIdentifiers(nomColumns);
		modelo.setRowCount(t.size());
		for(int i=0; i<t.size(); i++) {
			modelo.setValueAt(t.get(i).getNombreUsuario(), i, 0);
			modelo.setValueAt(t.get(i).getFecha_emision(), i, 1);
			modelo.setValueAt(t.get(i).getImporte(), i, 2);					
		}
		dts.setData(modelo);
		if(t.size()==0) {
			JOptionPane.showMessageDialog(null, "No se han registrado tickets");
			
		}
	}
	
}
