package net.meetTechies.pojos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="meetuphistory")
public class MeetUpHistory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue
	private int meetUpID;
	
	@NotNull
	private String title,presenter,description,guest,location;
	
	@NotNull//@Temporal(value = null)
	Date date;	
	
	int numberOfAudiences;

	public MeetUpHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMeetUpID() {
		return meetUpID;
	}

	public void setMeetUpID(int meetUpID) {
		this.meetUpID = meetUpID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumberOfAudiences() {
		return numberOfAudiences;
	}

	public void setNumberOfAudiences(int numberOfAudiences) {
		this.numberOfAudiences = numberOfAudiences;
	}	
	
}
