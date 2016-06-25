package pl.kommedia.dao.kartoteki;

import java.util.List;

import pl.kommedia.jpa.kartoteki.DzialSprzedazyKart;

public interface KartotekiOgolneDao{
	
	public List<DzialSprzedazyKart> odbDzialySprzedazy();
	public DzialSprzedazyKart odbDzialSprzedazyPodstawowej();
	
}
