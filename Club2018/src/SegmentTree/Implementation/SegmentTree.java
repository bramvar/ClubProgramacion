package SegmentTree.Implementation;

import java.util.Arrays;

public class SegmentTree {

	private static int[] arr = {1,2,3,4,5,6,7};
	static int[] sT;

	public static void main(String[] args) {


		sT = new int[16];	
		construirST(1, 0,arr.length-1);	

		System.out.println(Arrays.toString(sT));
		

	}


	private static void construirST(int indice, int izq, int der) {

		if(izq == der){
			sT[indice] = arr[izq];
		}else{
			int mid = (izq + der) / 2;
			construirST(2*indice, izq, mid);
			construirST(2*indice+1, mid+1, der);
			sT[indice] = sT[2*indice] + sT[2*indice+1];
		}
	}

	private static void actualizar(int nodo, int inicio, int fin, int indice, int valor){
		if(inicio == fin){
			arr[indice] += valor;
			sT[nodo] += valor;
		}else {
			int mid = (inicio + fin) / 2;
			if(inicio <= indice && indice <= mid){
				actualizar(2*nodo, inicio, mid, indice, valor);
			}else{
				actualizar(2*nodo+1, mid+1, fin, indice, valor);
			}
		sT[nodo] = sT[2*nodo] + sT[2*nodo+1];
		}
	}
	
	
	private static int buscar(int nodo, int incio, int fin, int izq, int der){
	    if(der < incio || fin < izq){
	        return 0;
	    }
	    if(izq <= incio && fin <= der){
	        return sT[nodo];
	    }
	    int mid = (incio + fin) / 2;
	    int p1 = buscar(2*nodo, incio, mid, izq, der);
	    int p2 = buscar(2*nodo+1, mid+1, fin, izq, der);
	    return (p1 + p2);
	}
	
	


}
