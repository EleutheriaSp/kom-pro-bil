package pl.kommedia.dao.administracja;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.kommedia.jpa.administracja.FirmaApp;

public class KonfiguracjaApp implements KonfiguracjaDao{
	private EntityManager em;

	public KonfiguracjaApp( EntityManager em){
		this.em= em;
	}

	public List<FirmaApp> odbFirmy(){
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<FirmaApp> zapytanie= cb.createQuery( FirmaApp.class);
	
		Root<FirmaApp> firmy= zapytanie.from( FirmaApp.class);
		zapytanie.select( firmy);

		return em.createQuery( zapytanie).getResultList();
	}

}
