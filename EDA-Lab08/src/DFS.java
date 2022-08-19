import java.util.List;

public class DFS {
	int temp,n,m;
	boolean[] visit = new boolean[n];
	Integer[] d = new Integer[m];
	Integer[] f = new Integer[m];

	public void DFS(Grafo grafo) {
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
	
	public void Visitar(Grafo grafo ,int temp,int pos) {
		visit[pos] = true;
		temp = temp + 1;
		d[pos] = temp; 
		for(int a : grafo.lista.get(pos)) {
			if (visit[a] == false) {
				Visitar(grafo,temp,a);
			}		
		}
		temp = temp + 1;
		f[pos] = temp;
	} 
}
