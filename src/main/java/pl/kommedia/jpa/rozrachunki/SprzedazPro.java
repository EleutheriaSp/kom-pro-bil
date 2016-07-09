package pl.kommedia.jpa.rozrachunki;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import pl.kommedia.jpa.sprzedaz.FakturaBil;

@Entity
@DiscriminatorValue( value= "2")

public class SprzedazPro extends PrzychodPro{

	@OneToOne( fetch= FetchType.LAZY)
	@JoinColumn( name= "DOKUMENT_ID")
	private FakturaBil faktura;

	public SprzedazPro wstFakture( FakturaBil faktura){
		this.faktura= faktura;
		return this;
	}
}
