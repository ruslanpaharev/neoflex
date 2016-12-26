package business;

import java.util.ArrayList;

import data.MessageData;
import entities.Message;

public class MessageBusiness {

	private MessageData mess;

    public MessageBusiness(){
    	
    	mess = new MessageData();
    }
    
    public ArrayList<Message> getAll() {
    	return mess.getAll();
    }

    public void Insert(Message entity){
    	
        if (entity == null)
        {
        	throw new NullPointerException();
        }

        mess.insert(entity);
    }

    public void Delete(int id) throws Exception{
    	
        if (id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        mess.delete(id);
    }

    public void Update(Message entity) throws Exception{
    	
        if (entity.id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        mess.update(entity);
    }
	
}
