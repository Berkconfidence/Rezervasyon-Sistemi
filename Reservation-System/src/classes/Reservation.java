package proje;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Reservation {
	
	public static Map<String, ArrayList<String>> listeleSeferOtobus = new HashMap<>();
	public static Map<String, ArrayList<String>> listeleSeferTren = new HashMap<>();
	public static Map<String, ArrayList<String>> listeleSeferUcak = new HashMap<>();
	
	public void seferBul(int biletSayisi,String kalkis,String varis,LocalDate tarih)
	{
		Company firmaislem = new Company();
		Transport koltukislem = new Transport();
		listeleSeferOtobus.clear();
		listeleSeferTren.clear();
		listeleSeferUcak.clear();
		
		for(int i=0; i<firmaislem.firmadeti(); i++)
		{
			String firma = firmaislem.listele(i);
			
			if(Bus.firmaOtobus.get(firma)!=null || Train.firmaTren.get(firma)!=null || Airplane.firmaUcak.get(firma)!=null)
			{				
				ArrayList<String> otobusekle = new ArrayList<>();			
				ArrayList<String> trenekle = new ArrayList<>();				
				ArrayList<String> ucakekle = new ArrayList<>();
				
				int x=0,y=0,z=0;
				
				if(Bus.firmaOtobus.get(firma)!=null)
				{
					Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
					for (Bus otobus : mevcutotobusler)
			        {						
						if(Trip.firmaSeferleriOtobus.get(otobus)!=null)
						{
							x=0;
							String[] seferler = Trip.firmaSeferleriOtobus.get(otobus);
							for(int j=0; j<seferler.length; j++)
							{
								if(seferler[j].equals(kalkis))
									x++;
								if(seferler[j].equals(varis))
									x++;
								if(x==2)
								{
									int boskoltuksayisi = koltukislem.bosKoltukOtobus(otobus, tarih);								
									if(boskoltuksayisi>=biletSayisi)
									{
										otobusekle.add(otobus.getBusName());
										Reservation.listeleSeferOtobus.put(firma,otobusekle);
									}
									break;
								}								
							}
						}												
			        }
				}
				
			    if(Train.firmaTren.get(firma)!=null)
			    {
			    	Train[] mevcutTrenler = Train.firmaTren.get(firma);
			    	for (Train tren : mevcutTrenler)
			        {
			    		if(Trip.firmaSeferleriTren.get(tren)!=null)
			    		{
			    			y=0;
							String[] seferler = Trip.firmaSeferleriTren.get(tren);
							for(int j=0; j<seferler.length; j++)
							{
								if(seferler[j].equals(kalkis))
									y++;
								if(seferler[j].equals(varis))
									y++;
								if(y==2)
								{
									int boskoltuksayisi = koltukislem.bosKoltukTren(tren, tarih);
									if(boskoltuksayisi>=biletSayisi)
									{
										trenekle.add(tren.getTrainName());
										Reservation.listeleSeferTren.put(firma,trenekle);
									}
									break;
								}								
							}
			    		}    		
			        }
			    }
			    
			    if(Airplane.firmaUcak.get(firma)!=null)
			    {
					Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
			    	for (Airplane ucak : mevcutUcaklar)
			        {
			    		if(Trip.firmaSeferleriUcak.get(ucak)!=null)
			    		{
			    			z=0;
							String[] seferler = Trip.firmaSeferleriUcak.get(ucak);
							for(int j=0; j<seferler.length; j++)
							{
								if(seferler[j].equals(kalkis))
									z++;
								if(seferler[j].equals(varis))
									z++;
								if(z==2)
								{
									
									int boskoltuksayisi = koltukislem.bosKoltukUcak(ucak, tarih);
									if(boskoltuksayisi>=biletSayisi)
									{
										ucakekle.add(ucak.getAirplaneName());
										Reservation.listeleSeferUcak.put(firma,ucakekle);
									}
									break;
								}
									
							}
			    		}			    		
			        }
			    }
			}
		}
				
	}

}
