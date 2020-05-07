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
	public void testOpen_connection() throws SQLException {
		assertEquals(c.getClass(), cn.Open_connection().getClass());
	}
	@Test
	public void testsay_hello() {
		assertTrue( cn.say_hello(c) );
		assertFalse( cn.say_hello(cN) );
	}
	@Test
	public void testgood_by() {
		assertTrue( cn.good_by(c) );
		assertFalse( cn.good_by(cN) );
	}
	@Test
	public void testbuscar_usuario() {
		assertTrue(cn.buscar_usuario(usT.getEmail()));
		assertFalse(cn.buscar_usuario(usF.getEmail()));
		assertFalse(cn.buscar_usuario(null));
		assertFalse(cn.buscar_usuario(""));
	}
	@Test
	public void testbuscar_local() {
		assertFalse(cn.buscar_local(usT, locF));
		assertFalse(cn.buscar_local(usF, locT));
		assertFalse(cn.buscar_local(usF, locF));
		assertFalse(cn.buscar_local(usT, null));
		assertFalse(cn.buscar_local(usF, null));
		assertFalse(cn.buscar_local(null, locF));
		assertFalse(cn.buscar_local(null, locT));
		assertTrue(cn.buscar_local(usT2, locT));
	}
	@Test 
	public void testgetLocal_by_Id() {
		assertEquals(locT.getId() , cn.getLocal_by_Id(usT2, 15).getId());
		assertEquals(null, cn.getLocal_by_Id(null, 15));
		assertEquals(null, cn.getLocal_by_Id(usF, 15));
		assertEquals(null, cn.getLocal_by_Id(null, 0));
		assertEquals(null, cn.getLocal_by_Id(null, 1000000));
	}
	@Test
	public void testVerificar_usuario() {
		Users usT2 = new Users("Cheesire", "Cat", "CH@cat.es", "kity", 1, "null");
		assertEquals(usT2.getPass(), cn.Verificar_usuario(usT2.getEmail(), usT2.getPass()).getPass());
		assertEquals(null, cn.Verificar_usuario("", ""));
		assertEquals(null, cn.Verificar_usuario("email@falso.es", ""));
		assertEquals(null, cn.Verificar_usuario(usT.getEmail(), "passFalsa"));
		assertEquals(null, cn.Verificar_usuario(null, null));
	}
	@Test
	public void testRecuperar_usuario() {
		assertEquals(usT.getApellidos(), cn.Recuperar_usuario(usT.getEmail()).getApellidos());
		assertEquals(null, cn.Recuperar_usuario(""));
		assertEquals(null, cn.Recuperar_usuario(null));
	}
	@Test
	public void testisAdmin() {
		System.out.println("UwU " + cn.isAdmin(usT));
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
	public void testgetProducts_by_ticket() {
		ArrayList<Producto> pr = new ArrayList<Producto>();
		Ticket ti = new Ticket("16-04-2020", "admin@root.es", 176.0 , 19);
		ti.setID(12);
		assertEquals(pr.getClass() , cn.getProducts_by_ticket(usT, ti.getID()).getClass() );
		assertEquals(null, cn.getProducts_by_ticket(null, 12));
		assertEquals(null, cn.getProducts_by_ticket(null, 0));
	}
	@Test
	public void testgetTicket_by_ticketID() {
		Ticket ti = new Ticket("16-04-2020", "admin@root.es", 176.0 , 19);
		ti.setID(12);
		assertEquals(ti.getClass(), cn.getTicket_by_ticketID(12).getClass());
	}
	@Test
	public void testgetUsers() {
		ArrayList<Users> ul = new ArrayList<Users>();
		assertEquals(ul.getClass(), cn.getUsers().getClass());
	}
	@Test
	public void testgetLocal_byName() {
		Local l = new Local("Deusto", "C/ Pepe", 48920, "la uni");
		l.setId(15);
		l.setEmailDuenio("unai@deusto.es");
		assertEquals(15, cn.getLocal_byName(usT2, "Deusto").getId());
		assertEquals(null, cn.getLocal_byName(null, null));
		assertEquals(null, cn.getLocal_byName(null, ""));
		assertEquals(null, cn.getLocal_byName(usF, ""));
	}
	@Test
	public void testgetProducts_byLocal() {
		Local l = new Local("Deusto", "C/ Pepe", 48920, "la uni");
		l.setId(15);
		l.setEmailDuenio("unai@deusto.es");
		ArrayList<Producto> pr = new ArrayList<Producto>();
		assertEquals(pr.getClass(), cn.getProducts_byLocal(usT, l.getId()).getClass());
		assertEquals(null, cn.getProducts_byLocal(null, 15));
		assertEquals(null, cn.getProducts_byLocal(null, 0));
		assertEquals(null, cn.getProducts_byLocal(usF, 15));
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
	public void testcambio_de__tipo_de_usuario() {
		assertTrue(cn.cambio_de__tipo_de_usuario(usT, "prueba@0.3608716890837307.es", 1));
		assertFalse(cn.cambio_de__tipo_de_usuario(usT, "", 1));
		assertFalse(cn.cambio_de__tipo_de_usuario(usT, "", 0));
		assertFalse(cn.cambio_de__tipo_de_usuario(usT, null, 1));
		assertFalse(cn.cambio_de__tipo_de_usuario(usT, null, 0));
		assertFalse(cn.cambio_de__tipo_de_usuario(null, "", 1));
		assertFalse(cn.cambio_de__tipo_de_usuario(null , usT.getEmail(), 1));
		assertFalse(cn.cambio_de__tipo_de_usuario(usT, usT.getEmail(), 1));
	}
	@Test
	public void testgetLocales() {
		ArrayList<Local> l = new ArrayList<Local>();
		assertEquals(l.getClass(), cn.getLocales(usT).getClass());
		assertEquals(null, cn.getLocales(usF));
		assertEquals(null, cn.getLocales(null));
	}
	@Test
	public void testgetUsers_byAdmin() {
		ArrayList<Users> userList = new ArrayList<Users>();
		assertEquals(userList.getClass(), cn.getUsers_byAdmin(usT).getClass());
		assertEquals(null, cn.getUsers_byAdmin(usF));//Es admin pero no existe
		assertEquals(null, cn.getUsers_byAdmin(null));
	}
	@Test
	public void testgetProduct_by_Name() {
		Producto p = new Producto("Pan", 1.0, 1);
		p.setID(290);p.setLocalAsociado(16);p.setUserAsociado("admin@root.es");
		assertEquals(p.getID(), cn.getProduct_by_Name(usT, p.getNombre()).getID());
		assertEquals(null, cn.getProduct_by_Name(null, ""));
		assertEquals(null, cn.getProduct_by_Name(usF, ""));//con usuario falso
		assertEquals(null, cn.getProduct_by_Name(usF, p.getNombre()));
		assertEquals(null, cn.getProduct_by_Name(null , null));
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
	public void testgetTickets_by_user() {
		ArrayList<Ticket> tL = new ArrayList<Ticket>();
		assertEquals(tL.getClass(), cn.getTickets_by_user(usT).getClass());
		assertEquals(null, cn.getTickets_by_user(null));
		assertEquals(null, cn.getTickets_by_user(usF));
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

