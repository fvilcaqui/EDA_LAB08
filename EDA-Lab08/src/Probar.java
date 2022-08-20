import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Probar {
	
	public static void main (String[] args){
        List<Datos> grafo = Arrays.asList(new Datos(1,0, 2), new Datos(1,0, 1),
                new Datos(1,1, 2), new Datos(1,1, 3), new Datos(1,1, 0),
                new Datos(1,2, 1), new Datos(1,2, 3), new Datos(1,2, 0),
                new Datos(1,3, 1), new Datos(1,3, 2), new Datos(1,2, 4)
                ,new Datos(1,4, 5), new Datos(1,4, 2), new Datos(1,4, 6));
   
        Grafo grafo1 = new Grafo(grafo);
        Grafo.Imprimir(grafo1);
    
	}	

}
