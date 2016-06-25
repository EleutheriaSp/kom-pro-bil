package pl.kommedia.jpa.kartoteki;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import pl.kommedia.dao.kartoteki.OdwiedzajacyPodmiotKart;

@Entity
@Table( name= "HISTPODMIOTU", schema= "KART")
@SecondaryTable( name= "PODMIOT", schema= "KART", pkJoinColumns= @PrimaryKeyJoinColumn( referencedColumnName= "ID_HIST_PODM"))
@Inheritance( strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name= "OSOBA", discriminatorType=DiscriminatorType.CHAR, length= 1)

public abstract class PodmiotKart{
	@Id
	@Column( name= "ID_PODMIOTU")
	private long id;
	
	@Column( table= "PODMIOT", length= 16)
	private String kod;
	
	@Column( length= 40)
	private String nazwa;
	
	public String odbKod(){
		return kod;
	}
	
	public String odbNazwa(){
		return nazwa;
	}
	
	public abstract <T> T akceptuj( OdwiedzajacyPodmiotKart<T> odwiedzajacy);

}

