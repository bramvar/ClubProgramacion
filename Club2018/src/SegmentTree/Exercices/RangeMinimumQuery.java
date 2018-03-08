package SegmentTree.Exercices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RangeMinimumQuery {

	static int[] arr;
	static int[] sT;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());	
		
		arr= new int[N];
		sT = new int[4*N];	
		
//		Arrays.fill(sT, Integer.MAX_VALUE);
		
		stk = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) 
			arr[i]= Integer.parseInt(stk.nextToken());
		
		construirST(1, 0,arr.length-1);	

//		System.out.println(Arrays.toString(sT));
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(in.readLine());
			
			int L = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			
			out.write(buscar2(1, 0, arr.length, L, R)+"\n");
//			out.flush();
		}
		

		out.close();
		in.close();
		
		
		

	}


	private static void construirST(int indice, int izq, int der) {

		if(izq == der){
			sT[indice] = arr[izq];
		}else{
			int mid = (izq + der) / 2;
			construirST(2*indice, izq, mid);
			construirST(2*indice+1, mid+1, der);
			sT[indice]= Math.min(sT[2*indice], sT[2*indice+1]);

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
	    return Math.min(p1, p2);
	}
	
	private static int buscar2(int indice, int actualIzq, int actualDer, int qs, int qe){
		
		System.out.println("indice: "+indice+" inicio: "+qs+" fin: "+qe);
		
		if(actualIzq<= qs && actualDer<= qe){
			//Esta completamente en el rango
			return sT[indice];
		}else if(qs < actualIzq && qe <actualIzq || qs>actualDer && qe>actualDer ){
			return Integer.MAX_VALUE;
		}else{
			int mid = (qs + qe) / 2;
			return Math.min(buscar2(2*indice, actualIzq, actualDer, qs, mid), buscar2(2*indice+1, actualIzq, actualDer, mid+1, qe));	
		}
		
		
	}
		  
	
	
	


}
