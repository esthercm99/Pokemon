package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.combate.Entrenador;
import modelo.combate.Maquina;

class EntrenadorTest {

	Entrenador e1 = new Maquina();
	
	@Test
	void areAllPokemonAliveTest() {
		// False = No se rinde porque tiene pokémons vivos.
		assertFalse(e1.areAllPokemonAlive());		
	}
	@Test
	void rendirseTest() {
		assertTrue(e1.rendirse());
	}

}
