<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO ACADÉMICO DE INGENIERÍA DE SISTEMAS E INFORMÁTICA</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: INFORME DE LABORATORIO</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>
<div align="center">
<span style="font-weight:bold;">GUÍA DE LABORATORIO</span><br />
</div>

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5"> Estructura de Datos y Algoritmos </td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5"> Grafos </td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>07</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA INICIO::</td><td>17-Agosto-2022</td><td>FECHA FIN:</td><td>21-Agosto-2022</td><td>DURACIÓN:</td><td>02 horas</td>
</tr>
<tr><td colspan="6">RECURSOS:
    <ul>
      <li> Weiss M., Data Structures & Problem Solving Using Java, 2010, Addison-Wesley.
      <li> Escuela de Pedagogía en Educación Matemática, Marcelino Álvarez, et.al.,
      <li> http://repobib.ubiobio.cl/jspui/bitstream/123456789/1953/3/Alvarez_Nunez_Marcelino.pdf
      <li> http://www.oia.unsam.edu.ar/wp-content/uploads/2017/11/dijkstra-prim.pdf
    </ul>    
</td>
</<tr>
  <tr><td colspan="6">ALUMNO:
<ul>
<li>Frank's Vilca Quispe - fvilcaqui@unsa.edu.pe</li>
</ul>
</td>
</<tr>
<tr><td colspan="6">DOCENTES:
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tdbody>
</table>

   ## SOLUCION Y RESULTADOS


## I. SOLUCION DE EJERCICIOS/PROBLEMAS

-	Implementar el cogido de Grafo cuya representación sea realizada mediante Lista de adyacencia.
- 
- Para implementar el siguiente grafo con lista de adyacencia primero creamos la clase Datos donde se guardarán los datos de un nodo de grafo o llamado también vértice.
-	La variable init será el vértice del grafo.
-	la variable fin seria a donde desea llegar el vértice.
-	La variable tam sería el tamaño de la arista.

         public class Datos {
	           int init, fin,tam;
             
 - Aqui tenemos al constructor del grafo
	
             Datos(int tam,int init, int fin){
	              this.tam = tam;
	              this.init = init;
	              this.fin = fin;
             }
         }

