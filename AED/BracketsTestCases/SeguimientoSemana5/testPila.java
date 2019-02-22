package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pila.*;

public class testPila{
	
	private IPila<Integer> pila;
	private IPila<String> pila2;
	private IPila<Character> pila3;
	private IPila<Boolean> pila4;
	
	public void setUpEscenario1() {
		pila = new Pila<Integer>();
		pila.apilar(1);
		pila.apilar(10);
		pila.apilar(100);
		pila.apilar(-1);
		pila.apilar(-10);
		pila.apilar(-11);
		pila.apilar(12);
		pila.apilar(21);
		pila.apilar(122);
	}
	
	public void setUpEscenario2() {
		pila2 = new Pila<String>();
		pila2.apilar("Andres Aristizabal");
		pila2.apilar("Juan Reyes");
		pila2.apilar("Camilo Barrios");
		pila2.apilar("Karen Lara");
		pila2.apilar("Liliana Franco");
		pila2.apilar("Victor Vargas");
		pila2.apilar("Cristian Sanchez");
	}
	
	public void setUpEscenario3() {
		pila3 = new Pila<Character>();
		
		pila3.apilar('A');
		pila3.apilar('E');
		pila3.apilar('I');
		pila3.apilar('O');
		pila3.apilar('U');
		
	}
	
	public void setUpEscenario4() {
		pila4 = new Pila<Boolean>();
		
		pila4.apilar(true);
		pila4.apilar(true);
		pila4.apilar(true);
		pila4.apilar(true);
		pila4.apilar(true);
		pila4.apilar(false);
		
	}
	

	

	@Test
	void test01() {
		setUpEscenario1();
		assertFalse(pila.estaVacia());
	}
	
	@Test
	void test02() {
		setUpEscenario1();
		boolean prueba = true;
		assertTrue(pila.consultar()==122);
		pila.desapilar();
		pila.desapilar();
		pila.desapilar();
		assertTrue(pila.consultar()==-11);
		pila.desapilar();
		assertTrue(pila.desapilar()==-10);
		pila.apilar(44);
		assertTrue(pila.desapilar()==44);
		assertTrue(pila.desapilar()==-1);
		assertTrue(prueba);
	}
	
	@Test
	void test03() {
		setUpEscenario1();
		assertTrue(pila.desapilar()==122);
		assertTrue(pila.desapilar()==21);
		assertTrue(pila.desapilar()==12);
		assertTrue(pila.desapilar()==-11);
		assertTrue(pila.desapilar()==-10);
		assertTrue(pila.desapilar()==-1);
		assertTrue(pila.desapilar()==100);
		assertTrue(pila.desapilar()==10);
		assertTrue(pila.desapilar()==1);
		assertTrue(pila.estaVacia());

	}
	
	@Test
	void test04() {
		setUpEscenario2();
		assertTrue(pila2.desapilar().equals("Cristian Sanchez"));
		pila2.apilar(null);
		assertNull(pila2.desapilar());
	}
	
	@Test
	void test05() {
		setUpEscenario2();
		assertTrue(pila2.desapilar().equals("Cristian Sanchez"));
		assertTrue(pila2.desapilar().equals("Victor Vargas"));
		assertTrue(pila2.desapilar().equals("Liliana Franco"));
		assertTrue(pila2.desapilar().equals("Karen Lara"));
		assertTrue(pila2.desapilar().equals("Camilo Barrios"));
		assertTrue(pila2.desapilar().equals("Juan Reyes"));
		assertTrue(pila2.desapilar().equals("Andres Aristizabal"));
		
	}
	
	@Test
	void test06() {
		setUpEscenario2();
		pila2.apilar(null);
		assertNull(pila2.consultar());
		assertNull(pila2.desapilar());
		pila2.apilar("AED");
		assertTrue(pila2.consultar().equals("AED"));
		assertTrue(pila2.desapilar().equals("AED"));
	}
	
	@Test
	void test07() {
		setUpEscenario3();
		assertTrue(pila3.desapilar()=='U');
		assertTrue(pila3.desapilar()=='O');
		assertTrue(pila3.desapilar()=='I');
		assertTrue(pila3.desapilar()=='E');
		assertTrue(pila3.desapilar()=='A');
		assertTrue(pila3.estaVacia());
		pila3.apilar('l');
		assertTrue(pila3.consultar()=='l');
		assertTrue(pila3.desapilar()=='l');
		assertTrue(pila3.estaVacia());
	}
	
	@Test
	void test08() {
		setUpEscenario3();
		pila3.apilar((char)35);
		pila3.apilar((char)122);
		pila3.apilar((char)54);
		pila3.desapilar();
		pila3.desapilar();
		pila3.apilar((char)64);
		pila3.apilar((char)64);
		pila3.apilar((char)12);
		pila3.apilar((char)44);
		pila3.desapilar();
		pila3.desapilar();
		assertTrue(pila3.consultar()== (char)64);
		
	}
	
	@Test
	void test09() {
		setUpEscenario4();
		assertFalse(pila4.estaVacia());
		assertFalse(pila4.desapilar());
		assertTrue(pila4.desapilar());
		assertTrue(pila4.desapilar());
		pila4.desapilar();
		pila4.desapilar();
		pila4.desapilar();
		assertNull(pila4.desapilar());
	}
	
	@Test
	void test10() {
		setUpEscenario4();
		assertFalse(pila4.estaVacia());
		assertFalse(pila4.desapilar());
		assertTrue(pila4.desapilar());
		assertTrue(pila4.consultar());
		assertTrue(pila4.desapilar());
		assertTrue(pila4.consultar());
		assertTrue(pila4.desapilar());
		assertTrue(pila4.consultar());
		assertTrue(pila4.desapilar());
		assertTrue(pila4.consultar());
		assertTrue(pila4.desapilar());
		assertTrue(pila4.estaVacia());
		assertNull(pila4.consultar());
	}

}
