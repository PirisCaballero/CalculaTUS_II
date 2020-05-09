package es.deusto.spq.connection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.Local;
import es.deusto.spq.Opinion;
import es.deusto.spq.Producto;
import es.deusto.spq.Ticket;
import es.deusto.spq.Users;
import es.deusto.spq.Users.Type;



public class ConnectTest{
	static Ticket t;
	static Opinion op;
	Boolean resultado; 
	Connection c , cN;
	Connect cn;Local locT , locF;Producto pr;
	Users usT , usT2, usF;
	
	@Before
	public void initialize() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de MySQL: " + ex);
		}
		c =  DriverManager.getConnection("jdbc:mysql://83.213.204.144:3306/calculatus_root", "calculaTUS_root", "Nevera98!");
		cN = null;
		cn =  new Connect();
		
		locT = new Local("Deusto", "C/ Pepe", 48920, "la uni");
		locT.setId(15);
		locF = new Local("null" , "null" , 00001 , "null");
		locF.setEmailDuenio("unai@deusto.es");
		pr = new Producto(2.1 , "EroskiPR", 1 , 18 , "admin@root.es");
		usT = new Users("ADMIN", "ROOT", "admin@root.es", "root", 1, "null");
		usT2 = new Users("Admin", "Root", "unai@deusto.es", "root", 1, "null");
		usF = new Users("Admin", "Root", "admin@root.com", "root", 1, "null");
		
	}
	
	@Test
	public void testOpenConnection() throws SQLException {
		assertEquals(c.getClass(), cn.OpenConnection().getClass());
	}
	@Test
	public void testsayHello() {
		assertTrue( cn.sayHello(c) );
		assertFalse( cn.sayHello(cN) );
	}
	@Test
	public void testgoodBy() {
		assertTrue( cn.goodBy(c) );
		assertFalse( cn.goodBy(cN) );
	}
	@Test
	public void testbuscarUsuario() {
		assertTrue(cn.buscarUsuario(usT.getEmail()));
		assertFalse(cn.buscarUsuario(usF.getEmail()));
		assertFalse(cn.buscarUsuario(null));
		assertFalse(cn.buscarUsuario(""));
	}
	@Test
	public void testbuscarLocal() {
		assertFalse(cn.buscarLocal(usT, locF));
		assertFalse(cn.buscarLocal(usF, locT));
		assertFalse(cn.buscarLocal(usF, locF));
		assertFalse(cn.buscarLocal(usT, null));
		assertFalse(cn.buscarLocal(usF, null));
		assertFalse(cn.buscarLocal(null, locF));
		assertFalse(cn.buscarLocal(null, locT));
		assertTrue(cn.buscarLocal(usT2, locT));
	}
	@Test 
	public void testgetLocalById() {
		assertEquals(locT.getId() , cn.getLocalById(usT2, 15).getId());
		assertEquals(null, cn.getLocalById(null, 15));
		assertEquals(null, cn.getLocalById(usF, 15));
		assertEquals(null, cn.getLocalById(null, 0));
		assertEquals(null, cn.getLocalById(null, 1000000));
	}
	@Test
	public void testVerificarUsuario() {
		Users usT2 = new Users("Cheesire", "Cat", "CH@cat.es", "kity", 1, "null");
		assertEquals(usT2.getPass(), cn.VerificarUsuario(usT2.getEmail(), usT2.getPass()).getPass());
		assertEquals(null, cn.VerificarUsuario("", ""));
		assertEquals(null, cn.VerificarUsuario("email@falso.es", ""));
		assertEquals(null, cn.VerificarUsuario(usT.getEmail(), "passFalsa"));
		assertEquals(null, cn.VerificarUsuario(null, null));
	}
	@Test
	public void testRecuperarUsuario() {
		assertEquals(usT.getApellidos(), cn.RecuperarUsuario(usT.getEmail()).getApellidos());
		assertEquals(null, cn.RecuperarUsuario(""));
		assertEquals(null, cn.RecuperarUsuario(null));
	}
	@Test
	public void testisAdmin() {
		assertTrue(cn.isAdmin(usT));
		assertFalse(cn.isAdmin(null));
		assertFalse(cn.isAdmin(usF));//Este usuario no existe
		
		
	}
	@Test
	public void testRegisLocal() {
		double r = Math.random();
		String nombre = "NombreP"+r;
		Local locN = new Local(nombre, "C/ Pepe", 48920, "la uni");
		assertTrue(cn.RegisLocal(usT, locN));
		//
		r = Math.random();
		nombre = "NombreP"+r;
		locN = new Local(nombre, "C/ Pepe", 48920, "la uni");
		assertFalse(cn.RegisLocal(usF, locN));
		assertFalse(cn.RegisLocal(usF, null));
		assertFalse(cn.RegisLocal(null, null));
		assertFalse(cn.RegisLocal(null, locN));
	}
	@Test
	public void testRegisUser() {
		double r = Math.random();
		String correo = "prueba@"+r+".es";
		System.out.println(correo);
		Users us1 = new Users("Pepe", "Leal", correo, "pl", 0, "admin@root.es");//Correcto
		Users us2 = new Users("Pepe", "Leal", "p@l.com", "pl", 0, "");//mal user admin
		Users us3 = new Users("Luis", "Perez", "L@P.net", "LP", 2, "admin@root.es");//mal tipo usuario
		assertFalse(cn.RegisUser(usT));//mal usuario repetido
		assertTrue(cn.RegisUser(us1));
		assertFalse(cn.RegisUser(us2));
		assertFalse(cn.RegisUser(us3));
		double r2 = Math.random();
		String correo2 = "prueba@"+r2+".es";
		System.out.println(correo);
		Users us11 = new Users("Pepe", "Leal", correo2, "pl",1 , "null");//Correcto
		assertTrue(cn.RegisUser(us11));
	}
	@Test
	public void testgetProductsByTicket() {
		ArrayList<Producto> pr = new ArrayList<Producto>();
		Ticket ti = new Ticket("16-04-2020", "admin@root.es", 176.0 , 19);
		ti.setID(12);
		assertEquals(pr.getClass() , cn.getProductsByTicket(usT, ti.getID()).getClass() );
		assertEquals(null, cn.getProductsByTicket(null, 12));
		assertEquals(null, cn.getProductsByTicket(null, 0));
	}
	@Test
	public void testgetTicketbyTicketID() {
		Ticket ti = new Ticket("16-04-2020", "admin@root.es", 176.0 , 19);
		ti.setID(12);
		assertEquals(ti.getClass(), cn.getTicketByTicketID(12).getClass());
	}
	@Test
	public void testgetUsers() {
		ArrayList<Users> ul = new ArrayList<Users>();
		assertEquals(ul.getClass(), cn.getUsers().getClass());
	}
	@Test
	public void testgetLocalbyName() {
		Local l = new Local("Deusto", "C/ Pepe", 48920, "la uni");
		l.setId(15);
		l.setEmailDuenio("unai@deusto.es");
		assertEquals(15, cn.getLocalByName(usT2, "Deusto").getId());
		assertEquals(null, cn.getLocalByName(null, null));
		assertEquals(null, cn.getLocalByName(null, ""));
		assertEquals(null, cn.getLocalByName(usF, ""));
	}
	@Test
	public void testgetProductsByLocal() {
		Local l = new Local("Deusto", "C/ Pepe", 48920, "la uni");
		l.setId(15);
		l.setEmailDuenio("unai@deusto.es");
		ArrayList<Producto> pr = new ArrayList<Producto>();
		assertEquals(pr.getClass(), cn.getProductsByLocal(usT, l.getId()).getClass());
		assertEquals(null, cn.getProductsByLocal(null, 15));
		assertEquals(null, cn.getProductsByLocal(null, 0));
		assertEquals(null, cn.getProductsByLocal(usF, 15));
	}
	@Test
	public void testanadirProducto() {
		Local l = new Local("Deusto", "C/ Pepe", 48920, "la uni");
		l.setId(16);
		l.setEmailDuenio("unai@deusto.es");
		double r = Math.random();
		Producto p = new Producto("Pan"+r, 1.0, 1);
		p.setID(110);p.setLocalAsociado(16);p.setUserAsociado("admin@root.es");
		assertTrue(cn.anadirProducto(usT, p, l.getId()));
		assertFalse(cn.anadirProducto(usT, null, 15));
		assertFalse(cn.anadirProducto(usT, p, 0));
		assertFalse(cn.anadirProducto(null, null, 15));
		assertFalse(cn.anadirProducto(null, p, 15));
		assertFalse(cn.anadirProducto(usF, null, 15));
		assertFalse(cn.anadirProducto(usF, null, 0));
	}
	@Test
	public void testcambio_deTipoDeUsuario() {
		assertTrue(cn.cambioDeTipoDeUsuario(usT, "prueba@0.3608716890837307.es", 1));
		assertFalse(cn.cambioDeTipoDeUsuario(usT, "", 1));
		assertFalse(cn.cambioDeTipoDeUsuario(usT, "", 0));
		assertFalse(cn.cambioDeTipoDeUsuario(usT, null, 1));
		assertFalse(cn.cambioDeTipoDeUsuario(usT, null, 0));
		assertFalse(cn.cambioDeTipoDeUsuario(null, "", 1));
		assertFalse(cn.cambioDeTipoDeUsuario(null , usT.getEmail(), 1));
		assertFalse(cn.cambioDeTipoDeUsuario(usT, usT.getEmail(), 1));
	}
	@Test
	public void testgetLocales() {
		ArrayList<Local> l = new ArrayList<Local>();
		assertEquals(l.getClass(), cn.getLocales(usT).getClass());
		assertEquals(null, cn.getLocales(usF));
		assertEquals(null, cn.getLocales(null));
	}
	@Test
	public void testgetUsersByAdmin() {
		ArrayList<Users> userList = new ArrayList<Users>();
		assertEquals(userList.getClass(), cn.getUsersByAdmin(usT).getClass());
		assertEquals(null, cn.getUsersByAdmin(usF));//Es admin pero no existe
		assertEquals(null, cn.getUsersByAdmin(null));
	}
	@Test
	public void testgetProductByName() {
		Producto p = new Producto("Pan", 1.0, 1);
		p.setID(290);p.setLocalAsociado(16);p.setUserAsociado("admin@root.es");
		assertEquals(p.getID(), cn.getProductByName(usT, p.getNombre()).getID());
		assertEquals(null, cn.getProductByName(null, ""));
		assertEquals(null, cn.getProductByName(usF, ""));//con usuario falso
		assertEquals(null, cn.getProductByName(usF, p.getNombre()));
		assertEquals(null, cn.getProductByName(null , null));
	}
	@Test
	public void testcrearTicket() {
		Ticket ti = new Ticket("27-04-2020", "admin@root.es", 3.0, 16);
		assertEquals(ti.getNombreUsuario() , cn.crearTicket(usT, ti).getNombreUsuario());
		assertEquals(null, cn.crearTicket(usT, null));
		assertEquals(null, cn.crearTicket(usF, ti));
		assertEquals(null, cn.crearTicket(usF, null));
	}
	@Test
	public void testintroducirProductosComprador() {
		ArrayList<Producto> pr = new ArrayList<Producto>();
		double r = Math.random();
		String nom = "Pan" + r;
		Producto p = new Producto(nom, 1.0, 1);
		p.setID(290);p.setLocalAsociado(16);p.setUserAsociado("admin@root.es");
		pr.add(p);
		Ticket ti = new Ticket("27-04-2020", "admin@root.es", 3.0, 16);
		Ticket t = cn.crearTicket(usT, ti);
		
		assertTrue(cn.introducirProductosComprador(usT, pr, t));
		assertFalse(cn.introducirProductosComprador(usT, null, null));
		assertFalse(cn.introducirProductosComprador(usF, null, null));
		assertFalse(cn.introducirProductosComprador(null, null, null));
		
	}
	@Test
	public void testgetTicketsByUser() {
		ArrayList<Ticket> tL = new ArrayList<Ticket>();
		assertEquals(tL.getClass(), cn.getTicketsByUser(usT).getClass());
		assertEquals(null, cn.getTicketsByUser(null));
		assertEquals(null, cn.getTicketsByUser(usF));
	}
	@Test
	public void testSaveOpinion() {
		String ID = Math.random()*1000 + "";
		int id = (int) Double.parseDouble(ID);
		Opinion op = new Opinion();
		op.setEmail("admin@root.es");
		op.setComentario("OK");
		op.setId_opinion(id);
		op.setValoracion(5);
		
		assertTrue(cn.SaveOpinion(op));
		assertFalse(cn.SaveOpinion(null));
	}
	@Test
	public void testupdateData() {
		String nom = "NombreTest";
		String pas = "PassTest";
		assertTrue(cn.updateData(usT2, nom, pas));
		assertFalse(cn.updateData(usF, "", ""));
		assertFalse(cn.updateData(usF, nom, pas));
		assertFalse(cn.updateData(null, "", ""));
		assertFalse(cn.updateData(usF, null, null));
		assertFalse(cn.updateData(null, null, null));
	}
}

