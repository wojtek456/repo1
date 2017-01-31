package pl.straszewski.zamowienie;

import java.io.PrintWriter;
import java.math.RoundingMode;

public class Pozycja {
	private String nazwaTowaru;
	private int ileSztuk;
	private double cena;

	public String getNazwaTowaru() {
		return nazwaTowaru;
	}

	public int getIleSztuk() {
		return ileSztuk;
	}

	public double getCena() {
		return cena;
	}

	public void setDodajIleSztuk(int ileSztuk) {
		this.ileSztuk += ileSztuk;
	}

	public void setZamienIleSztuk(int ileSztuk) {
		this.ileSztuk = ileSztuk;
	}

	public void setNazwaTowaru(String nazwatowaru) {
		this.nazwaTowaru = nazwatowaru;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
		this.nazwaTowaru = nazwaTowaru;
		this.ileSztuk = ileSztuk;
		this.cena = cena;
	}

	public double obliczWartosc() {
		return Math.round(this.ileSztuk * this.cena * 100.0) / 100.0;
	}

	public String toString() {
		return String.format("%-20s %-12s %-12s %-10s %-25s", this.nazwaTowaru, this.cena + " z³",
				this.ileSztuk + " szt.", obliczWartosc() + " z³", "rabat wyniós³: " + rabat() + "%"
						+ ", cena po uwzglêdnieniu rabatu wynios³a:  " + obliczWartoscZRabatem() + " z³");
	}

	public double obliczWartoscZRabatem() {

		return Math.round(ileSztuk * cena * ((100.0 - rabat()) / 100.0) * 100.0) / 100.0;

	}

	public int rabat() {
		int rabat;
		if (5 <= ileSztuk && ileSztuk < 10) {
			rabat = 5;
		} else if (10 <= ileSztuk && ileSztuk < 20) {
			rabat = 10;
		} else if (ileSztuk >= 20) {
			rabat = 15;
		} else {
			rabat = 0;
		}
		return rabat;

	}

}
