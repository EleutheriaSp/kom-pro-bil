package pl.kommedia.testy;

import pl.kommedia.dao.administracja.KonfiguracjaApp;
import pl.kommedia.dao.administracja.KonfiguracjaDao;
import pl.kommedia.jpa.administracja.FirmaApp;
import pl.kompro.uslugi.Utrwalacz;

/**
 * Ma pobrać z bazy listę firm/rejonów
 * @author Piotr
 *
 */
public class TestFirmy {
	
	public static void main( String[] args){
		(new TestFirmy()).start();
	}
	
	private void start(){
		KonfiguracjaDao firmy= new KonfiguracjaApp( Utrwalacz.manager());
		for( FirmaApp firma: firmy.odbFirmy()){
			System.err.println( "Firma: "+ firma.odbNazwe());
		}
	}

}

