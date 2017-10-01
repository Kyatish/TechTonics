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
			<div align="center" >
											
        		<table border="5" cellpadding="10">
		            <caption><h1 align="center"><b>${statusMessageFetchDetail}</b></h1></caption>							
		            <tr>
		                <th>Email</th>
		                <th>Name</th>		                
		            </tr>
		            <c:forEach var="audience" items="${audienceList}">					
		                <tr>
		                    <td><c:out value="${audience.email}" /></td>
		                    <td><c:out value="${audience.name}" /></td>		                    
							</form></td>
						</tr>						
            </c:forEach>
        </table>
		<br><button onclick = "window.close()">Close</button>
    </div>
	
	</body>
</html>