package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Friends")
public class Friend implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public int id;
	
	public int idUser;
	public int idFriend;
	public int accept;
	
	public Friend() { 
		
	}
	
}
