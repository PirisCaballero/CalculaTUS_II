package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class OpinionMock {

	@Mock
	Opinion op1;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void testGetID_Opinion() {
		when(op1.getId_opinion()).thenReturn(3);
		assertEquals(op1.getId_opinion(), 3);
	}

	@Test
	public void testGetEmail() {
		when(op1.getEmail()).thenReturn("eneko.perez@opendeusto.es");
		assertEquals(op1.getEmail(), "eneko.perez@opendeusto.es");
	}

	@Test
	public void testGetValoracion() {
		when(op1.getValoracion()).thenReturn(100);
		assertEquals(op1.getValoracion(), 100);
	}

	@Test
	public void testGetComentario() {
		when(op1.getComentario()).thenReturn("Maravilloso");
		assertEquals(op1.getComentario(), "Maravilloso");
	}

	@Test
	public void testToString() {
		when(op1.toString()).thenReturn(
				"Opinion [id_opinion=1, email=eneko.perez@opendeusto.es, valoracion=5, comentario=Buena aplicacion]");
		assertEquals(op1.toString(),
				"Opinion [id_opinion=1, email=eneko.perez@opendeusto.es, valoracion=5, comentario=Buena aplicacion]");
	}

}
