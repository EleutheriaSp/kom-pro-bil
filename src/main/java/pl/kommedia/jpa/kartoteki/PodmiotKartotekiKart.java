package pl.kommedia.jpa.kartoteki;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value= "T")

public class PodmiotKartotekiKart extends PodmiotPowiazanyKart {

	@Override public String odbNazwe(){
		return podmiot.odbNazwa();
	}
	
	@Override public boolean czyPodmiot(){
		return true;
	}
}
