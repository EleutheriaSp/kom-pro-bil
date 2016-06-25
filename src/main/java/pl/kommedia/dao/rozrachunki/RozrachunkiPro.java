package pl.kommedia.dao.rozrachunki;

import javax.persistence.EntityManager;

import pl.kommedia.jpa.rozrachunki.RozrachunekPro;

public class RozrachunkiPro implements RozrachunkiDao{

	private EntityManager em;
	
	public RozrachunkiPro( EntityManager em){
		this.em= em;
	}
	
	public void utrwal( RozrachunekPro rozrachunek ){
		em.merge( rozrachunek);
	}

}
