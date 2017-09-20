package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Audience;
import utilities.DBUtilities;

public class AudienceDao {
	private Connection cn;
	private PreparedStatement pstSelectByTalkId, pstInsert;

	public AudienceDao() throws Exception {
		cn = DBUtilities.getConnection();
		pstSelectByTalkId = cn
				.prepareStatement("select * from Audiences where talkid = ?");
		pstInsert = cn
				.prepareStatement("insert into Audiences (emailid,talkid,name) values (?,?,?)");
		System.out.println("dao created...");
	}

	public void cleanUp() throws Exception {
		if (pstSelectByTalkId != null)
			pstSelectByTalkId.close();
		if (pstInsert != null)
			pstInsert.close();

		System.out.println("DAO cleaned Up");
	}

	public boolean insertNewAudience(Audience audience) {
		int status;
		try {
			pstInsert.setString(1, audience.getEmail());
			pstInsert.setInt(2, audience.getTalkid());
			pstInsert.setString(3, audience.getName());
			status = pstInsert.executeUpdate();
			if (status > 0)
				return true;
		} catch (SQLException e) {
			return false;
			// e.printStackTrace();

		}
		return false;
	}

	public List<Audience> getAudienceById(int talkId) throws SQLException {
		List<Audience> audienceList = new ArrayList<>();
		ResultSet resultSet;
		pstSelectByTalkId.setInt(1, talkId);
		resultSet = pstSelectByTalkId.executeQuery();
		while (resultSet.next())
			audienceList.add(new Audience(resultSet.getInt(2), resultSet
					.getString(1), resultSet.getString(3)));
		return audienceList;
	}
}
