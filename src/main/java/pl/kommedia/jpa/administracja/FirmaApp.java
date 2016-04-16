package pl.kommedia.jpa.administracja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name= "METRYKA", schema="APP")
public class FirmaApp {
	@Id
	private long id;
	
	@Column( name= "OGOLNA_NAZWA")
	private String kod;
	
	private String nazwa;

	public String odbKod(){
		return kod;
	}
	
	public String odbNazwe(){
		return nazwa;
	}
}
