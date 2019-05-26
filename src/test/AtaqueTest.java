package test;

import static org.mockito.Mockito.mock;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modelo.pokemon.Ataque;
import modelo.pokemon.Tipo;


class AtaqueTest {
	@SuppressWarnings("unchecked")
	private Map<Tipo, Double> mapa = mock(Map.class);
	private Tipo tipo = mock(Tipo.class);

	@Test
	public void constructorTest() {
		String [] s = {"", "", ""};
		
		Assertions.assertThrows(NullPointerException.class, () -> new Ataque(null, null, null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Ataque(s, tipo, mapa));
	}

}
