package entornos;

import java.util.Scanner;

public class Criba {

	public static int[] generarPrimos(int max) {
		
		if (max >= 2) {

			int tamañoArray = max + 1;
			boolean[] esPrimo = new boolean[tamañoArray];

			for (int i = 0; i < tamañoArray; i++)
				esPrimo[i] = true;
			esPrimo[0] = esPrimo[1] = false;

			for (int i = 2; i < Math.sqrt(tamañoArray) + 1; i++) {
				if (esPrimo[i]) {
					for (int j = 2 * i; j < tamañoArray; j += i)
						esPrimo[j] = false;
				}
			}

			int cuantosPrimos = 0;
			for (int i = 0; i < tamañoArray; i++) {
				if (esPrimo[i])
					cuantosPrimos++;
			}

			int[] primos = new int[cuantosPrimos];
			for (int i = 0, j = 0; i < tamañoArray; i++) {
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
		System.out.println("Introduce el número para la criba de Erastótenes: ");
		
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
