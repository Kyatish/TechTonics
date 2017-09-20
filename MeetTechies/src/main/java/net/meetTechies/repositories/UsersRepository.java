package net.meetTechies.repositories;

import org.springframework.data.repository.CrudRepository;

import net.meetTechies.pojos.User;

public interface UsersRepository extends CrudRepository<User, Integer>{
	public User getUserByEmailIDAndPassword(String emailID,String password);
	public User getUserByEmailID(String emailID);
	//@Async
	//@Querry("Select * from users u where ")
}
