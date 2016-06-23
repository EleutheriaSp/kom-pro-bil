package pl.kommedia.sprzedaz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.kommedia.sprzedaz.jpa.FakturaBil;

public class FakturyBil {
	private EntityManager em;
	
	public FakturyBil( EntityManager em){
		this.em= em;
	}
	
	public KryteriaFakturyBil odbKryteriaFaktury(){
		return new KryteriaFakturyBil();
	}
	
	public class KryteriaFakturyBil{
		
		public List<FakturaBil> odbFaktury(){
			CriteriaBuilder cb= em.getCriteriaBuilder();
			
			CriteriaQuery<FakturaBil> zapytanie= cb.createQuery( FakturaBil.class);
			Root<FakturaBil> faktury= zapytanie.from( FakturaBil.class);

			return em.createQuery( zapytanie).setFirstResult( 0).setMaxResults( 5).getResultList();
		}
	}
}

