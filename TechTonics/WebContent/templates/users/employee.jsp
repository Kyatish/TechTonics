<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<style type="text/css">
			th {
				font-weight: bold;
   				text-align: center;
   				width: 2%;
   				height: 2%;
			}
			td {
				align: "center";
			}
		</style>
		
	<title>TechTonics Desk</title>
</head>
<body>
	<div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
                   Hello , <strong>${UserDetails.userName} </strong> 
                
                <span class="right">
                    <a href="../../LogOut">
                        <strong>LogOut</strong>
                    </a>
                </span>
                <span class="left">
                    <a href="../../FetchUpcomingTalksOfAUser">
                        <strong>MyUpcomingTalks</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
			<div align="center" >
				<h3>${statusMessage}</h3>
				<c:remove var="statusMessage" scope="session"/>
				<%-- <h3>${StatusMessage}</h3> --%>
        		<table border="5" cellpadding="20">
		            <caption><h1 align="center"><b>List of Upcoming Talks</b></h1></caption>
							
		            <tr>
		                <th><b>TalkId</b></th>
		                <th><b>Title</b></th>
		                <th><b>Presenter</b></th>
		                <th><b>Venue</b></th>
						<th><b>Date</b></th>
		                <th><b>Time</b></th>
		                <th><b>Description</b></th>
		                <th><b>Activities</b></th>
		            </tr>
		            <c:forEach var="talk" items="${talkLists}">
					<html:hidden property="talkId" value="${talk.talkId}"/>
		                <tr>
		                    <td><c:out value="${talk.talkId}" /></td>
		                    <td><c:out value="${talk.title}" /></td>
		                    <td><c:out value="${talk.presenter}" /></td>
		                    <td><c:out value="${talk.venue}" /></td>
							<td><c:out value="${talk.date}" /></td>
		                    <td><c:out value="${talk.time}" /></td>
		                    <td><c:out value="${talk.description}" /></td>							
							<td><form action="../../RegisterationForTalk" method = "post">
								<input type="hidden" name="talkIdEmployee" value="${talk.talkId}"></input>
								<input type="submit" name="Register" value="Register"></input>
							</form></td>
						</tr>
            </c:forEach>
        </table>
    </div>
</div>

	</body>
</html>