package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.UpcomingTalk;
import utilities.DBUtilities;

public class UpcomingTalkDao {
	private Connection cn;
	private PreparedStatement pstSelect, pstInsert,pstUpdate,pstSelectById,pstDelete;
	public UpcomingTalkDao() throws Exception{
		cn = DBUtilities.getConnection();
		pstSelect = cn
				.prepareStatement("select * from Upcoming_Talks where date>= curdate()");
		pstInsert = cn
				.prepareStatement("insert into Upcoming_Talks (title,presenter,venue,date,time,description) values (?,?,?,?,?,?)");
		pstUpdate = cn
				.prepareStatement("Update Upcoming_Talks set title=?,presenter=?,venue=?,date=?,time=?,description=? where talkId=?");
		pstSelectById = cn.prepareStatement("select u.talkid,u.title,u.presenter,u.venue,u.date,u.time,u.description from Upcoming_Talks u,Audiences a,techusers t "+ 
											"where a.emailid=t.emailid and u.talkid=a.talkid and u.date>= curdate() and t.emailid = ? "+
											"order by u.date");
		pstDelete = cn.prepareStatement("Delete from Upcoming_Talks WHERE talkid=?");
		System.out.println("dao created...");
		//pst3 = cn.prepareStatement("Select user_id from user where user_name = ?");
	}
	public void cleanUp() throws Exception
	{
		if (pstSelect != null)
			pstSelect.close();
		if (pstInsert != null) 
			pstInsert.close();
		if (pstUpdate != null)
			pstUpdate.close();
		if (pstSelectById != null)
			pstSelectById.close();
		if (pstDelete != null)
			pstDelete.close();

		System.out.println("DAO cleaned Up");
	}
	
	public boolean setNewTechTalk(UpcomingTalk upcomingTalk) throws SQLException{
		int status;
		pstInsert.setString(1, upcomingTalk.getTitle());
		pstInsert.setString(2, upcomingTalk.getPresenter());
		pstInsert.setString(3, upcomingTalk.getVenue());
		pstInsert.setDate(4, upcomingTalk.getDate());
		pstInsert.setTime(5, upcomingTalk.getTime());
		pstInsert.setString(6, upcomingTalk.getDescription());
		status = pstInsert.executeUpdate();
		if(status>0)
			return true;
		return false;
	}
	public List<UpcomingTalk> getAllUpcomingTalks() throws SQLException{
		List<UpcomingTalk> talkList = new ArrayList<>();
		try(ResultSet resultSet = pstSelect.executeQuery()){			
			while(resultSet.next())
				talkList.add(new UpcomingTalk(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDate(5),resultSet.getTime(6),resultSet.getString(7)));
			}catch(SQLException e){
				e.printStackTrace();
				//return talkList;
		}
		return talkList;
	}
	public boolean updateTalkById(UpcomingTalk upcomingTalk,int talkId) throws SQLException{
		int status;
		pstUpdate.setString(1, upcomingTalk.getTitle());
		pstUpdate.setString(2, upcomingTalk.getPresenter());
		pstUpdate.setString(3, upcomingTalk.getVenue());
		pstUpdate.setDate(4, upcomingTalk.getDate());
		pstUpdate.setTime(5, upcomingTalk.getTime());
		pstUpdate.setString(6, upcomingTalk.getDescription());
		pstUpdate.setInt(7, talkId);
		status = pstUpdate.executeUpdate();
		if(status>0)
			return true;
		return false;		
	}
	public List<UpcomingTalk> getUpcomingTalksByEmailId(String email) throws SQLException{
		List<UpcomingTalk> talkList = new ArrayList<>();
		pstSelectById.setString(1, email);
		try(ResultSet resultSet = pstSelectById.executeQuery()){			
			while(resultSet.next()){
				talkList.add(new UpcomingTalk(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDate(5),resultSet.getTime(6),resultSet.getString(7)));
			}
		}catch(SQLException e){			
			e.printStackTrace();
				//return talkList;
		}
		return talkList;
	}
	public boolean deleteTalkById(int id) throws SQLException{
		pstDelete.setInt(1, id);
		int statusValue=pstDelete.executeUpdate();
		if(statusValue>0)
			return true;
		return false;
	}
}
