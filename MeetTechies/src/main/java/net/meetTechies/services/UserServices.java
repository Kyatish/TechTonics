package net.meetTechies.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.meetTechies.pojos.User;
import net.meetTechies.repositories.UsersRepository;

//@Transactional
@Repository
public class UserServices{

	@Autowired
	UsersRepository usersRepository;
	//@Autowired 
	//AudienceServices audServices;
	
	public User addUser(User newUser){
		User user=null;
		if(!isEmailExist(usersRepository,newUser.getEmailID()))
			try{
				user=usersRepository.save(newUser);
			}catch(Exception e){
				return user;
		}
		else{
			System.out.println("emailID already exist");
		}
		return user;
	}
	public User getUser(User dummyUser){
		User user=null;
		user=usersRepository.getUserByEmailIDAndPassword(dummyUser.getEmailID(),dummyUser.getPassword());
		
		return user;
	}
	public static boolean isEmailExist(UsersRepository ur,String email){				
		User user = ur.getUserByEmailID(email);
		if(user==null)
			return false;
		return true;
		
	}
	public User getUserByUserID(int userID){
		return usersRepository.findOne(userID);
	}
	public ArrayList<User> getAllUsers(){
		return (ArrayList<User>) usersRepository.findAll();
	}
	public boolean deleteUser(int userID){
		try{
			usersRepository.delete(userID);
		}catch(Exception e){
			return false;
		}
		//audServices.deleteAudiencesByUserID(userID);
		return true;
	}
	public boolean isUserIdExists(int userID){
		return usersRepository.exists(userID);
	}
}
