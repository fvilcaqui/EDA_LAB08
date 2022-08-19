import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Probar {
	
	public static void main (String[] args){
        List<Datos> grafo = Arrays.asList(new Datos(0, 1), new Datos(1, 2),
                new Datos(2, 0), new Datos(2, 1), new Datos(3, 2),
                new Datos(4, 5), new Datos(5, 4));
        Grafo grafo1 = new Grafo(grafo);
        Grafo.Imprimir(grafo1);
    }

}
