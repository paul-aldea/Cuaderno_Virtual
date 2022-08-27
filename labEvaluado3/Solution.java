import java.util.Arrays;

public class labEvaluado3 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        /*  El problema en cuestion trata de devolver la ciudad con el menor número de ciudades a las que se pueda llegar a través de alguna ruta y 
            cuya distancia sea la mayor distancia Umbral. Si hay varias ciudades de este tipo, 
            retorna la ciudad con el mayor número.
        
            Para la solucion se uso el algoritmo de Floyd
        */
        
        //Creamos la matriz adyacente con las aristas obtenidas como parametro.
        int[][] matAdy = new int[n][n]; 
        
        for(int i=0; i<n; i++) { 
            Arrays.fill(matAdy[i], Integer.MAX_VALUE/2);           //Rellenamos los datos de la matriz, usando el array.fill; el MAX_VALUE esta siendo dividido por 2 para evitar posibles problemas al almacenar y usar los valores maximos
            matAdy[i][i] = 0;     //Rellena la diagonal de 0 por que la distancia de una a si misma es cero.
        }
        
        for(int[] edge: edges) { //Busca el camino minimo para ir de una ciudad a otra
            matAdy[edge[0]][edge[1]] = Math.min(matAdy[edge[0]][edge[1]], edge[2]);    //Se ocupar el Math.min para obtener el valor minimo entre dos resultados
            matAdy[edge[1]][edge[0]] = Math.min(matAdy[edge[1]][edge[0]], edge[2]);                //asociando el camino minimo a la arista
        }
        
        //Compara si el camino es mas corto yendo recto o tomando un desvio de una ciudad a otra.
        for (int k=0; k < n; k++) {
            for (int i=0; i < n; i++) { 
                for (int j=0; j < n; j++) {
                    if (matAdy[i][j] > matAdy[i][k] + matAdy[k][j]) {       //Tomando k=1, i=2, j=3; compara si ir de 2 a 3 es mayor que ir de de 1 a 2 sumado a ir de 2 a 3.
                        matAdy[i][j] = matAdy[i][k] + matAdy[k][j];  //Si tomar el desvio es mas corto remplaza esa distancia en la matriz
                    }
                }
            }
        }
        
        // Busca la ciudad con menos accesibilidad de llegar a otras dado el umbral de ciudades.
        int resultado = -1;    
        int minimoAlcanzable = Integer.MAX_VALUE; //Numero para almacenar el minimo, se incicia como el valor maximo, para facilitar las comparaciones
        
        for(int i=0; i<n; i++) {    //Dos ciclos for encadenados para recorrer la matriz matAdy
            int alcanzable = 0;     //Es un contador
            for(int j=0; j<n; j++) { 
                if(matAdy[i][j] <= distanceThreshold){ //Verifica si los valores de la matriz se encuentran en el umbral
                    alcanzable++;
                }
            }
            if(minimoAlcanzable >= alcanzable){ //Compara si minimoAlcanzable es mayor o igual que alcanzable, para reemplazar el valor minimoAlcazable de ser necesario
                minimoAlcanzable = alcanzable;  
                resultado = i; //Reemplaza el resultado por el numero de iteracion
            }
        }
        return resultado;
    }
}
/*
LINKS:
    https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/2318627/Java-Easy-Floyd-Wash-Algorithm
    https://www.youtube.com/watch?v=s33lKd8ZOkI
    https://www.youtube.com/watch?v=6GQpIpYDuHk

Integrantes:
    Isaac Eliezer Flores Henriquez
    Paul Brian Aldea Faundez
    Felipe Esteban Toro Castro
    Rene Alejandro Yañez Navarrete
    Cristian Alejandro Pinilla Vasquez
    Sergio Alexander Lara Aguilera

*/
