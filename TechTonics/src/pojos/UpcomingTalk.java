package pojos;

import java.sql.Date;
import java.sql.Time;

public class UpcomingTalk {
	int talkId;
	String title, presenter, venue;
	Date date;
	Time time;
	String description;
	
	public UpcomingTalk(int talkId, String title, String presenter, String venue, Date date, Time time,
			String description) {
		super();
		this.talkId = talkId;
		this.title = title;
		this.presenter = presenter;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	
	public UpcomingTalk(String title, String presenter, String venue, Date date, Time time, String description) {
		super();
		this.title = title;
		this.presenter = presenter;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	
	public UpcomingTalk(int talkId) {
		super();
		this.talkId = talkId;
	}

	public int getTalkId() {
		return talkId;
	}
	public void setTalkId(int talkId) {
		this.talkId = talkId;
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
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "UpcomingTalk [talkId=" + talkId + ", title=" + title + ", presenter=" + presenter + ", venue=" + venue
				+ ", date=" + date + ", time=" + time + ", description=" + description + "]";
	}
}
