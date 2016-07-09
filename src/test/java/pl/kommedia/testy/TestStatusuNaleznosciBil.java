package pl.kommedia.testy;

import javax.persistence.EntityManager;

import pl.kompro.dao.rozrachunki.RozrachunkiStd;
import pl.kompro.jpa.rozrachunki.StatusNaleznosciPro;
import pl.kompro.uslugi.Utrwalacz;

public class TestStatusuNaleznosciBil{

	public static void main( String[] args){
		(new TestStatusuNaleznosciBil()).start();
	}

	private void start(){
		EntityManager em = Utrwalacz.manager();
		RozrachunkiStd roz= RozrachunkiStd.utwRozrachunki( em);
		for( StatusNaleznosciPro status: roz.odbStatusyNaleznosci()){
			System.err.println( "Status: ("+ status.odbKod()+ ") "+status.odbNazwe());
		}
	}
}
