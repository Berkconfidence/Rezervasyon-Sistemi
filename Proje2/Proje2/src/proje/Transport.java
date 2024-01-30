package proje;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Transport implements IReservable {

	public static Map<Bus, Map<LocalDate, boolean[]>> firmaKoltukOtobus = new HashMap<>();
    public static Map<Train, Map<LocalDate, boolean[]>> firmaKoltukTren = new HashMap<>();
    public static Map<Airplane, Map<LocalDate, boolean[]>> firmaKoltukUcak = new HashMap<>();
	
	@Override
	public void koltukDurumOtobus(Bus otobus, int koltuksayisi) {
		
        LocalDate seferTarihi = LocalDate.of(2023, 12, 4);
        
        Map<LocalDate, boolean[]> koltukDurumu = new HashMap<>();
        for (int i = 0; i < 7; i++)
        {
        	koltukDurumu.put(seferTarihi.plusDays(i), randomDoluKoltuklar(otobus.getKoltukSayisi(),i));           
        }

        firmaKoltukOtobus.put(otobus, koltukDurumu);


	}

	@Override
	public void koltukDurumuTren(Train tren, int koltuksayisi) {
		
		LocalDate seferTarihi = LocalDate.of(2023, 12, 4);
        
        Map<LocalDate, boolean[]> koltukDurumu = new HashMap<>();
        for (int i = 0; i < 7; i++)
        {
        	koltukDurumu.put(seferTarihi.plusDays(i), randomDoluKoltuklar(tren.getKoltukSayisi(),i));
        }

        firmaKoltukTren.put(tren, koltukDurumu);

	}

	@Override
	public void koltukDurumUcak(Airplane ucak, int koltuksayisi) {
		
		LocalDate seferTarihi = LocalDate.of(2023, 12, 4);
        
        Map<LocalDate, boolean[]> koltukDurumu = new HashMap<>();
        for (int i = 0; i < 7; i++)
        {
        	koltukDurumu.put(seferTarihi.plusDays(i), randomDoluKoltuklar(ucak.getKoltukSayisi(),i));
        }

        firmaKoltukUcak.put(ucak, koltukDurumu);
     
	}
	
	private static boolean[] randomDoluKoltuklar(int koltukSayisi,int ayar) {
        Random random = new Random();
        boolean[] koltuklar = new boolean[koltukSayisi];
        for (int i = 0; i < koltukSayisi; i++)
        {
        	if(ayar==0)
        	{
        		koltuklar[i] = random.nextDouble() < 0.99;
        	}
        	else if(ayar==1)
        	{
        		koltuklar[i] = random.nextDouble() < 0.90;
        	}
        	else if(ayar>=2 && ayar<4)
        	{
        		koltuklar[i] = random.nextDouble() < 0.85;
        	}
        	else if(ayar>=4 && ayar<6)
        	{
        		koltuklar[i] = random.nextDouble() < 0.45;
        	}      		
        	else
        		koltuklar[i] = random.nextDouble() < 0.2;
        }
        return koltuklar;
    }
	
	public int bosKoltukOtobus(Bus otobus, LocalDate Tarih)
	{
		int boskoltuk=0;
		
        boolean[] koltuklar = firmaKoltukOtobus.get(otobus).get(Tarih);
        for (int i = 0; i < koltuklar.length; i++)
        {
            if(!koltuklar[i])
            	boskoltuk++;
        }
		
		return boskoltuk;
	}
	
	public int bosKoltukTren(Train tren, LocalDate Tarih)
	{
		int boskoltuk=0;
		
        boolean[] koltuklar = firmaKoltukTren.get(tren).get(Tarih);
        for (int i = 0; i < koltuklar.length; i++)
        {
            if(!koltuklar[i])
            	boskoltuk++;
        }
		
		return boskoltuk;
	}
	
	public int bosKoltukUcak(Airplane ucak, LocalDate Tarih)
	{
		int boskoltuk=0;
		
        boolean[] koltuklar = firmaKoltukUcak.get(ucak).get(Tarih);
        for (int i = 0; i < koltuklar.length; i++)
        {
            if(!koltuklar[i])
            	boskoltuk++;
        }
		
		return boskoltuk;
	}
	public int doluKoltukOtobus(Bus otobus, LocalDate Tarih)
	{
		int dolukoltuk=0;
		
        boolean[] koltuklar = firmaKoltukOtobus.get(otobus).get(Tarih);
        for (int i = 0; i < koltuklar.length; i++)
        {
            if(koltuklar[i])
            	dolukoltuk++;
        }
		
		return dolukoltuk;
	}
	
	public int doluKoltukTren(Train tren, LocalDate Tarih)
	{
		int dolukoltuk=0;
		
        boolean[] koltuklar = firmaKoltukTren.get(tren).get(Tarih);
        for (int i = 0; i < koltuklar.length; i++)
        {
            if(koltuklar[i])
            	dolukoltuk++;
        }
		
		return dolukoltuk;
	}
	
	public int doluKoltukUcak(Airplane ucak, LocalDate Tarih)
	{
		int dolukoltuk=0;
		
        boolean[] koltuklar = firmaKoltukUcak.get(ucak).get(Tarih);
        for (int i = 0; i < koltuklar.length; i++)
        {
            if(koltuklar[i])
            	dolukoltuk++;
        }
		
		return dolukoltuk;
	}
	
	public void koltukGuncelle(String firmaAdi,String aracAdı,LocalDate localDate,int degis)
	{
		if(aracAdı.startsWith("Otobüs"))
		{			
			Bus[] mevcutotobusler = Bus.firmaOtobus.get(firmaAdi);
			for (Bus otobus : mevcutotobusler)
			{
                if(otobus.getBusName().equals(aracAdı))
                {				
                	Map<LocalDate, boolean[]> koltukDurumu = firmaKoltukOtobus.get(otobus);
                	boolean[] koltuklar = Transport.firmaKoltukOtobus.get(otobus).get(localDate);
                	koltuklar[degis-1]=true;
				    koltukDurumu.put(localDate, koltuklar);
				    firmaKoltukOtobus.put(otobus, koltukDurumu);
                }
            }
			
		}
		else if(aracAdı.startsWith("Tren"))
		{
			Train[] mevcuttrenler = Train.firmaTren.get(firmaAdi);
			for (Train tren : mevcuttrenler)
			{
                if(tren.getTrainName().equals(aracAdı))
                {					                  
                	Map<LocalDate, boolean[]> koltukDurumu = firmaKoltukTren.get(tren);
                	boolean[] koltuklar = Transport.firmaKoltukTren.get(tren).get(localDate);              	
                	koltuklar[degis-1]=true;				    
				    koltukDurumu.put(localDate, koltuklar);
				    firmaKoltukTren.put(tren, koltukDurumu);                 
                }
            }					
		}
		else if(aracAdı.startsWith("Uçak"))
		{
			Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firmaAdi);
			for(Airplane ucak : mevcutUcaklar)
			{
				if(ucak.getAirplaneName().equals(aracAdı))
				{
					Map<LocalDate, boolean[]> koltukDurumu = firmaKoltukUcak.get(ucak);
                	boolean[] koltuklar = Transport.firmaKoltukUcak.get(ucak).get(localDate);              	
				    koltuklar[degis-1]=true;				    
				    koltukDurumu.put(localDate, koltuklar);
				    firmaKoltukUcak.put(ucak, koltukDurumu); 
				}
			}
		}
	}

}
