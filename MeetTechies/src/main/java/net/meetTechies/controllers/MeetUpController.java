package net.meetTechies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.meetTechies.pojos.MeetUp;
import net.meetTechies.services.AudienceServices;
import net.meetTechies.services.MeetUpServices;
@CrossOrigin("*")
@RestController
@RequestMapping(value="/meetups")
public class MeetUpController {

	@Autowired
	MeetUpServices meetUpServices;
	@Autowired
	AudienceServices audiServices;
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<?> addMeetUp(@RequestBody MeetUp newMeetUp){
		MeetUp meetUp = meetUpServices.addMeetUp(newMeetUp);
		if(meetUp!=null)		
			return new ResponseEntity<>(meetUp,HttpStatus.OK);
			
		else{
				String errorMessage = "Sorry invalid arguments";
				return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
			} 
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> addMeetUp(@RequestBody MeetUp meetup,@PathVariable int id){
		MeetUp meetUp = meetUpServices.updateMeetUp(meetup,id);
		if(meetUp!=null)		
			return new ResponseEntity<>(meetUp,HttpStatus.OK);
			
		else{
				String errorMessage = "Sorry this id doesn't exist";
				return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
			} 
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMeetUp(@PathVariable int id){
		
		if(meetUpServices.deleteMeetUp(id)){	
			audiServices.deleteAudiencesByMeetUpId(id);
			return new ResponseEntity<>("Deletion Successful",HttpStatus.OK);
		}
		else{
				String errorMessage = "Sorry this id doesn't exist";
				return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
			} 
		
	}
	
	@RequestMapping(value="/all")
	public ResponseEntity<?> gettAllMeetUps(){
		return new ResponseEntity<>(meetUpServices.getAllUpcomingMeetUps(),HttpStatus.OK);		
	}	
	@RequestMapping(value="/{presenter}")
	public ResponseEntity<?> getHistoryOfAPresenter(@PathVariable String presenter){
		return new ResponseEntity<>(meetUpServices.getHistoryByPresenter(presenter),HttpStatus.OK);		
	}
}
