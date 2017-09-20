package net.meetTechies.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="audiences",uniqueConstraints ={@UniqueConstraint(columnNames={"meetUpId","userID"})})
public class Audience {
	@Id@GeneratedValue
	private int audienceID;
	@Column(nullable=false)
	private int meetUpId,userID;
	//private int userID;
	public Audience() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getAudienceID() {
		return audienceID;
	}


	public void setAudienceID(int audienceID) {
		this.audienceID = audienceID;
	}


	public int getMeetUpId() {
		return meetUpId;
	}
	public void setMeetUpId(int meetUpId) {
		this.meetUpId = meetUpId;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "Audience [meetUpId=" + meetUpId + ", userID=" + userID + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + audienceID;
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
		Audience other = (Audience) obj;
		if (audienceID != other.audienceID)
			return false;
		return true;
	}	
	
}
