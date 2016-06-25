package pl.kommedia.dao.kartoteki;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.kommedia.jpa.kartoteki.DzialSprzedazyKart;

public class KartotekiOgolneKart implements KartotekiOgolneDao{
	private EntityManager em;
	private DzialSprzedazyKart dzial;
	
	public KartotekiOgolneKart( EntityManager em){
		this.em= em;
	}

	public List<DzialSprzedazyKart> odbDzialySprzedazy(){
		CriteriaBuilder cb= em.getCriteriaBuilder();
		
		CriteriaQuery<DzialSprzedazyKart> zapytanie= cb.createQuery( DzialSprzedazyKart.class);
		Root<DzialSprzedazyKart> dzialy= zapytanie.from( DzialSprzedazyKart.class);
		
		zapytanie.select( dzialy);
				
		return em.createQuery( zapytanie).getResultList();
	}

	public DzialSprzedazyKart odbDzialSprzedazyPodstawowej(){
		if( this.dzial== null){
			for( DzialSprzedazyKart dzial: odbDzialySprzedazy()){
				if( !dzial.czyAktywny()){
					this.dzial= dzial;
					break;
				}
			}
		}
		return this.dzial;	// zglosic blad jesli null
	}

}