- Esta clase del grafo sera en el que introduciremos los valores desde la interfaz List.

         public class Grafo {

- Creamos el List dentro de otro List ya que el primer list sera donde iran nuestros vértices y el segundo list a donde desean llegar.
   
              List<List<Integer>> lista = new ArrayList<>();
              public Grafo(List<Datos> valores){
              int n = 0; 
        
- Con este for conseguiremos el tamaño total de vértices dentro del grafo.  
            
             for (Datos e: valores) {
                  n = Integer.max(n, Integer.max(e.init, e.fin));          
             }
        
- Con este for creamos los vértices con segundo valor arrayList donde irán los lugares a donde quiere llegar el vértice.
            
            for (int i = 0; i <= n; i++){
                  lista.add(i, new ArrayList<>());
            }
        
- Con ayuda de este for ingresaremos todos los valores a donde llegara nuestro vértice.  
            
            for (Datos current: valores){
                  lista.get(current.init).add(current.fin);
            }
         }
    
- Este método imprimirá el grafo y los mostraremos como una lista de adyacencia tal como es.
    
           public static void Imprimir(Grafo grafo){
                   int src = 0;
                   int n = grafo.lista.size();
                   while (src < n){
                       for (int dest: grafo.lista.get(src)) {
                            System.out.print("(" + src + " ——> " + dest + ")\t");
                       }
                  System.out.println();
                  src++;
                 }
           }


- Ejemplo: 

![image](https://user-images.githubusercontent.com/87882802/185768991-4b14d77d-e5d8-4d77-92cb-740b0debb8cb.png)

•	Implementar BSF, DFS y Dijkstra con sus respectivos casos de prueba. (5 puntos)
     
COMENZAREMOS CON LA IMPLEMENTACIÓN DE LA BÚSQUEDA DE DFS.
      
 - Primero creamos un array, en este caso será de 100 ya que no crearemos un grafo mayor a este tamaño, lo utilizaremos para saber que nodos fueron visitados
      
                   static boolean[] visitDFS = new boolean[100];
      
- Comenzamos con el metodo DFS la cual tendra como entrada en grafo. 
      
	               public static void DFS(Grafo grafo) {
    
- Primero ingresaremos los valores a false de la cantidad de vértices del grafo.
       
		                 for (int i = 0;i < grafo.lista.size();i++) {
                              visitDFS[i] = false;
                         }
        
- Con este for recorreremos cada una de los vértices en caso el vértice sea false no dirigira al método Visitar DFS.
        
		                 for(int j = 0;j < grafo.lista.size();j++) {
			                  if(visitDFS[j] == false) {
				                  visitarDFS(grafo,j);
			                  }
		                 }
	               }

- El Metodo visitarDFS para el cual tendremos como entrada el grafo y el pos
    
	              public static void VisitarDFS(Grafo grafo,int pos) {
    
- Primero cambiaremos el grafo por true para saber que fue visitado
      
		               visitDFS[pos] = true;
		               System.out.println(pos);
		               for(int a : grafo.lista.get(pos)) {
        
- Con este for recorreremos todos los lugares a donde ir a nuestro vértice y en caso sea false volveremos a llamar el VisitarDFS 
             
			             if (visitDFS[a] == false) {
				             System.out.println("a" + a);
				             VisitarDFS(grafo,a);
			             }		
		              }
	              }
	
•	Ejemplo

![image](https://user-images.githubusercontent.com/87882802/185768996-715ba8e1-429d-455f-836c-b70f239d7754.png)

El grafo al que se le encontró la búsqueda DFS es el siguiente:

![image](https://user-images.githubusercontent.com/87882802/185768997-190275a3-583b-4859-b43c-5037bb15b9c8.png)
![image](https://user-images.githubusercontent.com/87882802/185769000-733b9404-4ae6-44f7-a12c-92fc38a02324.png)
![image](https://user-images.githubusercontent.com/87882802/185769002-4e8b4e5d-436e-46fc-b0a9-3c23e903dfd1.png)
![image](https://user-images.githubusercontent.com/87882802/185769003-6ebeec97-09b6-4499-86f2-a43f2d4980f6.png)
![image](https://user-images.githubusercontent.com/87882802/185769006-5a3cbf09-db5c-4dec-9e4f-b85c3a73e17c.png)
![image](https://user-images.githubusercontent.com/87882802/185769007-17e972d4-f9e6-48e1-a6c4-245b06d99a3a.png)
![image](https://user-images.githubusercontent.com/87882802/185769009-5bd3cfdb-72f5-4338-aa36-094f3e1d9898.png)

Continuaremos con la implementación de la Búsqueda BSF

- Primero creamos un array, en este caso será de 100 ya que no crearemos un grafo mayor a este tamaño, lo utilizaremos para saber que nodos fueron visitados.
      
	             static boolean[] visitBSF = new boolean[100]; 
    
- Creamos un metodo llamado BSF con entrada grafo.
      
	             public static void BSF(Grafo grafo) {
    
- Al igual que con el otro método llamaremos a la cantidad de vértices con false, en nuestro array visitBSF
      
		              for (int i = 0;i < grafo.lista.size();i++) {
                           visitBSF[i] = false;
                      }
        
- Recorreemos los vertices del grafo y si, en su array de visit encontramos false nos dirigiremos al metodo VisitarBSF.
      
		              for(int j = 0;j < grafo.lista.size();j++) {
			              if(visitBSF[j] == false) {
				             VisitarBSF(grafo,j);
			             }
		              }
            	}

- El Metodo visitarBSF para el cual tendremos como entrada el grafo y el vertice
    
	            public static void VisitarBSF(Grafo grafo,int pos) {
    
- Primero el vértice en la posición será cambiado por true, el cual significara que fue recorrido.
             
		               visitBSF[pos] = true;
		               System.out.print(pos);
		               for(int a : grafo.lista.get(pos)) {
        
- Veremos los vecinos del vértice, y en caso sean false lo cambiaremos a true para que signifique que fue visitado.
- Luego de todo ello iremos a uno de los vecinos del vértice.
                   
			              if (visitBSF[a] == false) {
				             System.out.print(a);
				             visitBSF[a] = true;
			              }	
		              }
		             for(int b : grafo.lista.get(pos)) {
        
- Luego de ellos empezaremos a recorrer pero los vecinos del vértice anterior.

			            if (visitBSF[b] == true) {
				            VisitarBSF(grafo,b);		
			            }
		            }	
	             }

•	Ejemplo:

![image](https://user-images.githubusercontent.com/87882802/185769013-5b9b80c2-29c7-4ef7-b5a7-803d42a275eb.png)

- El grafo al que se le encontro  su busqueda BSF es el siguiente:

![image](https://user-images.githubusercontent.com/87882802/185769018-7df85658-5538-4d8d-aa35-ce0884d0b652.png)
![image](https://user-images.githubusercontent.com/87882802/185769020-c066cb00-27a3-4172-8d9f-58df72ec7a26.png)
![image](https://user-images.githubusercontent.com/87882802/185769021-d0cdbc8e-f735-4ded-9ea8-02118fda9ebd.png)
![image](https://user-images.githubusercontent.com/87882802/185769023-9b17d6ce-e230-4cd7-aee0-1786bd6d6066.png)
![image](https://user-images.githubusercontent.com/87882802/185769024-fcce04df-ff2a-4910-8488-553e2b55ec8f.png)
![image](https://user-images.githubusercontent.com/87882802/185769025-f8641dcf-bb45-4f95-ae51-3e2a7356a426.png)
![image](https://user-images.githubusercontent.com/87882802/185769026-911d6def-cc19-44a2-9c8f-542422ab0391.png)
![image](https://user-images.githubusercontent.com/87882802/185769027-03a50a13-4669-4b69-a5b6-c313513703c2.png)
![image](https://user-images.githubusercontent.com/87882802/185769028-b783fa6f-8bed-458d-9492-f7e73ab233a5.png)
![image](https://user-images.githubusercontent.com/87882802/185769029-f7c4a3ff-0b3e-4ef8-b4f2-c07dddd6cc3d.png)
                               

•	Solucionar el siguiente ejercicio: 
- El grafo de palabras se define de la siguiente manera: cada vértice es una palabra
- en el idioma inglés y dos palabras son adyacentes si difieren exactamente en una
- posición. Por ejemplo, las cords y los corps son adyacentes, mientras que los
- corps y crops no lo son.
- a) Dibuje el grafo definido por las siguientes palabras: words cords corps coops
crops drops drips grips gripe grape graph

 ![image](https://user-images.githubusercontent.com/87882802/185769031-3649f9cf-167d-47c3-92a0-d8152962f8b8.png)

- b) Mostrar la lista de adyacencia del grafo.
 
![image](https://user-images.githubusercontent.com/87882802/185769035-0662830f-69fe-4fbd-83ac-a75a840f783f.png)

- Realizar un método en la clase Grafo. Este método permitirá saber si un grafo está incluido en otro. Los parámetros de entrada son 2 grafos y la salida del método es true si hay inclusión y false el caso contrario. (4 puntos)
- Veremos el método en el que encontraremos un grafo dentro de otro grafo.
- Primero crearemos el array boolean de 100, con los string val1 y val2.

	            static boolean[] igual = new boolean[100];
	            static String val1 = "";
	            static String val2 = "";
    
- Creamos el método Inclusion donde ingresaremos los métodos a comprobar, los parámetros de ingreso son el grafo 2 que se vera si esta dentro del grafo 1.

	            public static boolean Inclusion(Grafo grafo1, Grafo grafo2) {
			         igual[i] = false; este Boolean nos servira para saber si esa vertice es igual
            
- Crearemos los for primero el del grafo2 porque sera con el que comprobaremos y
- luego el grafo1 que sera con el que se comprobara uno por uno si se le encuentra igual que en el grafo2.

		             for (int i = 0;i < grafo2.lista.size();i++) {
			             for (int j = 0;j < grafo1.lista.size();j++) {
            
- Con este for guardaremos todos los valores de los vecinos del grafo 2 dentro del val1.
                          
				              for(int a: grafo2.lista.get(i)) {
					              val1 += a;
		                      }  
                
- Con este for guardaremos todos los valores de los vecinos del grafo1.
                          
				              for (int b: grafo1.lista.get(j)) {
	                              val2 += b;
                    
- En caso los valores de los vecinos del grafo 1 y dos sean igual guardaremos true en el boolean, en caso no seas así probaremos con los valores del siguiente vértice del grafo1.
                                
					             if(val1.equals(val2)) {
						            igual[i] = true;
						            break;					
                                 }
                              }
                        
- Terminando con el primer vértice volveremos los valores nuevamente vacíos.
                
				              val2="";
				              val1="";
			              }
		              }
        
- Al terminar ambos for nos dirigiremos al método comprobar.

		              return comprobar(igual,grafo2);
	               }

- El metodo comprobar tiene como parámetros de entrada el array Boolean y el Segundo grafo.

                	public static boolean comprobar(boolean[] a,Grafo b) {
		                int j = 0,k = 0; Tendremos dos variables j y k con inicios de cero.
        
- Creamos un for del tamaño de los vértices del grabo b.
             
		                for (int i = 0;i < b.lista.size();i++) {
			               k++; k tendrá que llegar al tamaño de los vértices del grafo b.
			               if(a[i] == true) {
				               j++; j llegara al tamaño de los valores del array que son true.
			               }
		                }
		               if(k == j) { Si el tamaño de los vértices del grafo y del array son iguales devolveremos true en caso contrario devolverá  false.
			             return true;
		               }
		               return false;
	                  }


- Ejemplo:

![image](https://user-images.githubusercontent.com/87882802/185769038-20db3132-1579-489b-af48-23df21eeb491.png)

## II.CUESTIONARIO:

-	¿Cuantas variantes del algoritmo de Dijkstra hay y cuál es la diferencia entre
ellas? 
-	Antonio Mauttone: se utilizó para el modelado del comportamiento de pasajeros en una red de transporte público. Así optimizar los pasajeros que recogerán en la distancia más corta.
-	Variante especializada: Cuando los pesos de arco son números enteros pequeños, las colas especializadas que aprovechan este hecho se pueden utilizar para acelerar el algoritmo de Dijkstra.
-	Algoritmo Dial: para gráficos con pesos de borde enteros positivos, que usa una cola de cubos para obtener un tiempo de ejecución.
-	Algoritmo Ahuja: nuevo montón de radix y el conocido montón de Fibonacci se ejecuta en el tiempo. 
-	Algoritmo Dijkstra con parámetros de optimización dinámicos:  tiene en cuenta la variabilidad de los costes en función del momento del viaje en el que se planea atravesar cierto arco.

-	Investigue sobre los ALGORITMOS DE CAMINOS MINIMOS e indique, ¿Qué similitudes encuentra, qué diferencias, en qué casos utilizar y por qué? 
- La mayor similitud que se encuentra en estos algoritmos es que buscan la ruta más corta para llegar a su destino, en las diferencias se encuentra el resultado que deseemos encontrar y esto se dará dependiendo al algoritmo que utilicemos.
- Por ejemplo, el algoritmo de Dijkstra, resuelve la distancia más corta desde un punto de origen hacia los demás vértices. El algoritmo de Floyd resuelve el camino más corto entre todos los nodos. Y el de Johnson permite que problema de los caminos más cortos entre todos los nodos y puede ser más rápido que el de en grafos de baja densidad.

 ##  III.BIBLIOGRAFIA:

-	Weiss M., Data Structures & Problem Solving Using Java, 2010, Addison-Wesley.
-	Escuela de Pedagogía en Educación Matemática, Marcelino Álvarez, et.al.,
-	http://repobib.ubiobio.cl/jspui/bitstream/123456789/1953/3/Alvarez_Nunez_Marcelino.pdf
-	http://www.oia.unsam.edu.ar/wp-content/uploads/2017/11/dijkstra-prim.pdf

 

