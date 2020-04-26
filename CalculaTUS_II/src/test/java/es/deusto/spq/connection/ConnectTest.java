package es.deusto.spq.connection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;

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
	static Users u, u2;
	static Producto pr;
	static Local loc;
	static Ticket t;
	static Opinion op;
	Boolean resultado; 
	
	@Before
	public void initialize() {
		u = new Users();
		u.setAdmin(1);
		u.setAdminEmail("null");
		u.setApellidos("Istrador");
		u.setNombre("Admin");
		u.setDireccion("Alguna");
		u.setEmail("adin@admin.com");
		u.setPass("pass");
		u.setType(Type.Admin);
		
		u2 = new Users();
		u2.setAdmin(0);
		u2.setAdminEmail("admin@admin.com");
		u2.setApellidos("Istrador");
		u2.setNombre("NoAdmin");
		u2.setDireccion("AlgunaOtra");
		u2.setEmail("nomin@noadmin.co");
		u2.setPass("passo");
		u2.setType(Type.trabajador);
		
		pr = new Producto(10, "Carne", 1, 1, u.getEmail());
		
		loc = new Local();
		loc.setCp(34532);
		loc.setDescripcion("Un local");
		loc.setDireccion("Lugar");
		loc.setId(10);
		loc.setNombre("Hiper");
		
		t = new Ticket();
		t.setFecha_emision("23/3/20");
		t.setID(1);
		t.setID_Lugar_Compra(0);
		t.setImporte(10.0);
		ArrayList<Producto> r = new ArrayList<Producto>();
		r.add(pr);
		t.setLista(r);
		t.setNombreUsuario(u.getEmail());
		
		op = new Opinion();
		op.setComentario("Best");
		op.setEmail(u.getEmail());
		op.setId_opinion(0);
		op.setValoracion(5);
	}
	
	@Test
	public void test() {
		Connect cn = new Connect();
		cn.anadirProducto(u, pr, loc.getId());
		assertTrue(u.getEmail().equals("adin@admin.com"));
		cn.Recuperar_usuario(u.getEmail());
		cn.getLocal_by_Id(u, 0);
		cn.Verificar_usuario(u.getEmail(), u.getPass());
		u.getAdminEmail();
		assertTrue(cn.isAdmin(u));
		assertFalse(cn.isAdmin(u2));
		cn.RegisLocal(u, loc);
		cn.RegisLocal(u, loc);//Dos veces para que salte la excepcion de que ya esta registrado
		cn.RegisLocal(u2, loc);
		cn.RegisUser(u);
		assertFalse(cn.RegisUser(u));//Lo mismo que la anterior
		cn.getProducts_by_ticket(u, 1);
		cn.getTicket_by_ticketID(1);
		cn.list_users();
		cn.getLocal_byName(u, "Hiper");
		cn.getLocal_byName(u, "");
		cn.getProducts_byLocal(u, loc.getId());
		cn.getLocales(u);
		cn.getLocales(u2);
		cn.getUsers_byAdmin(u);
		cn.getUsers_byAdmin(u2);
		cn.getProduct_by_Name(u, pr.getNombre());
		cn.crearTicket(u, t);
		ArrayList<Producto> r = new ArrayList<Producto>();
		r.add(pr);
		cn.introducirProductosComprador(u, r, t);
		cn.getTickets_by_user(u);
		cn.SaveOpinion(op);
	}
}








//  public class ConnectTest { //probaremos el funcionamiento de la base de datos usando las
////  funciones para añadir y extraer //ademas de otros métodos privados que para
////  hacer la prueba se han ouesti en publicos
//  
//  @Test void maipulacionConnect() { Connect c = new Connect(); //probamos que
////  se reliaze el registro de nuevos usuarios y extraccion de usario Users
//  Users usuario = new Users("Elena", "Alonso", "elena.alonso@deusto.es", "mesa555",
//  1, "null"); c.RegisUser(usuario); 
//  Boolean resultado=c.Recuperar_usuario("elena.alonso@deusto.es").equals("elena.alonso@deusto.es");
//  assertTrue(resultado);
//  //probamos que se realize correctamente la insercción de locales y la
////  busqueda de ellos 
//  Local l=new Local("bm", "santana", 48190, "nnana");
//  resultado=c.RegisLocal(usuario, l);//ya esta en la base de datos por lo que
////  deberia de ser false assertFalse(resultado);
////  resultado=c.buscar_local(usuario, l);
//  assertTrue(resultado); //comprobamos
////  que funcioa la funcion para seber si es admin resultado=c.isAdmin(usuario);
//  assertTrue(resultado); //cambiamos el tipo de usario 
//  Users trabajador = new  Users("Erik", "Alonso", "erik.alonso@deusto.es", "mqwemef", 0,
//  "elena.alonso@deusto.es");//de serie no es admin
//  c.cambio_de__tipo_de_usuario(trabajador, trabajador.getAdminEmail(), 1);
//  resultado=c.isAdmin(trabajador); assertTrue(resultado);
//  
//  
//  }
//  
//  
//  }
 
