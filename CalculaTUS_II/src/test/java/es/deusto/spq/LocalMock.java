package es.deusto.spq;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class LocalMock {

	@Mock
	Local loc1;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void testGetNombre() {
		when(loc1.getNombre()).thenReturn("Mikel");
		assertEquals(loc1.getNombre(), "Mikel");
	}

	@Test
	public void testGetDireccion() {
		when(loc1.getDireccion()).thenReturn("Avenida Amaia");
		assertEquals(loc1.getDireccion(), "Avenida Amaia");
	}

	@Test
	public void testGetDescripcion() {
		when(loc1.getDescripcion()).thenReturn("Bueno");
		assertEquals(loc1.getDescripcion(), "Bueno");
	}

	@Test
	public void testGetCp() {
		when(loc1.getCp()).thenReturn(40);
		assertEquals(loc1.getCp(), 40);
	}

	@Test
	public void testToString() {
		when(loc1.toString()).thenReturn("Nombre: casa Direccion: ninguna codigo postal: 48190");
		assertEquals(loc1.toString(), "Nombre: casa Direccion: ninguna codigo postal: 48190");
	}

}
