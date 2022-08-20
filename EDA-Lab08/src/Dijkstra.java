
public class Dijkstra {	
	
	static boolean[] visitDij = new boolean[100]; 
	static String[] camino = new String[100];
	static Integer[] distancia = new Integer[100]; 
	
	public static void Dijkstra(Grafo grafo) {		
		for (int i = 0;i < grafo.lista.size();i++) {
            visitDij[i] = false;
        }
		for(int j = 0;j < grafo.lista.size();j++) {
			if(visitDij[j] == false) {
				VisitarDij(grafo,j);
			}
		}
	}
	
	public static void VisitarDij(Grafo grafo,int pos) {
	    visitDij[pos] = true;
		System.out.print(pos);
		for(int a : grafo.lista.get(pos)) {
			if (visitDij[a] == false) {
				System.out.print(a);
				visitDij[a] = true;
			}	
		}	
		for(int b : grafo.lista.get(pos)) {
			if (visitDij[b] == false) {
				VisitarDij(grafo,b);		
			}
		}
	}
	
    public static void Imprimir(Grafo grafo,int pos){
        visitDij[pos] = true;
        int n = grafo.lista.size();
        for(int dest: grafo.lista.get(pos)) {
            System.out.print("(" + pos + " ——> " + dest + ")  distancia: ");
        }
            System.out.println();
            
    }
}
