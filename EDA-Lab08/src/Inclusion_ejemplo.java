import java.util.Arrays;
import java.util.List;
public class Inclusion_ejemplo {
	public static void main(String[] args) {
		 List<Datos> newgrafo1 = Arrays.asList(new Datos(1,0, 2), new Datos(1,0, 1),
	                new Datos(1,1, 2), new Datos(1,1, 3), new Datos(1,1, 0),
	                new Datos(1,2, 1), new Datos(1,2, 0),
	                new Datos(1,3, 1), new Datos(1,3, 2), new Datos(1,2, 4)
	                ,new Datos(1,4, 5), new Datos(1,4, 2), new Datos(1,4, 6));
	        
	        List<Datos> newgrafo2 = Arrays.asList(new Datos(1,0, 2), new Datos(1,0, 1),
	                new Datos(1,1, 2), new Datos(1,1, 3), new Datos(1,1, 0),
	                new Datos(1,2, 1), new Datos(1,3, 2));
	        
	        List<Datos> newgrafo3 = Arrays.asList(new Datos(1,0, 2), new Datos(1,0, 1),
	                new Datos(1,1, 2), new Datos(1,1, 3), new Datos(1,1, 0),
	                new Datos(1,2, 1), new Datos(1,2, 3), new Datos(1,3, 2));
	        
	        Grafo grafo1 = new Grafo(newgrafo1);
	        Grafo grafo2 = new Grafo(newgrafo2);
	        Grafo grafo3 = new Grafo(newgrafo3);
	        Grafo.Imprimir(grafo1);
	        Grafo.Imprimir(grafo2);
	        System.out.println("");
	        Grafo.Imprimir(grafo3);
	        System.out.println("");
	        System.out.println("El segundo grafo esta dentro del primer grafo: "+ Grafo.Inclusion(grafo1, grafo2));
	        System.out.println("");
	        System.out.println("El grafo 3 tiene la arista de 2 a 3, la cual no tiene el grafo 1");
	        System.out.println("El segundo grafo esta dentro del primer grafo: "+ Grafo.Inclusion(grafo1, grafo3));
	}

}
