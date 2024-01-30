package proje;

public interface IReservable {

	public void koltukDurumOtobus(Bus otobus,int koltuksayisi);
	public void koltukDurumuTren(Train tren,int koltuksayisi);
	public void koltukDurumUcak(Airplane ucak,int koltuksayisi);
}
