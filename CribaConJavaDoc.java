package entornos;

import java.util.Scanner;
/**
 * Este programa contiene una clase para generar todos los n�meros primos de 1
 *  hasta un n�mero m�ximo especificado  por  el  usuario.
 *  
 * El algoritmo  es simple:  Dado  un  vector  de enteros empezando  en  2, se
 * tachan  todos  los  m�ltiplos de  2.  A  continuaci�n,  se  encuentra  el  
 * siguiente entero no tachado y se tachan todos sus m�ltiplos.
 * 
 * El proceso se repite hasta que se pasa de la ra�z cuadrada del valor m�ximo.
 * Todos los n�meros que queden sin tachar son n�meros primos.
 * 
 * @author JaniraFVidal
 * @version 1.1 10/02/2021
 * 
 */
public class Criba {
	/**
	 * 
	 * @param max = dato que le pasamos al m�todo, lo cogemos en el main
	 * @return devuelve array de numeros primos desde el 2 hasta max
	 * 
	 */
	public static int[] generarPrimos(int max) {
		
		if (max >= 2) {

			int tama�oArray = max + 1;
			boolean[] esPrimo = new boolean[tama�oArray];

			for (int i = 0; i < tama�oArray; i++)
				esPrimo[i] = true;
			esPrimo[0] = esPrimo[1] = false;

			for (int i = 2; i < Math.sqrt(tama�oArray) + 1; i++) {
				if (esPrimo[i]) {
					for (int j = 2 * i; j < tama�oArray; j += i)
						esPrimo[j] = false;
				}
			}

			int cuantosPrimos = 0;
			for (int i = 0; i < tama�oArray; i++) {
				if (esPrimo[i])
					cuantosPrimos++;
			}

			int[] primos = new int[cuantosPrimos];
			for (int i = 0, j = 0; i < tama�oArray; i++) {
				if (esPrimo[i])
					primos[j++] = i;
			}
			return primos;
		} else {
			return new int[0];
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el n�mero para la criba de Erast�tenes: ");
		
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		
		teclado.close();
		
		
		System.out.println("\nVector inicial hasta: " + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.println(i + 1 + "\t");
		}
		
		vector = generarPrimos(dato);
		
		System.out.println("\nVector de primos hasta: " + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.println(vector[i] + "\t");
		}
	}
}
