package business;

import java.util.ArrayList;

import data.RoleData;
import data.UserData;
import entities.User;
import support.MySecurity;

public class UserBusiness {

	private UserData user;
    
    public UserBusiness(){
    	
    	user = new UserData();
    }
    
    public ArrayList<User> getAll() {
    	return user.getAll();
    }

    public int Insert(User entity){
    	
        if (entity == null)
        {
        	throw new NullPointerException();
        }

        int idUser =  user.insert(entity);
        user.attachUserToRole(idUser, 3);

        return idUser;
    }

    public void Delete(int id) throws Exception{
    	
        if (id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        user.deleteUserRole(id);
        user.delete(id);
    }

    public void Update(User entity) throws Exception{
    	
        if (entity.id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        user.update(entity);
    }

    public int GetUserIDByPhotoID(int idPhoto){
    	
        return new UserData().getUserIDByPhotoID(idPhoto);
    }

    public int GetIdByLogin(String userName){
    	
        return new UserData().getIdByLogin(userName);
    }

    public String getRoleForUser(int idUser){
    	
        RoleData role = new RoleData();
        return role.getRoleForUser(idUser);
    }
    
    public String getHashCodeDigest(String password){
    	
		return MySecurity.getHashCodeDigest(password);
    }

    public boolean verifyHashCodeDigest(String passwordString, String passwordDigest){
    	
		String inputDigest = MySecurity.getHashCodeDigest(passwordString);
		return passwordDigest.equals(inputDigest);
    }
	
    public void UpdateUserRole(int idUser, int idRole){
    	
        new UserData().updateUserRole(idUser, idRole);
    }
	
}
