package pl.kommedia.jpa.rozrachunki;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kommedia.jpa.kartoteki.DzialSprzedazyKart;
import pl.kommedia.jpa.kartoteki.PodmiotKart;
import pl.kompro.jpa.rozrachunki.StatusNaleznosciPro;
import pl.kompro.model.rozrachunki.StanRozrachunku;

@Entity
@Table( name= "ROZRACHUNKI", schema= "PRO")
@Inheritance( strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name= "CECHA", discriminatorType= DiscriminatorType.INTEGER, length= 2)
@SequenceGenerator( name= "gRozrachunkow", sequenceName= "S_ROZRACHUNKOW", initialValue=1, allocationSize=1, schema="PRO")

public class RozrachunekPro {

	@Id
	@Column( precision=9, scale=0)
	@GeneratedValue( generator= "gRozrachunkow", strategy= GenerationType.SEQUENCE)	
	private long id;

	@JoinColumn( name= "FIRMA_ID")
	private FirmaApp firma;
	
	@JoinColumn( name= "DZIAL_ID")
	private DzialSprzedazyKart dzial;
	
	@JoinColumn( name= "KONTRAHENT_ID")
	private PodmiotKart kontrahent;
	
	@JoinColumn( name= "PLATNIK_ID")
	private PodmiotKart platnik;

	@JoinColumn( name= "STATUS_ID")
	private StatusNaleznosciPro status;
	
	private int stan;
	
	public void wstFirme( FirmaApp firma){
		this.firma= firma;	
	}
	
	public void wstDzial( DzialSprzedazyKart dzial){
		this.dzial= dzial;
	}
	
	public void wstKontrahenta( PodmiotKart podmiot){
		this.kontrahent= podmiot;
	}
	
	public void wstPlatnika( PodmiotKart podmiot){
		this.platnik= podmiot;
	}

	public void wstStatus( StatusNaleznosciPro status){
		this.status= status;
	}

	public void wstStan( StanRozrachunku stan){
		this.stan= stan.id; 
		
	}
}
