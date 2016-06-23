package pl.kommedia.sprzedaz.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import pl.kommedia.sprzedaz.dao.OdwiedzajacyFaktureBil;

@Entity
@DiscriminatorValue( value="0")
public class FakturaPodstawowaBil extends FakturaBil{

	@Override public <T> T akceptuj( OdwiedzajacyFaktureBil<T> odwiedzajacy){
		return odwiedzajacy.odwiedz( this);
	}
}
