package net.meetTechies.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.meetTechies.pojos.MeetUp;
import net.meetTechies.repositories.MeetUpsRepository;

//@Transactional
@Repository
public class MeetUpServices {
	@Autowired
	MeetUpsRepository meetUpRepo;
	//@Autowired 
	AudienceServices audServices;
	
	public MeetUp addMeetUp(MeetUp newMeetUp){		
		//MeetUp meetUp =null;
		try{
			return meetUpRepo.save(newMeetUp);		
		}
		catch(Exception e){
			return null;
		}
	}
	public List<MeetUp> getAllMeetUps(){
		return (List<MeetUp>) meetUpRepo.findAll();
	}
	public List<MeetUp> getAllUpcomingMeetUps(){		
		return meetUpRepo.findAllUpcomingMeetUps();
	}
	public boolean deleteMeetUp(int id){
		
		try{
			meetUpRepo.delete(id);
			//return true;
		}catch(Exception e){
			return false;
		}
		//audServices.deleteAudiencesByMeetUpId(id);
		return true;
	}
	
	public boolean isMeetUpIdExists(int meetUpID){
		return meetUpRepo.exists(meetUpID);
	}
	public MeetUp updateMeetUp(MeetUp meetUp,int meetUpID){
		//MeetUp meetUpTemp=null;
		try{
			//meetUpTemp=meetUpRepo.findOne(meetUpID);
			meetUp.setMeetUpID(meetUpID);
			meetUp = meetUpRepo.save(meetUp);
		}
		catch (Exception e){			
		}
		return meetUp;
	}
	public MeetUp getMeetUpById(int meetUpId){
		return meetUpRepo.findOne(meetUpId);
	}
	public List<MeetUp> getHistoryByPresenter(String presenter){
		return meetUpRepo.findHistoryOfAPresenter(presenter);
	}
	/*public void incrementAudience(int meetUpId){
		MeetUp meetUp = meetUpRepo.findOne(meetUpId);
		meetUpRepo.updateAudienceNumber(meetUp.getNumberOfAudiences()+1, meetUpId);
	}*/
}
