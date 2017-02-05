package pl.straszewski.zamowienie;

import java.io.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

		Pozycja p1 = new Pozycja("Chleb", 4, 12.0);
		Pozycja p2 = new Pozycja("Chleb", 6, 8.0);
		Pozycja p3 = new Pozycja("Ryz", 13, 6.2);
		Pozycja p4 = new Pozycja("Kawa", 2, 8.0);
		Pozycja p5 = new Pozycja("Czekolada", 5, 8.0);
		Pozycja p6 = new Pozycja("Sól", 1, 2.75);

		Zamowienie z = new Zamowienie();
		z.dodajPozycje(p1);
		z.dodajPozycje(p2);
		z.dodajPozycje(p3);
		z.dodajPozycje(p4);
		z.dodajPozycje(p5);
		z.dodajPozycje(p6);

		// z.usunPozycje(1);
		// z.edytujPozycje(2, "Jab³ka", 20, 1.15);

		System.out.println(z);

		//z.usunPozycje(1);
		//z.edytujPozycje(2, "Jab³ka", 20, 1.15);

		Zamowienie.zapiszZamowienie(z, "test.ser");
		z.usunPozycje(1);
		System.out.println(z);
		z = Zamowienie.wczytajZamowienie("test.ser");
		System.out.println(z);
	
	
	}

}
