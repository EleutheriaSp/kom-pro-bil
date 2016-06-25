package pl.kommedia.testy;

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
import pl.kompro.uslugi.Utrwalacz;

public class TestFaktury {
	
	public static void main( String[] args){
		(new TestFaktury()).start();
	}

	private void start(){
		EntityManager em = Utrwalacz.manager();
		KonfiguracjaDao kartoteki= new KonfiguracjaApp( em);
		FakturyBil fd= new FakturyBil( em);
		RozrachunkiPro ro= new RozrachunkiPro( em);
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
			
			rozrachunek.wstKontrahenta( faktura.odbPodmiot());
			if( faktura.odbOdbiorce()!=null && faktura.odbOdbiorce().czyPodmiot()){
				rozrachunek.wstPlatnika( faktura.odbOdbiorce().odbPodmiot());
			}else{
				rozrachunek.wstPlatnika( faktura.odbPodmiot());
			}
			
			rozrachunek.wstFirme( firma);
			rozrachunek.wstDzial( fd.odbDzial( faktura));
			ro.utrwal( rozrachunek);
		}
		em.getTransaction().commit();
	}

}
