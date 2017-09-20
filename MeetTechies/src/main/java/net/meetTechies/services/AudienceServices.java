package net.meetTechies.services;

import net.meetTechies.pojos.Audience;
import net.meetTechies.pojos.MeetUp;
import net.meetTechies.pojos.User;
import net.meetTechies.repositories.AudiencesRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AudienceServices {
	@Autowired
	AudiencesRepository audRepo;
	@Autowired
	UserServices userServices;
	@Autowired
	MeetUpServices meetUpServices;
	public int addAudience(Audience audience){
		if(!(userServices.isUserIdExists(audience.getUserID()) && meetUpServices.isMeetUpIdExists(audience.getMeetUpId())))
			return -1;
		if(!isAudienceExist(audience.getUserID(),audience.getMeetUpId())){
			audRepo.save(audience);
			//meetUpServices.incrementAudience(audience.getMeetUpId());
			return 1;
		}		
		return 0;
		
		//return -1;
	}
	public boolean isAudienceExist(int userID,int meetUpID){
		Audience audience = audRepo.getAudienceByUserIDAndMeetUpId(userID, meetUpID);
		if(audience==null)
			return false;
		return true;
	}
	public List<User> findUsersByMeetUpId(int meetUpId){
		List<User> users = new ArrayList<>();
		List<Audience> audiences = audRepo.getAudienceByMeetUpId(meetUpId);
		for(Audience audience : audiences){
			users.add(userServices.getUserByUserID(audience.getUserID()));
		}
		return users;
	}
	public List<MeetUp> findEventsByUserID(int userID){
		List<MeetUp> meetUps = new ArrayList<>();
		List<Audience> audiences = audRepo.getAudienceByUserID(userID);
		System.out.println(audiences);
		for(Audience audience : audiences){
			meetUps.add(meetUpServices.getMeetUpById(audience.getMeetUpId()));
		}
		return meetUps;
	}
	public boolean deleteAudiencesByUserID(int userID){
		List<Audience> audiences = audRepo.getAudienceByUserID(userID);
		System.out.println(audiences.isEmpty());
		System.out.println(audiences);
		if(audiences.isEmpty())
			return false;
		audRepo.delete(audiences);
		return true;
	}
	public void deleteAudiencesByMeetUpId(int meetUpId){
		List<Audience> audiences = audRepo.getAudienceByMeetUpId(meetUpId);
		System.out.println(audiences);
		if(audiences!=null)
			audRepo.delete(audiences);
	}
}
