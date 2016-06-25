package pl.kommedia.jpa.kartoteki;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table( name="PODMPOW", schema="KART")
@Inheritance( strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="Z_KARTOTEKI", discriminatorType=DiscriminatorType.CHAR, length= 1)
@DiscriminatorValue( value="F")

public class PodmiotPowiazanyKart {
	
	@Id
	@Column( name= "ID_PODMPOW")
	private long id;
	
	private String nazwa;
	
	@JoinColumn( name= "ID_PODM_KART")
	protected PodmiotKart podmiot;

	public String odbNazwe() {
		return nazwa;
	}

	public long odbId(){
		return id;
	}

	public boolean czyPodmiot(){
		return false;
	}

	public PodmiotKart odbPodmiot(){
		return podmiot;
	}

}

