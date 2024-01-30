package proje;

import java.util.HashMap;
import java.util.Map;

public class Personel extends Person {
	
	public static Map<Bus, String[]> personelOtobus = new HashMap<>();
	public static Map<Train, String[]> personelTren = new HashMap<>();
	public static Map<Airplane, String[]> personelUcak = new HashMap<>();
	
	public static void PersonelEkleOtobus(String firma)
	{
		String[] personel = {"Sofor1","Sofor2","Hizmet1","Hizmet2"};
		Bus[] mevcutOtobusler = Bus.firmaOtobus.get(firma);
		for (Bus otobus : mevcutOtobusler)
        {
			Personel.personelOtobus.put(otobus, personel);
        }
		
	}
	public static void PersonelEkleTren(String firma)
	{
		String[] personel = {"Makinist1","Makinist2","Hizmet1","Hizmet2"};
		Train[] mevcutTrenler =Train.firmaTren.get(firma);
		for (Train tren : mevcutTrenler)
        {
			Personel.personelTren.put(tren, personel);
        }
		
	}
	public static void PersonelEkleUcak(String firma)
	{
		String[] personel = {"Pilot1","Pilot2","Hizmet1","Hizmet2"};
		Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
		for (Airplane ucak : mevcutUcaklar)
        {
			Personel.personelUcak.put(ucak, personel);
        }	
	}

}
