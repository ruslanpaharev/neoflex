package entities;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Roles")
public class Role implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public int id;
	
	private String title;
	
	public String getTitle(){
		return title;
	}
	
	public boolean isValid(String text, int minLength){
		
		String paternStr = "^[a-zA-Z0-9]+$";
		Pattern patern = Pattern.compile(paternStr);
		Matcher matcher = patern.matcher(text);
				
		return (text.length() >= minLength && matcher.matches()); 
	}
	
	public void setTitle(String title){
		
		if(isValid(title, 3)){
			this.title = title;
		}
	}
	
	public Role() {

    }
}
