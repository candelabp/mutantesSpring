package org.example.mutantesspring;

import org.example.mutantesspring.business.service.impl.DetectorMutanteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MutantesSpringApplicationTests {
	//prueba con adn mutante
	@Test
	public void testEsMutanteConAdnMutante() {
		String[] adnMutante = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAAGG",
				"CCCCTA",
				"TCACTG"
		};

		boolean resultado = DetectorMutanteService.esMutante(adnMutante);
		assertTrue(resultado, "El ADN debería ser identificado como mutante");
	}
//prueba con adn no mutante
	@Test
	public void testEsMutanteConAdnNoMutante() {
		String[] adnNoMutante = {
				"ATGCGA",
				"CAGTGC",
				"TTATTT",
				"AGACGG",
				"GCGTCA",
				"TCACTG"
		};

		boolean resultado = DetectorMutanteService.esMutante(adnNoMutante);
		assertFalse(resultado, "El ADN no debería ser identificado como mutante");
	}
//prueba con adn con letras que no corresponden
	@Test
	public void testEsMutanteConAdnInvalido() {
		String[] adnInvalido = {
				"ATGXGA",
				"CAGTGC",
				"TTATTT",
				"AGACGG",
				"GCGTCA",
				"TCACTG"
		};

		boolean resultado = DetectorMutanteService.caracteresPorCaracter(adnInvalido[0]);
		assertFalse(resultado, "El ADN debería ser inválido por contener caracteres no permitidos");
	}
//prueba con matriz menor a n=4
	@Test
	public void testEsMutanteConMatrizPequena() {
		String[] adnPequeno = {
				"ATG",
				"CAG",
				"TTT"
		};

		boolean resultado = DetectorMutanteService.esMutante(adnPequeno);
		assertFalse(resultado, "No debería detectar mutantes en matrices pequeñas");
	}

	//prueba con array nxm
	@Test
	void testArrayNoCuadrado() {
		String[] adnNoCuadrado = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT"
		};

		assertThrows(IllegalArgumentException.class, () -> {
			DetectorMutanteService.esMutante(adnNoCuadrado);
		}, "Debería lanzar una excepción cuando el array no es NxN");
	}

	@Test
	void testArrayConFilasNulas() {
		String[] adnConFilasNulas = {
				null, null, null, null, null, null
		};

		assertThrows(NullPointerException.class, () -> {
			DetectorMutanteService.esMutante(adnConFilasNulas);
		}, "Debería lanzar una NullPointerException cuando las filas del array son nulas");
	}

}
