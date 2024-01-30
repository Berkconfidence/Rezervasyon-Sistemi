package proje;

import java.time.LocalDate;
import java.util.ArrayList;

public class Company extends User implements IProfitable{
	
	public static ArrayList<String> firmaKullanıcıAdı = new ArrayList<String>();
	public static ArrayList<String> firmaKullanıcıSifre = new ArrayList<String>();
    
	public static void hazirFirmalar()
	{
		Bus busislem = new Bus(null);
		Train trenislem = new Train(null);
		Airplane ucakislem = new Airplane(null);
		Transport ulasımislem = new Transport();
		
        firmaKullanıcıAdı.add("Firma A");
        firmaKullanıcıSifre.add("123");
        Bus[] otobuslerFirmaA = {new Bus("Otobüs1"), new Bus("Otobüs2")};
		Bus.firmaOtobus.put("Firma A", otobuslerFirmaA);
		busislem.koltukSayisi("Firma A", "Otobüs1", 40);
		busislem.koltukSayisi("Firma A", "Otobüs2", 30);
		busislem.yakitTürü("Firma A", "Otobüs1", "Benzin");
		busislem.yakitTürü("Firma A", "Otobüs2", "Benzin");
		Personel.PersonelEkleOtobus("Firma A");
		Trip.seferEkleOtobus(otobuslerFirmaA[0], 3);
		Trip.seferEkleOtobus(otobuslerFirmaA[1], 3);
		ulasımislem.koltukDurumOtobus(otobuslerFirmaA[0], 40);
		ulasımislem.koltukDurumOtobus(otobuslerFirmaA[1], 30);
		
        firmaKullanıcıAdı.add("Firma B");
        firmaKullanıcıSifre.add("123");
        Bus[] otobuslerFirmaB = {new Bus("Otobüs1"), new Bus("Otobüs2")};
		Bus.firmaOtobus.put("Firma B", otobuslerFirmaB);
		busislem.koltukSayisi("Firma B", "Otobüs1", 30);
		busislem.koltukSayisi("Firma B", "Otobüs2", 40);
		busislem.yakitTürü("Firma B", "Otobüs1", "Motorin");
		busislem.yakitTürü("Firma B", "Otobüs2", "Motorin");
		Personel.PersonelEkleOtobus("Firma B");
		Trip.seferEkleOtobus(otobuslerFirmaB[0], 3);
		Trip.seferEkleOtobus(otobuslerFirmaB[1], 4);
		ulasımislem.koltukDurumOtobus(otobuslerFirmaB[0], 30);
		ulasımislem.koltukDurumOtobus(otobuslerFirmaB[1], 40);
		
        firmaKullanıcıAdı.add("Firma C");
        firmaKullanıcıSifre.add("123");
        Bus[] otobuslerFirmaC = {new Bus("Otobüs1")};
		Bus.firmaOtobus.put("Firma C", otobuslerFirmaC);
		Airplane[] ucakFirmaC = {new Airplane("Uçak1"), new Airplane("Uçak2")};
		Airplane.firmaUcak.put("Firma C", ucakFirmaC);
		busislem.koltukSayisi("Firma C", "Otobüs1", 40);
		busislem.yakitTürü("Firma C", "Otobüs1", "Motorin");
		ucakislem.koltukSayisi("Firma C", "Uçak1", 60);
		ucakislem.koltukSayisi("Firma C", "Uçak2", 60);
		ucakislem.yakitTürü("Firma C", "Uçak1", "Gaz");
		ucakislem.yakitTürü("Firma C", "Uçak2", "Gaz");
		Personel.PersonelEkleOtobus("Firma C");
		Personel.PersonelEkleUcak("Firma C");
		Trip.seferEkleOtobus(otobuslerFirmaC[0], 4);
		Trip.seferEkleUcak(ucakFirmaC[0], 5);
		Trip.seferEkleUcak(ucakFirmaC[1], 5);
		ulasımislem.koltukDurumOtobus(otobuslerFirmaC[0], 40);
		ulasımislem.koltukDurumUcak(ucakFirmaC[0], 60);
		ulasımislem.koltukDurumUcak(ucakFirmaC[1], 60);		
		
        firmaKullanıcıAdı.add("Firma D");
        firmaKullanıcıSifre.add("123");
        Train[] trenFirmaD = {new Train("Tren1"),new Train("Tren2"),new Train("Tren3")};
		Train.firmaTren.put("Firma D", trenFirmaD);
		trenislem.koltukSayisi("Firma D", "Tren1", 50);
		trenislem.koltukSayisi("Firma D", "Tren2", 50);
		trenislem.koltukSayisi("Firma D", "Tren3", 50);
		trenislem.yakitTürü("Firma D", "Tren1", "Elektrik");
		trenislem.yakitTürü("Firma D", "Tren2", "Elektrik");
		trenislem.yakitTürü("Firma D", "Tren3", "Elektrik");
		Personel.PersonelEkleTren("Firma D");
		Trip.seferEkleTren(trenFirmaD[0], 1);
		Trip.seferEkleTren(trenFirmaD[1], 2);
		Trip.seferEkleTren(trenFirmaD[2], 2);
		ulasımislem.koltukDurumuTren(trenFirmaD[0], 50);
		ulasımislem.koltukDurumuTren(trenFirmaD[1], 50);
		ulasımislem.koltukDurumuTren(trenFirmaD[2], 50);
		
        firmaKullanıcıAdı.add("Firma F");
        firmaKullanıcıSifre.add("123");
        Airplane[] ucakFirmaF = {new Airplane("Uçak1"), new Airplane("Uçak2")};
		Airplane.firmaUcak.put("Firma F", ucakFirmaF);
		ucakislem.koltukSayisi("Firma F", "Uçak1", 60);
		ucakislem.koltukSayisi("Firma F", "Uçak2", 60);
		ucakislem.yakitTürü("Firma F", "Uçak1", "Gaz");
		ucakislem.yakitTürü("Firma F", "Uçak2", "Gaz");
		Personel.PersonelEkleUcak("Firma F");
		Trip.seferEkleUcak(ucakFirmaF[0], 6);
		Trip.seferEkleUcak(ucakFirmaF[1], 6);
		ulasımislem.koltukDurumUcak(ucakFirmaF[0], 60);
		ulasımislem.koltukDurumUcak(ucakFirmaF[1], 60);	

        
    }
	public String listele(int i)
	{
		return firmaKullanıcıAdı.get(i);
	}
	public String listeleSifre(int i)
	{
		return firmaKullanıcıSifre.get(i);
	}
	public int firmadeti()
	{
		return firmaKullanıcıAdı.size();
	}
	
	
	@Override
	public int adminKarZarar(int adet, int gün)
	{		
		int kar = adet*1000*gün;
		return kar;
	}
	
