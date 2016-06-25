package pl.kommedia.dao.sprzedaz;

import pl.kommedia.jpa.sprzedaz.FakturaPodstawowaBil;

public interface OdwiedzajacyFaktureBil<T>{
	
	T odwiedz( FakturaPodstawowaBil faktura);
	//T odwiedz( FakturaPozostalaBil faktura);

}
