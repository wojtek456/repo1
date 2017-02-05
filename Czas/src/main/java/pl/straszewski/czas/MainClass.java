package pl.straszewski.czas;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

		Czas t1 = new Czas("12 h 56 min");
		Czas t2 = new Czas(7, 12);
		System.out.println("t1: " + t1);
		System.out.println("t2: " + t2);
		System.out.println("t1 + t2: " + t1.dodaj(t2));
		System.out.println("t1 - t2: " + t1.odejmij(t2));
		System.out.println("t1 x 3: " + t1.pomnoz(3));
		Czas[] tab = { t1, t2, t1, t2 };
		System.out.println("suma 2xt1 + 2xt2: " + Czas.sumuj(tab, 4));



	}

}
