package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Map;

import modelo.categoria.*;
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
	
	@Test
	public void stringToCategoriaFisicoTest() {
		String [] str = {"1", "Golpe Cuerpo", "2", "2", "FISICO"};
		Categoria fisico = new Fisico();
		Ataque ataque = new Ataque(str, tipo, mapa);
		boolean isEqual = ataque.getCategoria().getClass().getSimpleName().equals(fisico.getClass().getSimpleName());
		assertTrue(isEqual);
	}
	@Test
	public void stringToCategoriaEspecialTest() {
		String [] str = {"1", "Golpe Especial", "2", "2", "ESPECIAL"};
		Categoria especial = new Especial();
		Ataque ataque = new Ataque(str, tipo, mapa);
		boolean isEqual = ataque.getCategoria().getClass().getSimpleName().equals(especial.getClass().getSimpleName());
		assertTrue(isEqual);
	}
	@Test
	public void stringToCategoriaEstParTest() {
		String [] str = {"1", "Paralizar", "2", "2", "ESTADOPAR"};
		Categoria estPar = new EstadoParalizado();
		Ataque ataque = new Ataque(str, tipo, mapa);
		boolean isEqual = ataque.getCategoria().getClass().getSimpleName().equals(estPar.getClass().getSimpleName());
		assertTrue(isEqual);
	}
	@Test
	public void stringToCategoriaEstDorTest() {
		String [] str = {"1", "Dormir", "2", "2", "ESTADODOR"};
		Categoria estDor = new EstadoDormido();
		Ataque ataque = new Ataque(str, tipo, mapa);
		boolean isEqual = ataque.getCategoria().getClass().getSimpleName().equals(estDor.getClass().getSimpleName());
		assertTrue(isEqual);
	}
	@Test
	public void stringToCategoriaEstEnvTest() {
		String [] str = {"1", "Envenenar", "2", "2", "ESTADOENV"};
		Categoria estEnv = new EstadoEnvenenado();
		Ataque ataque = new Ataque(str, tipo, mapa);
		boolean isEqual = ataque.getCategoria().getClass().getSimpleName().equals(estEnv.getClass().getSimpleName());
		assertTrue(isEqual);
	}
	@Test
	public void stringToCategoriaFailTest() {
		String [] str = {"1", "Paralizar", "2", "2", ""};
		Categoria estPar = new EstadoParalizado();
		Ataque ataque = new Ataque(str, tipo, mapa);
		Assertions.assertThrows(NullPointerException.class, () -> ataque.getCategoria().getClass().getSimpleName().equals(estPar.getClass().getSimpleName()));
	}
	
}
