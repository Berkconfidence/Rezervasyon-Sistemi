package proje;

import java.time.LocalDate;

public interface IProfitable {

	public int adminKarZarar(int adet,int gün);
	public int firmaBiletKarZarar(String firma,LocalDate tarih);
	public int firmaMesafeKarZarar(String firma);
	public int firmaPersonelKarZarar(String firma);
	
}
