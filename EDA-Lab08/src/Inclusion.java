
public class Inclusion {
	static boolean[] igual = new boolean[100];

	public static void Inclusion(Grafo grafo1, Grafo grafo2) {
		int cant = 0,cant2 = 0;
		for (int i = 0;i < grafo2.lista.size();i++) {
			for (int j = 0;j < grafo1.lista.size();j++) {
				for (int a: grafo2.lista.get(i)) {
					cant2++;
					for (int b: grafo1.lista.get(j)) {
		                if(a == b) {
		                	cant ++ ;
		                }
		            }
	            }
			}
			if(cant == cant2) {
				igual[i] = true;
			}
		}
	}
	
	public static boolean comprobar(boolean[] a,Grafo b) {
		int j = 0,k=0;
		for (int i = 0;i < b.lista.size();i++) {
			k++;
			if(a[i] == true) {
				j++;
			}
		}
		if(j==k) {
			return true;
		}
		return false;
	}
	
}
