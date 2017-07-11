package DataBase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Vector<String> wektor = new Vector<String>();
		System.out.println(wektor.size());
		wektor.add("Wojtek");
		wektor.addElement("Mkuba");
		System.out.println(wektor);
		
		
		
		
		
		
//		Map<Integer, String> mapa = new HashMap<Integer, String>();
//		mapa.put(1, "Wojtek");
//		mapa.put(2, "Tomek");
//		mapa.put(3, "Kuba");
//		mapa.put(4, "Kaziemierz");
//		System.out.println(mapa.size());
//
//		for (Map.Entry<Integer, String> val : mapa.entrySet()) {
//			System.out.println(val.getKey() + "---" + val.getValue());
//		}
//		List<Czlowiek> lista = new ArrayList<Czlowiek>();
//		lista.add(new Czlowiek(15, "Wojciech", "Straszewski"));
//		lista.add(new Czlowiek(18, "Jakub", "Straszewski"));
//		lista.add(new Czlowiek(20, "Tomasz", "Straszewski"));
//		
//		for (int i = 0; i<lista.size(); i++){
//			System.out.println("wiek: " + lista.get(i).wiek + ", Imiê: " + lista.get(i).imie + ", Nazwisko: " + lista.get(i).nazwisko);
//			
//		}
//			
		// DataBaseUpdate objUpdate = new DataBaseUpdate();
		// objUpdate.setDbName("ksiegarnia");
		// objUpdate.setDbTable("klienci");
		// objUpdate.setColumnNameModyfication("nazwisko");
		// objUpdate.setValue("Kowalski");
		// objUpdate.setNumber(17);
		// objUpdate.execute();
		// objUpdate.close();
		//
		// DataBaseInsert objInsert = new DataBaseInsert();
		// objInsert.setDBName("ksiegarnia");
		// objInsert.setDbTable("klienci");
		// objInset.setdBsecondColumnName("imie");
		// objInsert.setdBthirdColumnName("nazwisko");
		// objInsert.setdBfourthColumnName("miejscowosc");
		// objInsert.setValueInSecondColumn("'Wojciech'");
		// objInsert.setValueInThirdColumn("'Brylewski'");
		// objInsert.setValueInFourthColumn("'Poznan'");
		// objInsert.execute();
		// objInsert.close();

		// DataBaseSelect objSelect = new DataBaseSelect();
		// objSelect.setSqlQuery("SELECT * FROM klienci");
		// List<Klienci> listaKlientow = new ArrayList<Klienci>();
		// System.out.println(listaKlientow.size());
		//
		// objSelect.execute();
		// while (objSelect.getResult().next()) {
		// listaKlientow.add(new Klienci(objSelect.getResult().getInt(1),
		// objSelect.getResult().getString(2),
		// objSelect.getResult().getString(3),
		// objSelect.getResult().getString(4)));
		//
		// }
		//
		// objSelect.close();
		// for (Klienci klienci : listaKlientow) {
		// System.out.println(klienci.idklienta + "\t" + klienci.imie + "\t" +
		// klienci.nazwisko + "\t"
		// + klienci.miejscowosc + "\t");
		// }
		//
		// System.out.println(listaKlientow.size());
	}

}
