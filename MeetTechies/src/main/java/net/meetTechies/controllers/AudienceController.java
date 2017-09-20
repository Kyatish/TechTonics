package net.meetTechies.controllers;

import net.meetTechies.pojos.Audience;
import net.meetTechies.pojos.MeetUp;
import net.meetTechies.pojos.User;
import net.meetTechies.services.AudienceServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
@RequestMapping(value="/audiences")
public class AudienceController {

	@Autowired
	AudienceServices audienceServices;
	/*@Autowired
	UserServices userServices;
	@Autowired
	MeetUpServices meetUpServices;*/
	/*@Autowired
	UsersRepository usersRepo;
	@Autowired
	MeetUpsRepository meetUpsRepo;*/
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody Audience audience ){		
		//if(usersRepo.exists(audience.getUserID()) && meetUpsRepo.exists(audience.getMeetUpId())){
		System.out.println(audience);
		int returnStatus = audienceServices.addAudience(audience);	
		if(returnStatus==1)
			return new ResponseEntity<>("Your Registration successful",HttpStatus.ACCEPTED);
		if(returnStatus==0)
			return new ResponseEntity<>("You are already registered for this Event",HttpStatus.ALREADY_REPORTED);			
		return new ResponseEntity<>("Does not exist",HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/allUsers/{meetUpId}")
	public ResponseEntity<?> getAllUsersForAMeetUp(@PathVariable int meetUpId){
		List<User> usersForAEvent = audienceServices.findUsersByMeetUpId(meetUpId);
		return new ResponseEntity<>(usersForAEvent,HttpStatus.OK);
	}
	
	@RequestMapping(value="/allEvents/{userID}")
	public ResponseEntity<?> getAllMeetUpsForAUser(@PathVariable int userID){
		List<MeetUp> eventsForAUser = audienceServices.findEventsByUserID(userID);
		return new ResponseEntity<>(eventsForAUser,HttpStatus.OK);
	}
	
	@RequestMapping(value="/all/user/{userID}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteByUserID(@PathVariable int userID){
		audienceServices.deleteAudiencesByUserID(userID);
		return new ResponseEntity<>("users deleted",HttpStatus.OK);
	}
	@RequestMapping(value="/all/meetup/{meetUpId}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteByMeetUpID(@PathVariable int meetUpId){
		audienceServices.deleteAudiencesByMeetUpId(meetUpId);
		return new ResponseEntity<>("users deleted",HttpStatus.OK);
	}
}
