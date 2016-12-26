package entities;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="UserProfile")
public class UserProfile implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	public int idUser;
	
	private String name;
	
	public String getName(){
		return name;
	}
	
	public boolean isValid(String text){
		
		String paternStr = ".*[0-9].*";
		Pattern patern = Pattern.compile(paternStr);
		Matcher matcher = patern.matcher(text);
				
		return (!matcher.matches()); 
	}
	
	public void setName(String name){
		
		if(isValid(name)){
			this.name = name;
		}
	}
	
	private String surname;
	
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String surname){
		
		if(isValid(surname)){
			this.surname = surname;
		}
	}
	
	public String status;
    public String contacts;
    public java.sql.Blob previewImage;
	
	public UserProfile() { 
		
	}
	
}
