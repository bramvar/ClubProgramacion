package SegmentTree.Exercices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RMQ_HackerEarth {

	static int[] arr;
	static int[] sT;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int Q = Integer.parseInt(stk.nextToken());	
		
		arr= new int[N];
		sT = new int[4*N];	
		
//		Arrays.fill(sT, Integer.MAX_VALUE);
		
		stk = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) 
			arr[i]= Integer.parseInt(stk.nextToken());
		
		construirST(1, 0,arr.length-1);	

//		System.out.print("sT: ");
//		System.out.println("\n"+Arrays.toString(sT));
//		
		for (int i = 0; i < Q; i++) {
			stk = new StringTokenizer(in.readLine());
			
			char accion = stk.nextToken().charAt(0);
			int L = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			
			
			if(accion == 'q'){				
				out.write(buscar2(1, 0, arr.length-1, L-1, R-1)+"\n");
			}else {
				actualizar(1, 0, arr.length-1, L-1, R);
//				System.out.print("sT: ");
//				System.out.println(Arrays.toString(sT));
			}
			
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

	private static void actualizar(int nodoActual, int actualIzq, int actualDer, int indice_buscado, int valor){
		if(actualIzq == actualDer){
			arr[indice_buscado] = valor;
			sT[nodoActual] = valor;
		}else {
			int mid = (actualIzq + actualDer) / 2;
			if(actualIzq <= indice_buscado && indice_buscado <= mid){
				actualizar(2*nodoActual, actualIzq, mid, indice_buscado, valor);
			}else{
				actualizar(2*nodoActual+1, mid+1, actualDer, indice_buscado, valor);
			}
		sT[nodoActual] = Math.min(sT[2*nodoActual] , sT[2*nodoActual+1]);
		}
	}
	
	
	private static int buscar2(int indice, int actualIzq, int actualDer, int qs, int qe){
		
//		System.out.println("indice: "+indice+" Ai: "+actualIzq+" Ad: "+actualDer +" Rango "+qs+"-"+qe);
		
		if(actualIzq>= qs && actualDer<= qe){
			//Adentro
			return sT[indice];
		}else if( qe <actualIzq || qs>actualDer){
			//Afuera
			return Integer.MAX_VALUE;
		}else{
			int mid = (actualIzq + actualDer) / 2;
			return Math.min(buscar2(2*indice, actualIzq, mid, qs, qe), buscar2(2*indice+1, mid+1, actualDer, qs, qe));	
		}
		
		
	}
		  
	
	
	


}
