package org.example.mutantesspring.business.service.impl;

import org.springframework.stereotype.Service;

@Service
public class DetectorMutanteService {

    public static boolean caracteresPorCaracter(String palabraIngresada) {
        String[] letras = {"A", "T", "C", "G"};
        for (char c : palabraIngresada.toCharArray()) {
            if (!contiene(letras, String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean contiene(String[] arreglo, String valorObjetivo) {
        for (String s : arreglo) {
            if (s.equals(valorObjetivo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean esMutante(String[] adn) {
        int contador = 0;
        int numFilas = adn.length;
        int numColumnas = adn[0].length();

        // Verificar filas
        for (String fila : adn) {
            for (int i = 0; i < fila.length() - 3; i++) {
                if (fila.charAt(i) == fila.charAt(i + 1) &&
                        fila.charAt(i) == fila.charAt(i + 2) &&
                        fila.charAt(i) == fila.charAt(i + 3)) {
                    contador++;
                    if (contador >= 2) return true;
                }
            }
        }

        // Verificar columnas
        for (int i = 0; i < numColumnas; i++) {
            for (int j = 0; j < numFilas - 3; j++) {
                if (adn[j].charAt(i) == adn[j + 1].charAt(i) &&
                        adn[j].charAt(i) == adn[j + 2].charAt(i) &&
                        adn[j].charAt(i) == adn[j + 3].charAt(i)) {
                    contador++;
                    if (contador >= 2) return true;
                }
            }
        }

        // Verificar diagonales descendentes (\)
        for (int i = 0; i < numFilas - 3; i++) {
            for (int j = 0; j < numColumnas - 3; j++) {
                if (adn[i].charAt(j) == adn[i + 1].charAt(j + 1) &&
                        adn[i].charAt(j) == adn[i + 2].charAt(j + 2) &&
                        adn[i].charAt(j) == adn[i + 3].charAt(j + 3)) {
                    contador++;
                    if (contador >= 2) return true;
                }
            }
        }

        // Verificar diagonales ascendentes (/)
        for (int i = 3; i < numFilas; i++) {
            for (int j = 0; j < numColumnas - 3; j++) {
                if (adn[i].charAt(j) == adn[i - 1].charAt(j + 1) &&
                        adn[i].charAt(j) == adn[i - 2].charAt(j + 2) &&
                        adn[i].charAt(j) == adn[i - 3].charAt(j + 3)) {
                    contador++;
                    if (contador >= 2) return true;
                }
            }
        }

        return contador >= 2;
    }
}
