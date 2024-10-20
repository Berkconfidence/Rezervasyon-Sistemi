package proje;

public class Admin extends User {
	
	public static String isim = "berk";
	public static String şifre = "123";
	
	@Override
	public void kullanıcıEkle(String isim, String sifre)
	{
		super.kullanıcıEkle(isim, sifre);
		Company.firmaKullanıcıAdı.add(isim);
        Company.firmaKullanıcıSifre.add(sifre);
	}
	
	public void firmaSil(String isim, String sifre,int i)
	{
		Company.firmaKullanıcıAdı.remove(i);
		Company.firmaKullanıcıSifre.remove(i);
	}

}
