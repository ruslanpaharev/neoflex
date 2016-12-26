package presentation;

import java.util.ArrayList;

import business.AlbumBusiness;
import business.CommentBusiness;
import business.FriendBusiness;
import business.MessageBusiness;
import business.PhotoBusiness;
import business.UserBusiness;
import business.UserProfileBusiness;
import entities.Album;
import entities.Comment;
import entities.Friend;
import entities.Message;
import entities.Photo;
import entities.User;
import entities.UserProfile;
import support.SystemOutput;

public class ConsoleTest {

	public static void main(String[] args) {
						
		SystemOutput.setSystemOutputNullable();
		UserBusiness userBusiness = new UserBusiness();
						
		SystemOutput.setSystemOutputPrintable();
						
		ArrayList<Album> albumTable = new AlbumBusiness().getAll();
		System.out.println("albumTable: " + albumTable.size());
		
		ArrayList<Comment> commentTable = new CommentBusiness().getAll();
		System.out.println("commentTable: " + commentTable.size());
		
		ArrayList<Friend> friendTable = new FriendBusiness().getAll();
		System.out.println("friendTable: " + friendTable.size());
		
		ArrayList<Message> messageTable = new MessageBusiness().getAll();
		System.out.println("messageTable: " + messageTable.size());
		
		ArrayList<Photo> photoTable = new PhotoBusiness().getAll();
		System.out.println("photoTable: " + photoTable.size());
		
		ArrayList<User> userTable = new UserBusiness().getAll();
		System.out.println("userTable: " + userTable.size());
		
		ArrayList<UserProfile> profileTable = new UserProfileBusiness().getAll();
		System.out.println("profileTable: " + profileTable.size());
		
		System.out.println("");
		
		for (UserProfile item : profileTable) {
			System.out.println(item.idUser + "\t" + item.getName() + "\t" + item.getSurname());
		}
		
		System.out.println("");
		
		User user = new User();
		user.setLogin("myConsoleUser" + (int) (Math.random() * 1000000000));
		user.setPassword("123456");
		
		int id = userBusiness.Insert(user);
						
		java.util.List<User> users = userBusiness.getAll();
		
		System.out.println("Generated ID: " + id);
		System.out.println("\nUsers count: " + users.size() + "\n");
		
		for (User item : users) {
			System.out.println(item.id + "\t" + item.getLogin() + "\t" + item.getPassword());
		}
		
	}

}
