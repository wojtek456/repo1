package pl.straszewski.czas;

public class Czas {
	private int godz;
	private int minuty;

	public Czas(int godz, int minuty) {
		int pomocnicza = minuty / 60;
		this.minuty = minuty - pomocnicza * 60;
		this.godz = godz + pomocnicza;
		// System.out.println(this.godz + " h " + this.minuty + " min");

	}

	public Czas(String tekst) {

		String[] obj = tekst.split(" ");
		int godz = Integer.valueOf(obj[0]);
		int minuty = Integer.valueOf(obj[2]);
		int pomocnicza = minuty / 60;
		this.minuty = minuty - pomocnicza * 60;
		this.godz = godz + pomocnicza;
	}

	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append(String.format("%-2s h %-2s min", godz, minuty));

		return text.toString();

	}

	public Czas dodaj(Czas t) {
		Czas time = new Czas(godz, minuty);
		int pomocnicza = t.minuty / 60;
		time.minuty += t.minuty - pomocnicza * 60;
		time.godz += t.godz + pomocnicza;

		return time;
	}

	public Czas odejmij(Czas t) {
		Czas time = new Czas(godz, minuty);
		int var1 = time.godz * 60 + time.minuty;
		int var2 = t.godz * 60 + t.minuty;
		int var3 = Math.abs(var1 - var2);
		int pomocnicza = var3 / 60;
		time.godz = (var1 - var2 > 0) ? pomocnicza : pomocnicza * (-1);
		time.minuty = var3 - pomocnicza * 60;

		return time;
	}

	public Czas pomnoz(int ile) {
		Czas time = new Czas(godz, minuty);
		int var1 = time.godz * 60 + time.minuty;
		int var2 = var1 * ile;
		int pomocnicza = var2 / 60;
		time.godz = pomocnicza;
		time.minuty = var2 - pomocnicza * 60;

		return time;
	}

	public static Czas sumuj(Czas[] tab, int n) {
		Czas sumuj = new Czas(0, 0);
		int sumaMinut = 0;
		for (int i = 0; i < n; i++) {
			sumaMinut += tab[i].godz * 60 + tab[i].minuty;
		}
		int pomocnicza = sumaMinut / 60;
		sumuj.godz = pomocnicza;
		sumuj.minuty = sumaMinut - pomocnicza * 60;
		return sumuj;
	}

}
