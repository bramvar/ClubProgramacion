package SegmentTree.Implementation;

import java.util.*;

public class Trie {




	public static void main(String[] args) {



		TrieNode raiz = new TrieNode('0');
		
		


	}



	static class TrieNode{

		char letra;
		Map<Character,TrieNode> nodos;


		public TrieNode(char letra) {
			this.letra = letra;
			nodos = new HashMap<>();
		}

	}


	private static void agregar(TrieNode raiz, String s) {

		TrieNode actual = raiz;
		char c;

		for (int i=0;i<s.length();i++){
			c = s.charAt(i);
			if (!actual.nodos.containsKey(c)){
				actual.nodos.put(c,new TrieNode(c));
			}

			actual = actual.nodos.get(c);


		}

	}
	
	
	private boolean existe(TrieNode raiz, String s){
		
		TrieNode actual = raiz;
		char c;

		for (int i=0;i<s.length();i++){
			c = s.charAt(i);
			if (!actual.nodos.containsKey(c)){
				return false;
			}else {
				actual = actual.nodos.get(c);
			}

		}
		return true;
	}
}
