package pl.straszewski.Lista;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListaTest {
	// **** testy poszczegolnych metod ****
	@Test
	public void testDodajElement() {
		Lista tab = new Lista(10);
		tab.dodajElement(2);
		tab.dodajElement(2);
		tab.dodajElement(5);
		tab.dodajElement(7);
		int[] expecteds = new int[] { 2, 2, 5, 7, 0, 0, 0, 0, 0, 0 };
		assertArrayEquals(expecteds, tab.getLiczby());

	}

	@Test
	public void testZnajdz() {
		Lista tab = new Lista(10);
		tab.dodajElement(2);
		tab.dodajElement(2);
		tab.dodajElement(5);
		tab.dodajElement(7);
		tab.dodajElement(5);
		tab.dodajElement(6);
		tab.dodajElement(7);
		tab.dodajElement(8);
		assertEquals("7 znajduje sie pod indeksem 3", 3, tab.znajdz(7));

	}

	@Test
	public void testUsunPierwszy() {
		Lista tab = new Lista(10);
		tab.dodajElement(2);
		tab.dodajElement(2);
		tab.dodajElement(5);
		tab.dodajElement(7);
		tab.dodajElement(5);

		tab.usunPierwszy(2);
		tab.usunPierwszy(5);

		int[] expecteds = new int[] { 2, 7, 5, 0, 0, 0, 0, 0, 0, 0 };
		assertArrayEquals(expecteds, tab.getLiczby());
		tab.usunPierwszy(5);
		int[] expecteds2 = new int[] { 2, 7, 0, 0, 0, 0, 0, 0, 0, 0 };
		assertArrayEquals(expecteds2, tab.getLiczby());
	}

	@Test
	public void testUsunPowtorzenia() {
		Lista tab = new Lista(10);
		tab.dodajElement(2);
		tab.dodajElement(2);
		tab.dodajElement(5);
		tab.dodajElement(7);
		tab.dodajElement(5);
		tab.dodajElement(9);
		tab.dodajElement(8);
		tab.dodajElement(7);
		tab.dodajElement(5);
		tab.dodajElement(9);
		tab.usunPowtorzenia();
		int[] expecteds = new int[] { 2, 8, 7, 5, 9, 0, 0, 0, 0, 0 };
		assertArrayEquals(expecteds, tab.getLiczby());
	}

	@Test
	public void testOdwroc() {
		Lista tab = new Lista(10);
		tab.dodajElement(2);
		tab.dodajElement(2);
		tab.dodajElement(5);
		tab.dodajElement(7);
		tab.dodajElement(5);
		tab.dodajElement(9);
		tab.dodajElement(8);
		tab.dodajElement(7);
		tab.dodajElement(5);
		tab.dodajElement(9);
		tab.odwroc();
		int[] expecteds = new int[] { 9, 5, 7, 8, 9, 5, 7, 5, 2, 2 };
		assertArrayEquals(expecteds, tab.getLiczby());

	}

	// **** test wielu metod na raz ****

	@Test
	public void testWieluMetod() {
		Lista tab = new Lista(10);
		tab.dodajElement(2);
		tab.dodajElement(2);
		tab.dodajElement(5);
		tab.dodajElement(7);
		tab.dodajElement(2);
		tab.dodajElement(9);
		tab.dodajElement(2);
		tab.dodajElement(7);
		tab.dodajElement(2);
		tab.dodajElement(9);
		tab.usunPierwszy(2);
		tab.usunPowtorzenia();
		tab.odwroc();
		int[] expecteds = new int[] { 9,2,7,5,0,0,0,0,0,0 };
		assertArrayEquals(expecteds, tab.getLiczby());

	}

}
