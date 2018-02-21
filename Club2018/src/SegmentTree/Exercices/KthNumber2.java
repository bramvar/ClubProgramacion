package SegmentTree.Exercices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * Problem Kth - Number
 * Source: https://www.hackerrank.com/contests/morgan-stanley-2015/challenges/wet-shark-and-kth-largest-number
 * @author Camilo Barrios - <groovy.kmilo@gmail.com>
 *	
 */


public class KthNumber2 {

	static int max_size = ((int) 1e5) + 2;

	static int[] arr;
	
	static LinkedList<Integer>[] indices;
	
	static Nodo[] x;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(stk.nextToken());
		int Q = Integer.parseInt(stk.nextToken());	

		arr= new int[max_size];
		indices = new LinkedList[max_size];
		x = new Nodo[max_size];
		
		for (int i = 0; i < indices.length; i++) {
			indices[i]= new LinkedList<>();
		}

		stk = new StringTokenizer(in.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i]= Integer.parseInt(stk.nextToken());
			indices[arr[i]].addLast(i);
		}
	 
		Nodo root = new Nodo (null, null, 0);
		
		
	    x[100001]=root; 
	    
	    for (int i=100000; i>=1; i--){
	        x[i]=x[i+1]; 
	        for (int y=0; y<indices[i].size(); y++){
	            x[i]=agregar(1, 100000, x[i], indices[i].get(y)); 
	        }
	    }
	    
	    System.out.println(Arrays.toString(x));
	    
		for (int i = 0; i < Q; i++) {
			stk = new StringTokenizer(in.readLine());
			
			int L = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
			
			
			out.write(arr[buscar(1, 100000, x[L], K)]+"\n");
		}
	
	    
	  in.close();
	  out.close();
	    

	}
	
	static Nodo agregar (int inicio, int fin, Nodo  r, int num){

		if (inicio<=num && fin>=num){

			if (r==null) 
				r=new Nodo (null, null, 0); 
			if (inicio==fin){
				return new Nodo (r.izq, r.der, r.apariciones+1); 
			}
			Nodo n=agregar(inicio, (inicio+fin)/2, r.izq, num);
			Nodo m=agregar((inicio+fin)/2+1, fin, r.der, num);

			int z= (n==null)?0:n.apariciones;
			int zz=(m==null)?0:m.apariciones;
			return new Nodo (n, m, z+zz); 
		}
		return r; 
	}

	static int buscar (int start, int end, Nodo a, int kth){

		if (start==end) 
			return start;
		int z=(a.izq==null)?0:a.izq.apariciones; 

		if (z>=kth){
			return buscar(start, (start+end)/2, a.izq, kth); 
		}
		else 
			return buscar((start+end)/2+1, end, a.der, kth-z); 
	}



	static class Nodo{
		Nodo izq; 
		Nodo der; 
		int apariciones; 

		public Nodo (Nodo izq, Nodo der, int valor){
			this.izq=izq; 
			this.der=der; 
			apariciones=valor;
		}
		

		public String toString() {
			return apariciones+"";
		}


	}




}
