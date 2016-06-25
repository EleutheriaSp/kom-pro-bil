package pl.kommedia.dao.sprzedaz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.kommedia.dao.kartoteki.KartotekiOgolneKart;
import pl.kommedia.jpa.kartoteki.DzialSprzedazyKart;
import pl.kommedia.jpa.sprzedaz.FakturaBil;

public class FakturyBil {
	private EntityManager em;
	private KartotekiOgolneKart kartoteki;
	
	public FakturyBil( EntityManager em){
		this.em= em;
	}
	
	public FakturaBil odbFakture( long faktura){
		return em.find( FakturaBil.class, faktura);
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

	public DzialSprzedazyKart odbDzial( FakturaBil faktura){
		DzialSprzedazyKart dzial= faktura.odbDzial();
		if( dzial== null){
			if( kartoteki== null){
				kartoteki= new KartotekiOgolneKart( em);
			}
			dzial= kartoteki.odbDzialSprzedazyPodstawowej();
		}
		return dzial;
	}


}

