package proje;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Bus extends Vehicle {
	
	String busName;
	String yakıtTürü;
	int koltukSayisi;
		
	public static Map<String, Bus[]> firmaOtobus = new HashMap<>();
	
	
	public Bus(String busName)
	{
        this.busName = busName;
    }

    public String getBusName()
    {
        return busName;
    }
    
	@Override
	public void aracEkleme(String firma)
	{
		if(Bus.firmaOtobus.get(firma)!=null)
		{
			Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
	        Bus[] otobus = {new Bus("Otobüs"+(mevcutotobusler.length+1))};
	         
	        Bus[] guncelOtobusler = Arrays.copyOf(mevcutotobusler, mevcutotobusler.length + otobus.length);
	        System.arraycopy(otobus, 0, guncelOtobusler, mevcutotobusler.length, otobus.length);

	        Bus.firmaOtobus.put(firma, guncelOtobusler);
		}
		else
		{
			Bus[] otobus = {new Bus("Otobüs1")};
			Bus.firmaOtobus.put(firma, otobus);
		}
					
	}
	
	@Override
	public void aracSilme(String firma,String otobus)
	{
		Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);
		int indexToRemove = -1;
	    for (int i = 0; i < mevcutotobusler.length; i++)
	    {
	        if (mevcutotobusler[i].getBusName().equals(otobus)) {
	            indexToRemove = i;
	            break;
	        }
	    }
	    
	    if (indexToRemove != -1)
	    {
	       
	        Bus[] guncelle = new Bus[mevcutotobusler.length - 1];
	        int newIndex = 0;
	        for (int i = 0; i < mevcutotobusler.length; i++) {
	            if (i != indexToRemove) {
	            	guncelle[newIndex] = mevcutotobusler[i];
	                newIndex++;
	            }
	        }

	        Bus.firmaOtobus.put(firma, guncelle);
	    }
	}
	
	@Override
	public void koltukSayisi(String firma,String otobus,int adet)
	{		
		Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);

	    for (int i = 0; i < mevcutotobusler.length; i++)
	    {
	        if (mevcutotobusler[i].getBusName().equals(otobus))
	        {
	            mevcutotobusler[i].koltukSayisi=adet;
	            break;
	        }
	    }
	    	   
	}
	
	@Override
	public void yakitTürü(String firma,String otobus,String tür)
	{		
		Bus[] mevcutotobusler = Bus.firmaOtobus.get(firma);

	    for (int i = 0; i < mevcutotobusler.length; i++)
	    {
	        if (mevcutotobusler[i].getBusName().equals(otobus))
	        {
	            mevcutotobusler[i].yakıtTürü=tür;
	            break;
	        }
	    }
	}
	
	public int getKoltukSayisi()
	{
		return koltukSayisi;
	}
	public void setKoltukSayisi(int koltukSayisi)
	{
        this.koltukSayisi = koltukSayisi;
    }

	public String getYakıtTürü()
	{
        return yakıtTürü;
    }

    public void setYakıtTürü(String yakıtTürü)
    {
        this.yakıtTürü = yakıtTürü;
    }

}
