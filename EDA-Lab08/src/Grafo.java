import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grafo {

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
    
	static int temp,n,m;
	static boolean[] visit = new boolean[100];
	static Integer[] d = new Integer[100];
	static Integer[] f = new Integer[100];

	public static void DFS(Grafo grafo) {
		for (int i = 0;i < grafo.lista.size();i++) {
            visit[i] = false;
        }
		temp = 0;
		for(int j = 0;j < grafo.lista.size();j++) {
			if(visit[j] == false) {
				Visitar(grafo,temp,j);
			}
		}
	}
	
	public static void Visitar(Grafo grafo ,int temp,int pos) {
		visit[pos] = true;
		System.out.println(pos);
		temp = temp + 1;
		d[pos] = temp; 
		for(int a : grafo.lista.get(pos)) {
			if (visit[a] == false) {
				System.out.println("a" + a);
				Visitar(grafo,temp,a);
			}		
		}
		temp = temp + 1;
		f[pos] = temp;
	} 
}
