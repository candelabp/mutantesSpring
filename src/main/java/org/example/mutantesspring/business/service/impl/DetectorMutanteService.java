package org.example.mutantesspring.business.service.impl;

import org.springframework.stereotype.Service;

@Service
public class DetectorMutanteService {

    // Validar que solo se usen los caracteres A, T, C, G
    private static final String[] LETRAS_VALIDAS = {"A", "T", "C", "G"};

    // Verifica si el ADN contiene caracteres válidos
    public static boolean caracteresPorCaracter(String palabraIngresada) {
        for (char c : palabraIngresada.toCharArray()) {
            if (!contiene(LETRAS_VALIDAS, String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    // Ayudante para verificar si un arreglo contiene un valor
    public static boolean contiene(String[] arreglo, String valorObjetivo) {
        for (String s : arreglo) {
            if (s.equals(valorObjetivo)) {
                return true;
            }
        }
        return false;
    }

    // Método principal para verificar si es mutante
    public static boolean esMutante(String[] adn) {
        validarAdnNxN(adn); // Verificación de NxN
        validarCaracteresValidos(adn); // Verificar caracteres válidos

        int contador = 0;
        int numFilas = adn.length;
        int numColumnas = adn[0].length();

        // Verificar filas
        contador += verificarFilas(adn);
        if (contador >= 2) return true;

        // Verificar columnas
        contador += verificarColumnas(adn, numFilas, numColumnas);
        if (contador >= 2) return true;

        // Verificar diagonales descendentes
        contador += verificarDiagonalesDescendentes(adn, numFilas, numColumnas);
        if (contador >= 2) return true;

        // Verificar diagonales ascendentes 
        contador += verificarDiagonalesAscendentes(adn, numFilas, numColumnas);
        if (contador >= 2) return true;

        return contador >= 2;
    }

    // Verificación si la matriz es NxN
    private static void validarAdnNxN(String[] adn) {
        int n = adn.length;
        for (String fila : adn) {
            if (fila.length() != n) {
                throw new IllegalArgumentException("El ADN no es una matriz NxN.");
            }
        }
    }

    private static void validarCaracteresValidos(String[] adn) {
        for (String fila : adn) {
            if (!caracteresPorCaracter(fila)) {
                throw new IllegalArgumentException("El ADN contiene caracteres no válidos.");
            }
        }
    }

    private static int verificarFilas(String[] adn) {
        int contador = 0;
        for (String fila : adn) {
            for (int i = 0; i < fila.length() - 3; i++) {
                if (fila.charAt(i) == fila.charAt(i + 1) &&
                        fila.charAt(i) == fila.charAt(i + 2) &&
                        fila.charAt(i) == fila.charAt(i + 3)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private static int verificarColumnas(String[] adn, int numFilas, int numColumnas) {
        int contador = 0;
        for (int i = 0; i < numColumnas; i++) {
            for (int j = 0; j < numFilas - 3; j++) {
                if (adn[j].charAt(i) == adn[j + 1].charAt(i) &&
                        adn[j].charAt(i) == adn[j + 2].charAt(i) &&
                        adn[j].charAt(i) == adn[j + 3].charAt(i)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private static int verificarDiagonalesDescendentes(String[] adn, int numFilas, int numColumnas) {
        int contador = 0;
        for (int i = 0; i < numFilas - 3; i++) {
            for (int j = 0; j < numColumnas - 3; j++) {
                if (adn[i].charAt(j) == adn[i + 1].charAt(j + 1) &&
                        adn[i].charAt(j) == adn[i + 2].charAt(j + 2) &&
                        adn[i].charAt(j) == adn[i + 3].charAt(j + 3)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private static int verificarDiagonalesAscendentes(String[] adn, int numFilas, int numColumnas) {
        int contador = 0;
        for (int i = 3; i < numFilas; i++) {
            for (int j = 0; j < numColumnas - 3; j++) {
                if (adn[i].charAt(j) == adn[i - 1].charAt(j + 1) &&
                        adn[i].charAt(j) == adn[i - 2].charAt(j + 2) &&
                        adn[i].charAt(j) == adn[i - 3].charAt(j + 3)) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
