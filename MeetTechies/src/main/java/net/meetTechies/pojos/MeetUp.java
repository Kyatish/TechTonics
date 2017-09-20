package net.meetTechies.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="meetups")
public class MeetUp implements Serializable{	
	@Override
	public String toString() {
		return "MeetUp [meetUpID=" + meetUpID + ", title=" + title + ", presenter=" + presenter + ", description="
				+ description + ", guest=" + guest + ", location=" + location + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue
	private int meetUpID;
	
	@NotNull
	private String title,presenter,description,guest,location;
	
	@NotNull//@Temporal(value = null)
	Date date;
	
	@NotNull
	Time startTime,endTime;
	
	//int numberOfAudiences;
	
	/*@ManyToMany(targetEntity=net.meetTechies.pojos.User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "audiences", joinColumns = {@JoinColumn(name = "meetUpID")}, inverseJoinColumns = 
				{@JoinColumn(name = "userID")})
	Set<User> audienceSet;

	
	public Set<User> getAudienceSet() {
		return audienceSet;
	}
	
	public void setAudienceSet(Set<User> audienceSet) {
		this.audienceSet = audienceSet;
	}
	
	public void addAudienceInSet(User user){
		audienceSet.add(user);
	}*/
	public MeetUp() {
		super();
		//audienceSet = new HashSet<User>();				
	}

	public int getMeetUpID() {
		return meetUpID;
	}

	/*public int getNumberOfAudiences() {
		return numberOfAudiences;
	}

	public void setNumberOfAudiences(int numberOfAudiences) {
		this.numberOfAudiences = numberOfAudiences;
	}*/

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

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + meetUpID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetUp other = (MeetUp) obj;
		if (meetUpID != other.meetUpID)
			return false;
		return true;
	}
	
}
