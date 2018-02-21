package SegmentTree.Exercices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * Problem Kth - Number
 * Source: https://www.hackerrank.com/contests/morgan-stanley-2015/challenges/wet-shark-and-kth-largest-number
 * @author Camilo Barrios - <groovy.kmilo@gmail.com>
 *	
 */


public class KthNumber {
	
	static int max_size = ((int) 1e5) +1;

	static int[] arr;

	static int[] sT; // Segment Tree
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int Q = Integer.parseInt(stk.nextToken());	
		
		arr= new int[max_size];
		sT = new int[max_size*4];
		
		int[] input = new int[N];
		
		stk = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N; i++) 
			input[i]= Integer.parseInt(stk.nextToken());
		
		construirST(1, 0, N-1);
		
		System.out.println(Arrays.toString(sT));
		
		
		for (int i = 0; i < Q; i++) {
			stk = new StringTokenizer(in.readLine());
			
			int L = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
			
			
		}
	
	
	}
	
	
	private static void construirST(int indice, int izq, int der) {

		if(izq == der){
			sT[indice] = arr[izq];
		}else{
			int mid = (izq + der) / 2;
			construirST(2*indice, izq, mid);
			construirST(2*indice+1, mid+1, der);
			
				if(sT[2*indice]>=sT[2*indice+1])
					sT[indice]=sT[2*indice];
				else
					sT[indice]=sT[2*indice+1];
		
		}
	}


}
