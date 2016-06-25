package pl.kommedia.jpa.kartoteki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="DZIALSP", schema="KART")
public class DzialSprzedazyKart{

	@Id
	@Column( name= "ID_DZIALUSP")
	private long id;
	
	private String kod;
	private String nazwa;
	
	@Column( name= "AKTYWNY")
	private boolean aktywny;
	
	public String odbKod(){
		return kod;
	}
	
	public boolean czyAktywny(){
		return aktywny;
	}
	
}
