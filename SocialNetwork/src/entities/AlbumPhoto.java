package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="AlbumPhoto")
public class AlbumPhoto implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	public int idAlbum;
	
	@Id
	public int idPhoto;
	
	public AlbumPhoto(){
		
	}

}
