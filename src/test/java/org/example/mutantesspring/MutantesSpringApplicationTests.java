package org.example.mutantesspring;

import org.example.mutantesspring.business.service.impl.DetectorMutanteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MutantesSpringApplicationTests {
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


	}
