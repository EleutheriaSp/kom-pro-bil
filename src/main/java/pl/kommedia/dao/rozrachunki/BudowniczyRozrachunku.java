package pl.kommedia.dao.rozrachunki;

import pl.kommedia.dao.sprzedaz.OdwiedzajacyFaktureBil;
import pl.kommedia.jpa.rozrachunki.RozrachunekPro;
import pl.kommedia.jpa.rozrachunki.SprzedazPro;
import pl.kommedia.jpa.sprzedaz.FakturaPodstawowaBil;

public class BudowniczyRozrachunku implements OdwiedzajacyFaktureBil<RozrachunekPro>{

	public RozrachunekPro odwiedz( FakturaPodstawowaBil faktura){
		SprzedazPro rozrachunek = new SprzedazPro();
		rozrachunek.wstFakture( faktura);
		return rozrachunek;
	}


}
