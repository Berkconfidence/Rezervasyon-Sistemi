package proje;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Train extends Vehicle {
	
	String trainName;
	String yakitTürü;
	int koltukSayisi;
	public static Map<String, Train[]> firmaTren = new HashMap<>();
	
	
	public Train(String trainName)
	{
        this.trainName = trainName;
    }

    public String getTrainName()
    {
        return trainName;
    }
    
	@Override
	public void aracEkleme(String firma)
	{
		if(Train.firmaTren.get(firma)!=null)
		{
			Train[] mevcutTrenler = Train.firmaTren.get(firma);
			Train[] tren = {new Train("Tren"+(mevcutTrenler.length+1))};
	         
			Train[] guncelTrenler = Arrays.copyOf(mevcutTrenler, mevcutTrenler.length + tren.length);
	        System.arraycopy(tren, 0, guncelTrenler, mevcutTrenler.length, tren.length);

	        Train.firmaTren.put(firma, guncelTrenler);
		}
		else
		{
			Train[] tren = {new Train("Tren1")};
			Train.firmaTren.put(firma, tren);
		}
					
	}
	
	@Override
	public void aracSilme(String firma,String tren)
	{
		Train[] mevcutTrenler = Train.firmaTren.get(firma);
		int indexToRemove = -1;
	    for (int i = 0; i < mevcutTrenler.length; i++)
	    {
	        if (mevcutTrenler[i].getTrainName().equals(tren)) {
	            indexToRemove = i;
	            break;
	        }
	    }
	    
	    if (indexToRemove != -1)
	    {
	       
	    	Train[] guncelle = new Train[mevcutTrenler.length - 1];
	        int newIndex = 0;
	        for (int i = 0; i < mevcutTrenler.length; i++) {
	            if (i != indexToRemove) {
	            	guncelle[newIndex] = mevcutTrenler[i];
	                newIndex++;
	            }
	        }

	        Train.firmaTren.put(firma, guncelle);
	    }
	}
	
	@Override
	public void koltukSayisi(String firma,String tren,int adet)
	{		
		Train[] mevcutTrenler = Train.firmaTren.get(firma);
		
	    for (int i = 0; i < mevcutTrenler.length; i++)
	    {
	        if (mevcutTrenler[i].getTrainName().equals(tren))
	        {
	        	mevcutTrenler[i].koltukSayisi=adet;
	            break;
	        }
	    }
	}
	
	@Override
	public void yakitTürü(String firma,String tren,String tür)
	{		
		Train[] mevcutTrenler = Train.firmaTren.get(firma);
		
	    for (int i = 0; i < mevcutTrenler.length; i++)
	    {
	        if (mevcutTrenler[i].getTrainName().equals(tren))
	        {
	        	mevcutTrenler[i].yakitTürü=tür;
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
