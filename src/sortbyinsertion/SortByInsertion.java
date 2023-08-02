/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortbyinsertion;

import java.util.Scanner;

/**
 *
 * @author Morad
 */
public class SortByInsertion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de cadenas:");
        int tamanio = sc.nextInt();
        sc.nextLine(); // Consume el salto de línea después del número

        String[] lista = new String[tamanio];

        // Lee las cadenas de la lista
        for (int i = 0; i < tamanio; i++) {
            System.out.print("Ingrese la cadena " + (i + 1) + ": ");
            lista[i] = sc.nextLine();
        }

        // Llamada al método de ordenamiento por inserción
        insertionSort(lista);

        // Mostramos la lista ordenada
        System.out.println("Lista ordenada alfabéticamente:");
        for (String cadena : lista) {
            System.out.println(cadena);
        }

        sc.close();
    }

    // Método para ordenar por inserción
    private static void insertionSort(String[] lista) {
        int n = lista.length;
        for (int i = 1; i < n; i++) {
            String elementoActual = lista[i];
            int j = i - 1;

            // Mueve los  elementos mayores que el elemento actual hacia la derecha
            while (j >= 0 && lista[j].compareTo(elementoActual) > 0) {
                lista[j + 1] = lista[j];
                j--;
            }

            // Coloca el elemento actual en su lugar correcto
            lista[j + 1] = elementoActual;
        }
    }
}

/*
El algoritmo de ordenamiento por inserción es un método 
simple y eficiente para ordenar una lista de elementos, 
en este caso, una lista de cadenas alfabéticamente. 
Comienza por dividir la lista en dos partes: una parte ordenada 
y otra no ordenada. A medida que recorre la lista de izquierda a 
derecha, toma cada elemento no ordenado y lo inserta en su lugar 
correcto dentro de la parte ordenada. Para hacer esto, compara el
elemento actual con los elementos en la parte ordenada y los mueve
hacia la derecha si son mayores que el elemento actual.
Continúa este proceso hasta que todos los elementos estén
en la parte ordenada y la lista esté completamente ordenada. 
La clave del algoritmo es el bucle interno, donde se realizan
comparaciones y movimientos de elementos para insertar 
el elemento actual en su posición correcta. El ordenamiento 
por inserción tiene una complejidad de tiempo de O(n^2) enel peor caso,
lo que lo hace adecuado para listas pequeñas o casi ordenadas.
*/