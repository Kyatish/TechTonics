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
		
		<title>Techtonics User</title>
	
</head>
<body>
	<div class="container">                       
			<div align="center" >
				<h3>${statusMessageUserTalk}</h3>
				<%-- <h3>${MytalkList}</h3> --%>							
        		<table border="5" cellpadding="10">
		            <caption><h1 align="center"><b>List of Upcoming Talks</b></h1></caption>
							
		            <tr>
		                <th>TalkId</th>
		                <th>Title</th>
		                <th>Presenter</th>
		                <th>Venue</th>
						<th>Date</th>
		                <th>Time</th>
		                <th>Description</th>		                
		            </tr>
		            <c:forEach var="talk" items="${MytalkList}">
					   <tr>
		                    <td><c:out value="${talk.talkId}" /></td>
		                    <td><c:out value="${talk.title}" /></td>
		                    <td><c:out value="${talk.presenter}" /></td>
		                    <td><c:out value="${talk.venue}" /></td>
							<td><c:out value="${talk.date}" /></td>
		                    <td><c:out value="${talk.time}" /></td>
		                    <td><c:out value="${talk.description}" /></td>							
							</form></td>
						</tr>
            		</c:forEach>
        			</table>
		<br><a href="employee.jsp">Go Back</a>
    </div>
	
	</body>
</html>