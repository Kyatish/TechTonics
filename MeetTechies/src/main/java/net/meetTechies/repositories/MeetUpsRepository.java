package net.meetTechies.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import net.meetTechies.pojos.MeetUp;

public interface MeetUpsRepository extends CrudRepository<MeetUp,Integer>{
	public List<MeetUp> getMeetUpsByPresenter(String presenter);
	
	@Async
	@Query("from MeetUp as m where m.date>=current_date()")
	List<MeetUp> findAllUpcomingMeetUps();
	@Async
	@Query("from MeetUp as m where m.date<current_date and m.presenter = :presenter")
	List<MeetUp> findHistoryOfAPresenter(@Param(value = "presenter") String presenter);
	
	/*@Async
	@Query("update MeetUp m set m.numberOfAudiences = ?1 where m.meetUpID = ?2 ")
	void updateAudienceNumber(@Param(value="numberOfAudiences") int numberOfAudiences,
								@Param(value="meetUpId") int meetUpId);*/
}
