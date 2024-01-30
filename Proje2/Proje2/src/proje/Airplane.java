package proje;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Airplane extends Vehicle {
	
	String ucakName;
	String yakitTürü;
	int koltukSayisi;
	public static Map<String, Airplane[]> firmaUcak = new HashMap<>();
	
	
	public Airplane(String ucakName)
	{
        this.ucakName = ucakName;
    }

    public String getAirplaneName()
    {
        return ucakName;
    }
    
	@Override
	public void aracEkleme(String firma)
	{
		if(Airplane.firmaUcak.get(firma)!=null)
		{
			Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
			Airplane[] ucak = {new Airplane("Uçak"+(mevcutUcaklar.length+1))};
	         
			Airplane[] guncelUcaklar = Arrays.copyOf(mevcutUcaklar, mevcutUcaklar.length + ucak.length);
	        System.arraycopy(ucak, 0, guncelUcaklar, mevcutUcaklar.length, ucak.length);

	        Airplane.firmaUcak.put(firma, guncelUcaklar);
		}
		else
		{
			Airplane[] ucak = {new Airplane("Uçak1")};
			Airplane.firmaUcak.put(firma, ucak);
		}
					
	}
	
	@Override
	public void aracSilme(String firma,String ucak)
	{
		Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);
		int indexToRemove = -1;
	    for (int i = 0; i < mevcutUcaklar.length; i++)
	    {
	        if (mevcutUcaklar[i].getAirplaneName().equals(ucak)) {
	            indexToRemove = i;
	            break;
	        }
	    }
	    
	    if (indexToRemove != -1)
	    {
	       
	    	Airplane[] guncelle = new Airplane[mevcutUcaklar.length - 1];
	        int newIndex = 0;
	        for (int i = 0; i < mevcutUcaklar.length; i++) {
	            if (i != indexToRemove) {
	            	guncelle[newIndex] = mevcutUcaklar[i];
	                newIndex++;
	            }
	        }

	        Airplane.firmaUcak.put(firma, guncelle);
	    }
	}
	
	@Override
	public void koltukSayisi(String firma,String ucak,int adet)
	{		
		Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);

	    for (int i = 0; i < mevcutUcaklar.length; i++)
	    {
	        if (mevcutUcaklar[i].getAirplaneName().equals(ucak))
	        {
	        	mevcutUcaklar[i].koltukSayisi=adet;
	            break;
	        }
	    }
	}
	
	@Override
	public void yakitTürü(String firma,String ucak,String tür)
	{		
		Airplane[] mevcutUcaklar = Airplane.firmaUcak.get(firma);

	    for (int i = 0; i < mevcutUcaklar.length; i++)
	    {
	        if (mevcutUcaklar[i].getAirplaneName().equals(ucak))
	        {
	        	mevcutUcaklar[i].yakitTürü=tür;
	            break;
	        }
	    }
	}
	
	public int getKoltukSayisi()
	{
		return koltukSayisi;
	}
	
	public String getYakıtTürü()
	{
		return yakitTürü;
	}

}
