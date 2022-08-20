import java.util.Arrays;
import java.util.List;

public class DFS_ejemplo {

	public static void main(String[] args) {
		 List<Datos> newgrafo1 = Arrays.asList(
				    new Datos(1,0, 1), new Datos(1,0, 2), new Datos(1,0, 3), new Datos(1,0, 4),
	                new Datos(1,1, 0), new Datos(1,1, 2),
	                new Datos(1,2, 1), new Datos(1,2, 0), new Datos(1,2, 3), new Datos(1,2, 4),
	                new Datos(1,3, 1), new Datos(1,3, 2),
	                new Datos(1,4, 2), new Datos(1,4, 0));

	        Grafo grafo1 = new Grafo(newgrafo1);
	        Grafo.Imprimir(grafo1);
	        System.out.println("Busqueda DFS: ");
	        Grafo.DFS(grafo1);

	}

}
