package pl.kommedia.testy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.kommedia.dao.administracja.FirmyDao;
import pl.kommedia.jpa.administracja.FirmaApp;

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
		FirmyDao firmy= new FirmyDao( odbMenagera());
		for( FirmaApp firma: firmy.odbWykazFirm()){
			System.err.println( "Firma: "+ firma.odbNazwe());
		}
	}

	private EntityManager odbMenagera(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "kom-pro-bil");
		return emf.createEntityManager();
	}
}

