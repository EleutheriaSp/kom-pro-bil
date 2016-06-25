package pl.kommedia.jpa.kartoteki;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import pl.kommedia.dao.kartoteki.OdwiedzajacyPodmiotKart;

@Entity
@DiscriminatorValue( value= "")

public class PracownikKart extends PodmiotKart{

	@Override public <T> T akceptuj(OdwiedzajacyPodmiotKart<T> odwiedzajacy) {
		return odwiedzajacy.odwiedz( this);
	}

}
