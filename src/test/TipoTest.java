package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import modelo.pokemon.Tipo;

class TipoTest {
	@Test
	public void constructorTest() {
		String [] s = {"", "", ""};
		Assertions.assertThrows(NullPointerException.class, () -> new Tipo(null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Tipo(s));
	}
}
