package pl.kommedia.dao.rozrachunki;

import java.util.List;

import javax.persistence.EntityManager;

import pl.kommedia.jpa.rozrachunki.RozrachunekPro;
import pl.kompro.dao.rozrachunki.RozrachunkiStd;
import pl.kompro.jpa.rozrachunki.StatusNaleznosciPro;

public abstract class RozrachunkiPro {

	public abstract void utrwal( RozrachunekPro rozrachunek);
	public abstract List<StatusNaleznosciPro> odbStatusyRozrachunku();
	
	static public RozrachunkiPro utwRozrachunki( final EntityManager em){
		return new RozrachunkiPro(){
			RozrachunkiStd std= RozrachunkiStd.utwRozrachunki( em);
			
			@Override public void utrwal( RozrachunekPro rozrachunek){
				em.merge( rozrachunek);
			}

			@Override public List<StatusNaleznosciPro> odbStatusyRozrachunku(){
				return std.odbStatusyNaleznosci();
			}
			
		};
	}
}
