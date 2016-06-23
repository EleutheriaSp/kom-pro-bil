package pl.kommedia.sprzedaz.jpa;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import pl.kommedia.sprzedaz.dao.OdwiedzajacyFaktureBil;

@Entity
@Table( name= "FAKTURA", schema="BIL")
@Inheritance( strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name= "KATEGORIA", discriminatorType= DiscriminatorType.INTEGER, length= 1)
public abstract class FakturaBil {

	@Id
	@Column( name="ID_FAKT")//, insertable=false, updatable= false)
	private long id;
	
	@Column( length= 30)
	private String numer;

	public abstract <T> T akceptuj( OdwiedzajacyFaktureBil<T> odwiedzajacy);

	public String odbNumer(){
		return numer;
	}
	
}
