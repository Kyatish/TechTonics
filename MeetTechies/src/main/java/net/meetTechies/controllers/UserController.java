package net.meetTechies.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.meetTechies.pojos.User;
import net.meetTechies.services.AudienceServices;
import net.meetTechies.services.UserServices;

//@CrossOrigin(origins = "*",allowedHeaders = "*", allowCredentials= "true",methods={RequestMethod.GET,RequestMethod.DELETE,
	//RequestMethod.POST,RequestMethod.PUT,RequestMethod.OPTIONS})

@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserServices userServices;
	@Autowired
	AudienceServices audiServices;
	
	@RequestMapping(value="/**",method=RequestMethod.OPTIONS)
	public ResponseEntity<?> handleOptionsRequest(HttpServletRequest request){
		System.out.println("In Options Request Method.");
		System.out.println(request.getMethod());
		return new ResponseEntity<>("Hi",HttpStatus.OK);
	}
	
	
	@RequestMapping(value="",method=RequestMethod.POST,headers="Accept=application/json",
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> registerUser(@RequestBody User userData){				
		User newUser = userData;
		System.out.println("before process  " + newUser);
		User user = userServices.addUser(newUser);
		//System.out.println("After Process"+ user);
		if(user!=null)		
			return new ResponseEntity<>(newUser,HttpStatus.OK);			
		else{
				String errorMessage = "Sorry invalid arguments";
				return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<?> login(@RequestBody User dummyUser){
		
		User user = userServices.getUser(dummyUser);
		if(user!=null){
			String msg = user.getUserID()+":"+user.getUserName();
			return new ResponseEntity<>(msg,HttpStatus.OK);
		}					
		else{
			//String errorMessage = "Sorry invalid arguments";
			return new ResponseEntity<>("0:Invalid",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<?> getUserByID(@PathVariable("id") int emailID){
		
		User user = userServices.getUserByUserID(emailID);
		if(user!=null){
			user.setPassword(null);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		else{
			String errorMessage = "Sorry invalid arguments";
			return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<?> getAllUserDetails(){
		
		ArrayList<User> userList = userServices.getAllUsers();
		if(!userList.isEmpty())
			return new ResponseEntity<>(userList,HttpStatus.OK);		
		else{
			String errorMessage = "No User is added yet";
			return new ResponseEntity<>(errorMessage,HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE,headers="Accept=application/json")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int userID){		
			if(userServices.deleteUser(userID)){
				audiServices.deleteAudiencesByUserID(userID);
				return new ResponseEntity<>("user deletion successful",HttpStatus.OK);
			}
			else{
			String errorMessage = "Sorry invalid arguments";
			return new ResponseEntity<>(errorMessage,HttpStatus.I_AM_A_TEAPOT);
		}
	}
}
