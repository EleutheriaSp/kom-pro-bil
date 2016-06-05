package pl.kommedia.sprzedaz.dao;

import javax.persistence.EntityManager;

public class FakturyDao{
	private EntityManager em;
	
	public FakturyDao( EntityManager em){
		this.em= em;
	}
	
	
}
