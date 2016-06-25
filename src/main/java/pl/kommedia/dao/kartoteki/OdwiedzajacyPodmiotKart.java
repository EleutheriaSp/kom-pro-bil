package pl.kommedia.dao.kartoteki;

import pl.kommedia.jpa.kartoteki.DzialanoscGospodarczaKart;
import pl.kommedia.jpa.kartoteki.OsobaFizycznaKart;
import pl.kommedia.jpa.kartoteki.PracownikKart;

public interface OdwiedzajacyPodmiotKart<T> {
	T odwiedz( OsobaFizycznaKart osobaFizyczna);
	T odwiedz( DzialanoscGospodarczaKart dzialanoscGospodarcza);
	T odwiedz( PracownikKart pracownik);

}
