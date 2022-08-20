import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grafo {

// La creacion del grafo
    List<List<Integer>> lista = new ArrayList<>();
   
    public Grafo(List<Datos> valores){
        int n = 0; 
        for (Datos e: valores) {
            n = Integer.max(n, Integer.max(e.init, e.fin));
        }
        for (int i = 0; i <= n; i++){
            lista.add(i, new ArrayList<>());
        }
        for (Datos current: valores){
            lista.get(current.init).add(current.fin);
         }
    }
 
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
    
 //Impletementando la busqueda DFS   
	static boolean[] visitDFS = new boolean[100];

	public static void DFS(Grafo grafo) {
		for (int i = 0;i < grafo.lista.size();i++) {
            visitDFS[i] = false;
        }
		for(int j = 0;j < grafo.lista.size();j++) {
			if(visitDFS[j] == false) {
				VisitarDFS(grafo,j);
			}
		}
	}
	
	public static void VisitarDFS(Grafo grafo,int pos) {
		visitDFS[pos] = true;
		System.out.println(pos);
		for(int a : grafo.lista.get(pos)) {
			if (visitDFS[a] == false) {
				System.out.println("a" + a);
				VisitarDFS(grafo,a);
			}		
		}
	}
	
// Implementando la busqueda BSF	
	static boolean[] visitBSF = new boolean[100]; 
	
	public static void BSF(Grafo grafo) {
		for (int i = 0;i < grafo.lista.size();i++) {
            visitBSF[i] = false;
        }
		for(int j = 0;j < grafo.lista.size();j++) {
			if(visitBSF[j] == false) {
				VisitarBSF(grafo,j);
			}
		}
	}
	
	public static void VisitarBSF(Grafo grafo,int pos) {
		visitBSF[pos] = true;
		System.out.print(pos);
		for(int a : grafo.lista.get(pos)) {
			if (visitBSF[a] == false) {
				System.out.print(a);
				visitBSF[a] = true;
			}	
		}
		for(int b : grafo.lista.get(pos)) {
			if (visitBSF[b] == false) {
				VisitarBSF(grafo,b);		
			}
		}
		
	} 
}
