package business;

import java.util.ArrayList;

import data.CommentData;
import entities.Comment;

public class CommentBusiness {

	private CommentData comment;

    public CommentBusiness(){
    	
    	comment = new CommentData();
    }
    
    public ArrayList<Comment> getAll() {
    	return comment.getAll();
    }

    public void Insert(Comment entity){
    	
        if (entity == null)
        {
        	throw new NullPointerException();
        }

        comment.insert(entity);
    }

    public void Delete(int id) throws Exception{
    	
        if (id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        comment.delete(id);
    }

    public void Update(Comment entity) throws Exception{
    	
        if (entity.id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        comment.update(entity);
    }
	
}
