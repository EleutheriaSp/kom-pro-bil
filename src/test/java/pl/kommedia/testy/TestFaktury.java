package pl.kommedia.testy;

import java.util.List;

import javax.persistence.EntityManager;

import pl.kommedia.dao.administracja.KonfiguracjaApp;
import pl.kommedia.dao.administracja.KonfiguracjaDao;
import pl.kommedia.dao.rozrachunki.BudowniczyRozrachunku;
import pl.kommedia.dao.rozrachunki.RozrachunkiPro;
import pl.kommedia.dao.sprzedaz.FakturyBil;
import pl.kommedia.dao.sprzedaz.FakturyBil.KryteriaFakturyBil;
import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kommedia.jpa.rozrachunki.RozrachunekPro;
import pl.kommedia.jpa.sprzedaz.FakturaBil;
import pl.kompro.dao.rozrachunki.RozrachunkiStd;
import pl.kompro.jpa.rozrachunki.StatusNaleznosciPro;
import pl.kompro.model.rozrachunki.StanRozrachunku;
import pl.kompro.uslugi.Utrwalacz;

public class TestFaktury {
	
	public static void main( String[] args){
		(new TestFaktury()).start();
	}

	private void start(){
		EntityManager em = Utrwalacz.manager();
		KonfiguracjaDao kartoteki= new KonfiguracjaApp( em);
		FakturyBil fd= new FakturyBil( em);
		RozrachunkiPro ro= RozrachunkiPro.utwRozrachunki( em);
		List<StatusNaleznosciPro> statusy= RozrachunkiStd.utwRozrachunki( em).odbStatusyNaleznosci();
		KryteriaFakturyBil kryteria = fd.odbKryteriaFaktury();
		
		BudowniczyRozrachunku budowniczy= new BudowniczyRozrachunku();
		
		em.getTransaction().begin();
		FirmaApp firma= null;
		for( FirmaApp f: kartoteki.odbFirmy()){
			firma= f;
			break;
		}
		
		for( FakturaBil faktura: kryteria.odbFaktury()){
			System.err.println( "Faktura: "+ faktura.odbNumer());
			RozrachunekPro rozrachunek = faktura.akceptuj( budowniczy);
			System.err.println( "Rozrachunek: "+ rozrachunek);
			
			rozrachunek.wstStatus( statusy.get( 0));
			rozrachunek.wstStan( StanRozrachunku.Tworzony);
			
			rozrachunek.wstFirme( firma);
			rozrachunek.wstDzial( fd.odbDzial( faktura));
			ro.utrwal( rozrachunek);
		}
		em.getTransaction().commit();
	}

}
