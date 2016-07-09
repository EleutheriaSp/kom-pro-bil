package pl.kommedia.jpa.sprzedaz;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.kommedia.dao.sprzedaz.OdwiedzajacyFaktureBil;
import pl.kommedia.jpa.kartoteki.DzialSprzedazyKart;
import pl.kommedia.jpa.kartoteki.PodmiotKart;
import pl.kommedia.jpa.kartoteki.PodmiotPowiazanyKart;

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
	
	@JoinColumn( name= "ID_DZIALUSPRZ")
	private DzialSprzedazyKart dzial;
	
	@JoinColumn( name="ID_PODMIOTU")
	@ManyToOne
	private PodmiotKart podmiot;
	
	@JoinColumn( name="ID_ODBIORCY")
	@ManyToOne
	private PodmiotPowiazanyKart odbiorca;

	public abstract <T> T akceptuj( OdwiedzajacyFaktureBil<T> odwiedzajacy);

	public long odbId(){
		return id;
	}
	
	public String odbNumer(){
		return numer;
	}

	public DzialSprzedazyKart odbDzial(){
		return dzial;
	}
	
	public PodmiotKart odbPodmiot(){
		return podmiot;
	}
	
	public PodmiotPowiazanyKart odbOdbiorce(){
		return odbiorca;
	}
	
	// czy odbiorca z kartoteki
	public boolean czyOdbiorca(){
		if( odbiorca== null)
			return false;
		
		return odbiorca.czyPodmiot();
	}
	
}
