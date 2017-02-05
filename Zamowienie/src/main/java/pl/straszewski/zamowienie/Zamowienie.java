package pl.straszewski.zamowienie;

import java.io.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Zamowienie implements Serializable {
	int maksRozmiar;
	Pozycja[] pozycje;
	int ileDodanych;

	public Zamowienie() {
		this.maksRozmiar = 10;
		this.pozycje = new Pozycja[this.maksRozmiar];
	}

	public Zamowienie(int maksLiczbaPozycjiWZamowieniu) {
		this.maksRozmiar = maksLiczbaPozycjiWZamowieniu;
		this.pozycje = new Pozycja[this.maksRozmiar];
	}

	public void dodajPozycje(Pozycja p) {
		boolean czyTaSamaNazwaTowaru = false;
		for (int i = 0; i < this.ileDodanych; i++) {
			if (pozycje[i].getNazwaTowaru() == p.getNazwaTowaru()) {
				pozycje[i].setDodajIleSztuk(p.getIleSztuk());
				czyTaSamaNazwaTowaru = true;
				break;
			}
		}
		if (czyTaSamaNazwaTowaru == false) {
			this.pozycje[this.ileDodanych] = p;
			this.ileDodanych += 1;
		}
	}

	public double obliczWartosc() {
		double sum = 0;
		for (int i = 0; i < this.ileDodanych; i++) {
			sum += this.pozycje[i].obliczWartosc();
		}
		return sum;

	}

	public double obliczWartoscZRabatem() {
		double sum = 0;
		for (int i = 0; i < this.ileDodanych; i++) {
			sum += this.pozycje[i].obliczWartoscZRabatem();
		}
		return Math.round(sum * 100.0) / 100.0;
	}

	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append(String.format("%-20s %-12s %-12s %-10s", "Zamówienie", "Cena jend.", "ile sztuk", "cana"));
		for (int i = 0; i < this.ileDodanych; i++) {
			text.append("\n" + this.pozycje[i]);
		}
		text.append("\n\n\nCa³kowita cena bez rabatu:  " + obliczWartosc() + " z³");
		text.append("\nCa³kowita cena z uwzglednieniem rabatu:  " + obliczWartoscZRabatem() + " z³");
		text.append("\nWartoœæ rabatu:  " + wartoscRabatu() + " z³\n\n");
		return text.toString();
	}

	public double wartoscRabatu() {
		return Math.round((obliczWartosc() - obliczWartoscZRabatem()) * 100.0) / 100.0;

	}

	public void usunPozycje(int index) {
		for (int i = index; i < this.ileDodanych; i++) {
			this.pozycje[i] = this.pozycje[(i + 1)];
		}
		this.ileDodanych -= 1;
	}

	public void edytujPozycje(int index, String nazwaTowaru, int ileSztuk, double cena) {

		pozycje[index].setNazwaTowaru(nazwaTowaru);
		pozycje[index].setZamienIleSztuk(ileSztuk);
		pozycje[index].setCena(cena);

	}

	public static void zapiszZamowienie(Zamowienie z, String nazwaPliku) {

		try {
			FileOutputStream fileOut = new FileOutputStream(nazwaPliku);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(z);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in: " + nazwaPliku);
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	public static Zamowienie wczytajZamowienie(String nazwaPliku) {
		Zamowienie obj = new Zamowienie();

		try {
			FileInputStream fileIn = new FileInputStream(nazwaPliku);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			obj = (Zamowienie) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return obj;
		} catch (ClassNotFoundException c) {
			System.out.println("Zamowienie class not found");
			c.printStackTrace();
			return obj;

		}
		System.out.println("Deserialization complete");
		return obj;

	}
}