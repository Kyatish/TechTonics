package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.TechUser;
import utilities.DBUtilities;

public class TechUserDao {
	private Connection cn;
	private PreparedStatement pstAuthentication, pstInsert;
	public TechUserDao() throws Exception{
		cn = DBUtilities.getConnection();
		pstAuthentication = cn
				.prepareStatement("select emailid,password,name,date from TechUsers where  emailid= ? and Password= ?");
		pstInsert = cn
				.prepareStatement("insert into TechUsers (emailid,password,name,date) values (?,?,?,?)");
		System.out.println("dao created...");
		//pst3 = cn.prepareStatement("Select user_id from user where user_name = ?");
	}
	public void cleanUp() throws Exception
	{
		if (pstAuthentication != null)
			pstAuthentication.close();
		if (pstInsert != null)
			pstInsert.close();

		System.out.println("DAO cleaned Up");
	}
	public boolean setTechUserDetails(TechUser tecU) throws SQLException{
		int status;
		pstInsert.setString(1, tecU.getEmail());
		pstInsert.setString(2, tecU.getPassword());
		pstInsert.setString(3, tecU.getUserName());
		pstInsert.setDate(4, tecU.getDateOfSubscription());
		try{
			status = pstInsert.executeUpdate();
		}
		catch(SQLException e){
			return false;
		}
		if(status>0)
			return true;
		return false;
	}
	public TechUser getTechUserDetails(String email,String password) throws SQLException{
		TechUser techUser=null;
		pstAuthentication.setString(1, email);
		pstAuthentication.setString(2, password);
		try(ResultSet resultSet = pstAuthentication.executeQuery()){
			if(resultSet.next())
				techUser = new TechUser(resultSet.getString(1),resultSet.getString(3),resultSet.getString(2),resultSet.getDate(4));
			}catch(SQLException e){
				e.printStackTrace();
				return techUser;
		}
		return techUser;
	}
}
