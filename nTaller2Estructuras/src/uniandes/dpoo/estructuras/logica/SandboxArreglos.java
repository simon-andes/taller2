package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	
    	
    	int[] copia = new int[getCantidadEnteros()];
    	System.arraycopy(arregloEnteros, 0 ,copia, 0, getCantidadEnteros());
    	
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	
    	String[] copia = new String[getCantidadCadenas()];
    	System.arraycopy(arregloCadenas, 0, copia, 0, getCantidadCadenas());
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] arreglo = new int [getCantidadEnteros() + 1];
    	System.arraycopy(arregloEnteros, 0, arreglo, 0 , arregloEnteros.length);
    	arreglo[arreglo.length-1] = entero;
    	arregloEnteros = arreglo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	
    	String[] arreglo = new String [getCantidadCadenas() + 1];
    	System.arraycopy(arregloCadenas, 0, arreglo, 0 , getCantidadCadenas());
    	arreglo[arreglo.length-1] = cadena;
    	arregloCadenas = arreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int counter = 0;

    	for(int n : arregloEnteros) {
    		
    		if(n == valor) {
    			
    			counter++;
    			
    		}
    	}
    	
    	int[] arreglo = new int[getCantidadEnteros() - counter];
    	int i = 0;
    	
    	for (int n: arregloEnteros) {
    		
    		if (n != valor) {
    			
    			arreglo[i] = n;
    			
    			i++;
    			
    		}
    	}
    	
    	arregloEnteros = arreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	
    	int counter = 0;

    	for(String n : arregloCadenas) {
    		
    		if(n == cadena) {
    			
    			counter++;
    			
    		}
    	}
    	
    	String[] arreglo = new String[getCantidadCadenas() - counter];
    	int i = 0;
    	
    	for (String n: arregloCadenas) {
    		
    		if (n != cadena) {
    			
    			arreglo[i] = n;
    			
    			i++;
    			
    		}
    	}
    	
    	arregloCadenas = arreglo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int size = getCantidadEnteros();
		int[] arreglo = new int[size + 1];
		
    	if (posicion < 0) {
    		
    		arreglo[0] = entero;
    		
    		System.arraycopy(arregloEnteros, 0, arreglo, 1, getCantidadEnteros());
    	}
    	else if(posicion > size){
    		
    		System.arraycopy(arregloEnteros, 0, arreglo, 0, size);
    		
    		arreglo[size] = entero;
    	
    	}
    	
    	else {
    		
    		System.arraycopy(arregloEnteros, 0, arreglo, 0, posicion);
    		arreglo[posicion] = entero;
    		System.arraycopy(arregloEnteros, posicion, arreglo, posicion + 1, size - posicion);
    		
    	
    	}
    	
    	arregloEnteros = arreglo;
    }
    

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	
    	int size = getCantidadEnteros();
    	
    	if ((posicion >= 0) && (posicion < size)){
    		
    		int[] arreglo = new int[size -1];
    		
    		System.arraycopy(arregloEnteros, 0, arreglo, 0, posicion);
    		System.arraycopy(arregloEnteros, posicion+1, arreglo, posicion, size-posicion-1);
    		
    		arregloEnteros = arreglo;
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] arreglo = new int[valores.length];
    	int indice = 0;
    	
    	for(double n: valores) {
    		
    		arreglo[indice] = (int) n;
    		
    		indice++;
    		
    	}
    	
    	arregloEnteros = arreglo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] arreglo = new String[objetos.length];
    	
    	for (int i = 0; i < objetos.length; i++) {
    		if (objetos[i] instanceof String) {
    			arreglo[i] = (String) objetos[i]; 
    		}
    		else if (objetos[i] instanceof Double){
    			
    			arreglo[i] = String.format("%.2f", (Double)objetos[i]);
    		} else if (objetos[i] instanceof Character){
    			
    			arreglo[i] = String.valueOf((Character) objetos[i]);
     		} else if (objetos[i] instanceof Integer) {
     			
     			arreglo[i] = String.valueOf((Integer) objetos[i]);
     		} else if (objetos[i] instanceof Boolean) {
     			
     			arreglo[i] = String.valueOf((Boolean) objetos[i]);
     		}
    		
    		else {
    			
    			arreglo[i] = "";
    		}
    		   		
    	}
    	
    	arregloCadenas = arreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int[] arreglo = new int[getCantidadEnteros()];
    	int i = 0;
    	
    	for(int n:arregloEnteros) {
    		if(n<0) {
    			arreglo[i] = n * -1;
    		}
    		else {
    			arreglo[i] = n;
    		}
    		i++;
    	}
    	
    	arregloEnteros = arreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	int size = getCantidadEnteros();
    	
    	for(int i =0; i < size -1;) {
    		for(int j = 0; j < size -1 -i;) {
    			
    			if (arregloEnteros[j] > arregloEnteros[j+1]) {
    				
    				int n = arregloEnteros[j];
    				arregloEnteros[j] = arregloEnteros[j+1];
    				arregloEnteros[j+1] = n;
    				
    			}
    		j++;
    		}
    		
    		i++;
    	}
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	int size = getCantidadCadenas();
    	
    	for(int i =0; i < size -1;) {
    		for(int j = 0; j < size -1 -i;) {
    			
    			if (arregloCadenas[j].compareTo( arregloCadenas[j+1])>0) {
    				
    				String n = arregloCadenas[j];
    				arregloCadenas[j] = arregloCadenas[j+1];
    				arregloCadenas[j+1] = n;
    				
    			}
    		j++;
    		}
    		
    		i++;
    	}
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int counter = 0;
    	
    	for(int n:arregloEnteros) {
    		
    		if(n == valor) {
    			
    			counter++;
    		}
    	}
    		
        return counter;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int counter = 0;
    	
    	for(String n:arregloCadenas) {
    		
    		if(n.equalsIgnoreCase(cadena)) {
    			counter++;
    		}
    	}
    	
        return counter;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int counter = 0;
    	int[] copia = getCopiaEnteros();
    	int size = getCantidadEnteros();
    	int[] arreglo1 = new int[size];
    	
    	for (int i = 0; i < size; i++) {
    		if (arregloEnteros[i]==valor) {
    			
    			counter++;
    			arreglo1[i] = i;
    			
    		}
    		else {
    			arreglo1[i] =-1;
    		}
    	}
    	int[] arreglo;
    	if(counter==0) {
    		
    		return new int[0];
    	}
    	else {
    		
    		arregloEnteros = arreglo1;
    		eliminarEntero(-1);
    		arreglo = new int[getCantidadEnteros()];
    		
    		arreglo = arregloEnteros;
    	    		
    	}
    	
    	arregloEnteros = copia;
    	
        return arreglo;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	
    	int size = getCantidadEnteros();
        
        if (size == 0) {
            return new int[0];
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < size; i++) {
            if (arregloEnteros[i] < min) {
                min = arregloEnteros[i];
            }
            if (arregloEnteros[i] > max) {
                max = arregloEnteros[i];
            }
        }
        
        int[] rango = {min, max};
        return rango;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    		HashMap<Integer, Integer> histograma = new HashMap<>();
    		
    		int size = getCantidadEnteros();
    		
    		for(int i = 0; i<size; i++) {
    			
    			int valor = arregloEnteros[i];
    			
    			if (histograma.containsKey(valor)) {
    				
    				histograma.put(valor, histograma.get(valor) + 1 );
    				
    			}
    			else {
    				histograma.put(valor,1);
    				
    			}
    		}
    	
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos()
    {
        HashMap<Integer, Integer> histograma = calcularHistograma();
        int counter = 0;

        for (int ocurrencias : histograma.values()) {
            if (ocurrencias > 1) {
                counter++;
            }
        }

        return counter;
    }


    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	
    	int size = getCantidadEnteros();
    	
    	if (size != otroArreglo.length) {
    		
    		return false;
    	}
    	
    	for (int i = 0; i<size; i++) {
    		
    		if(arregloEnteros[i] != otroArreglo[i]) {
    			
    			return false;
    			
    		}
    		
    	}
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	HashMap<Integer, Integer> histograma1 = new HashMap<>();
        HashMap<Integer, Integer> histograma2 = new HashMap<>();

        for (int n : arregloEnteros) {
            histograma1.put(n, histograma1.getOrDefault(n, 0) + 1);
        }

        for (int n : otroArreglo) {
            histograma2.put(n, histograma2.getOrDefault(n, 0) + 1);
        }

        return histograma1.equals(histograma2);
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	arregloEnteros = new int[cantidad];
    	for(int i = 0; i<cantidad; i++) {
    		
    		arregloEnteros[i] = (int) (Math.random()*(maximo - minimo + 1)) + minimo;
    		
    	}
    }

}
