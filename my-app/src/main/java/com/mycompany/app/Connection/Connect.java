
public class Connect {
	
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException ex) {
	    System.out.println("Error al registrar el driver de MySQL: " + ex);
	}
	
	public boolean say_hello () {
		
	}

}
