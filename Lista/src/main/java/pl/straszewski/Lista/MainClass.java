package pl.straszewski.Lista;

public class MainClass {
	public static void main(String[] args) {

		Lista tab = new Lista(8);
		tab.dodajElement(2);
		tab.dodajElement(2);
		tab.dodajElement(5);
		tab.dodajElement(7);
		tab.dodajElement(5);
		tab.dodajElement(6);
		tab.dodajElement(7);
		tab.dodajElement(8);

		// System.out.println(Arrays.toString(tab.liczby));
		// System.out.println(tab.znajdz(7));
		tab.usunPierwszy(10);
		// tab.usunPierwszy(5);
		// tab.usunPierwszy(6);

		tab.pisz();
		tab.zapiszDoPliku("Lista2.txt");

	}
}
