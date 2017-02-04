package pl.straszewski.Lista;

import java.io.BufferedWriter;
import java.io.*;

import java.util.Arrays;

public class Lista {

	int[] liczby;
	private int pojemnosc;
	private int rozmiar;

	public Lista(int rozmiarTablicy) {
		liczby = new int[rozmiarTablicy];
		pojemnosc = rozmiarTablicy;
		rozmiar = 0;

	}

	public void dodajElement(int liczba) {
		if (rozmiar < pojemnosc) {
			liczby[rozmiar] = liczba;
			rozmiar += 1;
		} else {

			System.out.println("** Nie mo¿na dodaæ wiêcej elementów, lista pe³na!** ");
		}
	}

	public int znajdz(int liczba) {
		int indeks = -1;
		for (int i = 0; i < rozmiar; i++) {
			if (liczby[i] == liczba) {
				indeks = i;
				return indeks;
			}
		}
		return indeks;
	}

	public void pisz() {

		StringBuilder text = new StringBuilder();
		text.append(String.format("%-10s %-12s %-20s", "rozmiar listy: " + rozmiar, "\npojemnoœæ listy: " + pojemnosc,
				"\nlista elementów tablicy:  "
						+ Arrays.toString(Arrays.copyOf(liczby, rozmiar)).replaceAll("\\[|\\]|,", "")));
		System.out.println(text.toString());
	}

	public void usunPierwszy(int liczba) {

		for (int i = 0; i < rozmiar; i++) {
			if (liczby[i] == liczba) {

				for (int k = i; k < pojemnosc - 1; k++) {
					liczby[k] = liczby[k + 1];
				}
				liczby[pojemnosc - 1] = 0;
				rozmiar -= 1;
				break;
			}

		}

	}

	public void usunPowtorzenia() {
		boolean var = false;
		int[] tablicaLiczbDoUsunieca = new int[rozmiar];
		int index = 0;
		for (int i = 0; i < rozmiar - 1; i++) {
			for (int k = i + 1; k < rozmiar; k++) {
				if (liczby[i] == liczby[k]) {
					tablicaLiczbDoUsunieca[index] = liczby[k];
					var = true;
					index += 1;
					break;
				}

			}

		}
		int[] zmniejszonaTablicaLiczbDousuniecia = new int[index];
		zmniejszonaTablicaLiczbDousuniecia = Arrays.copyOf(tablicaLiczbDoUsunieca, index);
		for (int i = 0; i < index; i++) {
			usunPierwszy(zmniejszonaTablicaLiczbDousuniecia[i]);

		}
	}

	public void odwroc() {
		int[] temp = new int[rozmiar];
		for (int i = 0; i < rozmiar; i++) {
			temp[i] = liczby[rozmiar - 1 - i];

		}
		liczby = temp;

	}

	public void zapiszDoPliku(String nazwaPliku) {
		StringBuilder text = new StringBuilder();
		text.append(String.format("%-10s %-12s %-20s", "rozmiar listy: " + rozmiar, "\npojemnoœæ listy: " + pojemnosc,
				"\nlista elementów tablicy:  "
						+ Arrays.toString(Arrays.copyOf(liczby, rozmiar)).replaceAll("\\[|\\]|,", "")));
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku));
			writer.write(text.toString());

			writer.close();

		} catch (IOException e) {
			System.out.println("error");
		}
	}
}
