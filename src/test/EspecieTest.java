package test;

import static org.mockito.Mockito.mock;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import modelo.pokemon.Ataque;
import modelo.pokemon.Especie;
import modelo.pokemon.Tipo;

class EspecieTest {
 
	@SuppressWarnings("unchecked")
	private Map<Integer, Ataque> mapa = mock(Map.class);
	private Tipo tipo = mock(Tipo.class);
	
	public void constructorTest() {
		String [] str = {"", ""};
		Assertions.assertThrows(NullPointerException.class, () -> new Especie(null, null, null));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Especie(str, tipo, mapa));
	}

}
