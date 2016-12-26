package business;

import java.util.ArrayList;

import data.AlbumData;
import entities.Album;
import entities.Photo;

public class AlbumBusiness {

	private AlbumData album;

    public AlbumBusiness(){
    	
    	album = new AlbumData();
    }
    
    public ArrayList<Album> getAll() {
    	return album.getAll();
    }
    
    public void insert(Album entity, int idUser){
    	
        if (entity == null || idUser <= 0)
        {
        	throw new NullPointerException();
        }

        int id_album = album.insert(entity);
        album.attachAlbumToUser(id_album, idUser);
    }

    public void delete(int idAlbum, int idUser) throws Exception{
    	
        if (idAlbum <= 0 || idUser <= 0)
        {
        	throw new Exception("�� ��������� ����� ID ��������!");
        }

        album.deleteAlbumToUser(idAlbum, idUser);

        PhotoBusiness photoBusiness = new PhotoBusiness();
        ArrayList<Photo> photos = photoBusiness.GetPhotosByIdAlbums(idAlbum);

        for (Photo photo : photos)
        {
            photoBusiness.Delete(photo.id, idAlbum);
        }

        album.delete(idAlbum);
    }

    public void update(Album entity) throws Exception{
    	
        if (entity.id <= 0)
        {
        	throw new Exception("�� ��������� ����� ID ��������!");
        }

        album.update(entity);
    }

    public ArrayList<Album> getAlbumsByIdUser(int idUser) throws Exception{
    	
        if (idUser <= 0){
        	throw new Exception("�� ��������� ����� ID ��������!");
        }
        
        return album.getAlbumsByIdUser(idUser);
    }
	
}
