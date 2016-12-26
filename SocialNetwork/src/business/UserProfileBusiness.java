package business;

import java.util.ArrayList;

import data.UserProfileData;
import entities.UserProfile;

public class UserProfileBusiness {

	private UserProfileData profile;

    public UserProfileBusiness(){
    	
    	profile = new UserProfileData();
    }
    
    public ArrayList<UserProfile> getAll() {
    	return profile.getAll();
    }

    public void Insert(UserProfile entity){
    	
        if (entity == null)
        {
        	throw new NullPointerException();
        }

        profile.insert(entity);
    }

    public void Delete(int id) throws Exception{
    	
        if (id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        profile.delete(id);
    }

    public void Update(UserProfile entity) throws Exception{
    	
        if (entity.idUser <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        profile.update(entity);
    }

    public ArrayList<UserProfile> getUserProfileBySearchString(String text){
    	
    	return profile.getUserProfileBySearchString(text);
    }
	
}
