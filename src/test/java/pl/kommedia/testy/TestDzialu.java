package pl.kommedia.testy;

import pl.kommedia.dao.kartoteki.KartotekiOgolneDao;
import pl.kommedia.dao.kartoteki.KartotekiOgolneKart;
import pl.kommedia.jpa.kartoteki.DzialSprzedazyKart;
import pl.kompro.uslugi.Utrwalacz;

public class TestDzialu{

	public static void main( String[] args){
		(new TestDzialu()).start();
	}

	private void start() {
		KartotekiOgolneDao kartoteki= new KartotekiOgolneKart( Utrwalacz.manager());
		for( DzialSprzedazyKart dzial: kartoteki.odbDzialySprzedazy()){
			System.err.println( "Dzialy sprzedazy: "+ dzial.odbKod());
		}
		
		System.err.println( "Dzial sprzedazy podstawowej: "+ kartoteki.odbDzialSprzedazyPodstawowej().odbKod());
	}
}
