
public class BSF {
	
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
