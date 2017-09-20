package net.meetTechies.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//@JsonProperty
	@Id@GeneratedValue
	private int userID;
	
	//@JsonProperty
	@Column(nullable=false,unique=true)@Email
	String emailID;
	
	//@JsonProperty
	@Column(nullable=false)
	private String password;
	
	//@JsonProperty
	@NotNull
	private String company;
	
	//@JsonProperty
	@NotNull
	private String companyAddress;
	
	//@JsonProperty
	private String technicalCapabilities;
	
	//@JsonProperty
	@NotNull
	private long mobileNumber;
	
	//@JsonProperty
	@NotNull
	private String userName;
	
	//@JsonProperty
	private int yearsOfExperience;
	
	/*@ManyToMany(mappedBy = "audienceSet")
	Set<MeetUp> participatingEvents;*/

	public User() {
		super();		
	}	

	
	/*public Set<MeetUp> getParticipatingEvents() {
		return participatingEvents;
	}

	public void setParticipatingEvents(Set<MeetUp> participatingEvents) {
		this.participatingEvents = participatingEvents;
	}
	
	public void addParticipatingEvents(MeetUp meetUp){
		participatingEvents.add(meetUp);
	}*/

	public User(String email) {
		emailID = email;
	}	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getTechnicalCapabilities() {
		return technicalCapabilities;
	}

	public void setTechnicalCapabilities(String technicalCapabilities) {
		this.technicalCapabilities = technicalCapabilities;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
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
		User other = (User) obj;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", emailID=" + emailID + ", password=" + password + ", company=" + company
				+ ", companyAddress=" + companyAddress + ", technicalCapabilities=" + technicalCapabilities
				+ ", mobileNumber=" + mobileNumber + ", userName=" + userName + ", yearsOfExperience="
				+ yearsOfExperience + "]";
	}
	
}
