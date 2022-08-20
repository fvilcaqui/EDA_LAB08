import java.util.List;

public class DFS {
	// Aqui se puede apreciar solo el algoritmo.

	static boolean[] visit = new boolean[100];
	public static void DFS(Grafo grafo) {
		for (int i = 0;i < grafo.lista.size();i++) {
            visit[i] = false;
        }
		for(int j = 0;j < grafo.lista.size();j++) {
			if(visit[j] == false) {
				Visitar(grafo,j);
			}
		}
	}	
	public static void Visitar(Grafo grafo,int pos) {
		visit[pos] = true;
		System.out.println(pos);
		for(int a : grafo.lista.get(pos)) {
			if (visit[a] == false) {
				System.out.println("a" + a);
				Visitar(grafo,a);
			}		
		}
	}
	
}
