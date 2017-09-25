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
		
		<title>Techtonics Admin Home</title>
</head>
<body>
	<div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
                   <strong>${UserDetails.userName} </strong>   You are an administrator
                <span class="left">
                    <a href="CreateNewTalk.html" target = "_blank">
                        <strong>Create New Talk</strong>
                    </a>
                </span>
                <span class="right">
                    <a href="../../LogOut">
                        <strong>LogOut</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
     <!-- <div align = left>
     	<form action="CreateNewTalk.html" method = "post">		
		<input type="submit" name="Create New Talk" value="NewTalk">
		</form>
     </div> -->
	<div align="center">
	<h3>${StatusMessage}</h3>
        <table border="1" cellpadding="5">
           <caption><h1 align="center"><b>List of Upcoming Talks</b></h1></caption>
            <tr>
                <th>TalkId</th>
                <th>Title</th>
                <th>Presenter</th>
                <th>Venue</th>
				<th>Date</th>
                <th>Time</th>
                <th>Description</th>
				<th>Activity</th>
                
            </tr>
            <c:forEach var="talk" items="${talkLists}">
                <tr>
                    <td><a href ="../../FetchRecordsofATalk?Id=${talk.talkId}" target="_blank"><c:out value="${talk.talkId}" /></a></td>
                    <td><c:out value="${talk.title}" /></td>
                    <td><c:out value="${talk.presenter}" /></td>
                    <td><c:out value="${talk.venue}" /></td>
					<td><c:out value="${talk.date}" /></td>
                    <td><c:out value="${talk.time}" /></td>
                    <td><c:out value="${talk.description}" /></td>
					<td><form action="UpdateTalk.jsp" method = "post">
							<input type="hidden" name="talkIdEmployee" value="${talk.talkId}"/>
							<input type="hidden" name="talkTitleEmployee" value="${talk.title}"/>
							<input type="hidden" name="talkPresenterEmployee" value="${talk.presenter}"/>
							<input type="hidden" name="talkVenueEmployee" value="${talk.venue}"/>
							<input type="hidden" name="talkDateEmployee" value="${talk.date}"/>
							<input type="hidden" name="talkTimeEmployee" value="${talk.time}"/>
							<input type="hidden" name="talkDescriptionEmployee" value="${talk.description}"/>
							<input type="submit" name="Update" value="Update"/>
					</form>
					<form action="../../DeleteTalk" method = "get">
							<input type="hidden" name="talkIdEmployee" value="${talk.talkId}"></input>
							<input type="submit" name="deleteTalk" value="Delete"></input>
					</form></td> 
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>