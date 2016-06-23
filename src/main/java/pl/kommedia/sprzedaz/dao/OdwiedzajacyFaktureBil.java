package pl.kommedia.sprzedaz.dao;

import pl.kommedia.sprzedaz.jpa.FakturaPodstawowaBil;

public interface OdwiedzajacyFaktureBil<T>{
	
	T odwiedz( FakturaPodstawowaBil faktura);
	//T odwiedz( FakturaPozostalaBil faktura);

}
