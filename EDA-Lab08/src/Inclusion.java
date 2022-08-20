
public class Inclusion {
	static boolean[] igual = new boolean[100];
	static String val1 = "";
	static String val2 = "";
	public static boolean Inclusion(Grafo grafo1, Grafo grafo2) {
		for (int i = 0;i < grafo2.lista.size();i++) {
			for (int j = 0;j < grafo1.lista.size();j++) {
				for(int a: grafo2.lista.get(i)) {
					val1 += a;
		        } 
				for (int b: grafo1.lista.get(j)) {
	                val2 += b;
					if(val1.equals(val2)) {
						igual[i] = true;
					}
	            } 
				val2="";
				val1="";
			}
		}
		return comprobar(igual,grafo2);
	}
	
	public static boolean comprobar(boolean[] a,Grafo b) {
		int j = 0,k = 0;
		for (int i = 0;i < b.lista.size();i++) {
			k++;
			if(a[i] == true) {
				j++;
			}
		}
		System.out.println(j + " " + val2);
		if(k == j) {
			return true;
		}
		return false;
	}
}
