package proje;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Trip {
	
	public static Map<Bus, String[]> firmaSeferleriOtobus = new HashMap<>();
	public static Map<Train, String[]> firmaSeferleriTren = new HashMap<>();
	public static Map<Airplane, String[]> firmaSeferleriUcak = new HashMap<>();
	
	public static String[] sefer1 = {"İstanbul","Kocaeli","Bilecik","Eskişehir","Ankara"};
	public static String[] sefer2 = {"İstanbul","Kocaeli","Bilecik","Eskişehir","Konya"};
	public static String[] sefer3 = {"İstanbul","Kocaeli","Ankara"};
	public static String[] sefer4 = {"İstanbul","Kocaeli","Eskişehir","Konya"};
	public static String[] sefer5 = {"İstanbul","Konya"};
	public static String[] sefer6 = {"İstanbul","Ankara"};
	
	
	public static void seferEkleOtobus(Bus otobüs,int seferNo)
	{
		if(Trip.firmaSeferleriOtobus.get(otobüs)==null)
		{
			if(seferNo==3)
			{
				Trip.firmaSeferleriOtobus.put(otobüs,sefer3);
			}
			else
			{
				Trip.firmaSeferleriOtobus.put(otobüs,sefer4);
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Aracın Zaten Seferi Bulunmakta!");		
	}
	
	public static void seferEkleTren(Train tren,int seferNo)
	{
		if(Trip.firmaSeferleriTren.get(tren)==null)
		{
			if(seferNo==1)
			{
				Trip.firmaSeferleriTren.put(tren,sefer1);
			}
			else
			{
				Trip.firmaSeferleriTren.put(tren,sefer2);
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Aracın Zaten Seferi Bulunmakta!");		
	}
	
	public static void seferEkleUcak(Airplane ucak,int seferNo)
	{
		if(Trip.firmaSeferleriUcak.get(ucak)==null)
		{
			if(seferNo==5)
			{
				Trip.firmaSeferleriUcak.put(ucak,sefer5);
			}
			else
			{
				Trip.firmaSeferleriUcak.put(ucak,sefer6);
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Aracın Zaten Seferi Bulunmakta!");		
	}
	
	public static void seferÇıkarOtobus(Bus otobüs)
	{
		String[] seferler = Trip.firmaSeferleriOtobus.get(otobüs);
		if(seferler!=null)
		{
			Trip.firmaSeferleriOtobus.remove(otobüs);
			JOptionPane.showMessageDialog(null, "Sefer Çıkarıldı!");
		}
		else
			JOptionPane.showMessageDialog(null, "Sefer Bulunamadı!");		
	}
	
	public static void seferÇıkarTren(Train tren)
	{
		String[] seferler = Trip.firmaSeferleriTren.get(tren);
		if(seferler!=null)
		{
			Trip.firmaSeferleriTren.remove(tren);
			JOptionPane.showMessageDialog(null, "Sefer Çıkarıldı!");
		}
		else
			JOptionPane.showMessageDialog(null, "Sefer Bulunamadı!");		
	}
	
	public static void seferÇıkarUcak(Airplane ucak)
	{
		String[] seferler = Trip.firmaSeferleriUcak.get(ucak);
		if(seferler!=null)
		{
			Trip.firmaSeferleriUcak.remove(ucak);
			JOptionPane.showMessageDialog(null, "Sefer Çıkarıldı!");
		}
		else
			JOptionPane.showMessageDialog(null, "Sefer Bulunamadı!");		
	}
	
	public static void yazdir(Bus otobüs)
	{
		System.out.println(otobüs.getBusName());
		String[] seferler = Trip.firmaSeferleriOtobus.get(otobüs);
		System.out.println(seferler[2]);
	}
	
	
}
