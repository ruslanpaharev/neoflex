package business;

import java.time.LocalDate;
import java.util.ArrayList;

import data.CommentData;
import data.PhotoData;
import entities.Comment;
import entities.Photo;

public class PhotoBusiness {

	private PhotoData photo;

    public PhotoBusiness(){
    	
    	photo = new PhotoData();
    }
    
    public ArrayList<Photo> getAll() {
    	return photo.getAll();
    }

    public java.sql.Blob getFullImageByte(int id){
    	
        return photo.getFullImageByte(id);
    }

    public void insert(Photo entity, int idAlbum, java.sql.Blob fullPhoto){
    	
        if (entity == null || idAlbum <= 0)
        {
        	throw new NullPointerException();
        }

        int id_photo = photo.insert(entity);
        photo.attachPhotoToAlbum(id_photo, idAlbum);
        photo.insertFullPhoto(id_photo, fullPhoto);
    }

    public void Delete(int idPhoto, int idAlbum) throws Exception{
    	
        if (idPhoto <= 0 || idAlbum <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        CommentData comment = new CommentData();

        photo.deletePhotoToAlbum(idPhoto, idAlbum);
        photo.deleteFullPhoto(idPhoto);
        comment.deleteByIdPhoto(idPhoto);
        photo.delete(idPhoto);
    }

    public void Update(Photo entity) throws Exception{
    	
        if (entity.id <= 0)
        {
        	throw new Exception("Не корректно задан ID сущности!");
        }

        photo.update(entity);
    }

    public void InsertComment(int idUser, int idPhoto, String title){
    	
        Comment comment = new Comment();
        comment.idUser = idUser;
        comment.idPhoto = idPhoto;
        comment.title = title;
        
		LocalDate localDate = LocalDate.now();
        comment.creationDate = java.sql.Date.valueOf(localDate);
        
        CommentData commentData = new CommentData();
        commentData.insert(comment);
    }

    public ArrayList<Comment> GetCommentsByID(int idPhoto) throws Exception{
    	
        if (idPhoto <= 0){
        	throw new Exception("Не корректно задан ID сущности!");
        }
        
        CommentData commentData = new CommentData();
        ArrayList<Comment> array = commentData.getCommentsByID(idPhoto);

        return array;
    }

    public ArrayList<Photo> GetPhotosByIdAlbums(int idAlbum) throws Exception{
    	
        if (idAlbum <= 0){
        	throw new Exception("Не корректно задан ID сущности!");
        }
        
        return photo.getPhotosByIdAlbums(idAlbum);
    }

    public ArrayList<Photo> GetPhotosByIdUser(int idUser) throws Exception{
    	
        if (idUser <= 0){
        	throw new Exception("Не корректно задан ID сущности!");
        }
        
        return photo.getPhotosByIdUser(idUser);
    }
	
}
