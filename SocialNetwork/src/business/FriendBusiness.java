package business;

import java.util.ArrayList;

import data.FriendData;
import entities.Friend;

public class FriendBusiness {

	private FriendData friend;

    public FriendBusiness(){
    	
    	friend = new FriendData();
    }
    
    public ArrayList<Friend> getAll() {
    	return friend.getAll();
    }

    public void insert(Friend entity){
    	
        if (entity == null)
        {
        	throw new NullPointerException();
        }

        friend.insert(entity);
    }

    public void Delete(int id) throws Exception{
    	
        if (id <= 0 )
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }
                   
        friend.delete(id);
    }

    public void Update(Friend entity) throws Exception{
    	
        if (entity.id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        friend.update(entity);
    }
	
}