	@Override
	public int firmaPersonelKarZarar(String firma)
	{		
		if(firma.equals("Firma A"))
			return 28000;
		else if(firma.equals("Firma B"))
			return 18000;
		else if(firma.equals("Firma C"))
			return 76000;
		else if(firma.equals("Firma D"))
			return 18000;
		else if(firma.equals("Firma F"))
			return 48000;
		else
			return 43000;
			
	}
	@Override
	public int firmaBiletKarZarar(String firma,LocalDate tarih)
	{
		
		Transport koltukislem = new Transport();
		int toplamfiyat=0;
		if(Bus.firmaOtobus.get(firma)!=null)
		{
			Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
			for (Bus otobus : mevcutotobusler)
	        {	
				int dolukoltuksayisi = koltukislem.doluKoltukOtobus(otobus, tarih);	
				String[] seferler = Trip.firmaSeferleriOtobus.get(otobus);
				if(seferler[seferler.length-1].equals("Ankara"))
					toplamfiyat+=(dolukoltuksayisi*300);
				else
					toplamfiyat+=(dolukoltuksayisi*300);
	        }
		}
		if(Train.firmaTren.get(firma)!=null)
		{
			Train[] mevcutTrenler = Train.firmaTren.get(firma);
			for(Train tren : mevcutTrenler)
			{
				int dolukoltuksayisi = koltukislem.doluKoltukTren(tren, tarih);	
				String[] seferler = Trip.firmaSeferleriTren.get(tren);
				if(seferler[seferler.length-1].equals("Ankara"))
					toplamfiyat+=(dolukoltuksayisi*250);
				else
					toplamfiyat+=(dolukoltuksayisi*300);
			}
		}
		if(Airplane.firmaUcak.get(firma)!=null)
		{
			Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
			for(Airplane ucak : mevcutUcaklar)
			{
				int dolukoltuksayisi = koltukislem.doluKoltukUcak(ucak, tarih);	
				String[] seferler = Trip.firmaSeferleriUcak.get(ucak);
				if(seferler[seferler.length-1].equals("Ankara"))
					toplamfiyat+=(dolukoltuksayisi*1000);
				else
					toplamfiyat+=(dolukoltuksayisi*1200);
			}
		}
		return toplamfiyat;
	}
	@Override
	public int firmaMesafeKarZarar(String firma)
	{
		
		int toplamfiyat=0;
		if(Bus.firmaOtobus.get(firma)!=null)
		{
			Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
			for (Bus otobus : mevcutotobusler)
	        {	
				String[] seferler = Trip.firmaSeferleriOtobus.get(otobus);
				if(seferler[seferler.length-1].equals("Ankara"))
					toplamfiyat+=10*500;
					
				else
					toplamfiyat+=10*600;
	        }
		}
		if(Train.firmaTren.get(firma)!=null)
		{
			Train[] mevcutTrenler = Train.firmaTren.get(firma);
			for(Train tren : mevcutTrenler)
			{
				String[] seferler = Trip.firmaSeferleriTren.get(tren);
				if(seferler[seferler.length-1].equals("Ankara"))
					toplamfiyat+=3*375;
				else
					toplamfiyat+=3*450;
			}
		}
		if(Airplane.firmaUcak.get(firma)!=null)
		{
			Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
			for(Airplane ucak : mevcutUcaklar)
			{
				String[] seferler = Trip.firmaSeferleriUcak.get(ucak);
				if(seferler[seferler.length-1].equals("Ankara"))
					toplamfiyat+=25*250;
				else
					toplamfiyat+=25*300;
			}
		}
		return toplamfiyat;
	}
	

}
