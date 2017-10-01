<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../../css/demo.css" />
        <link rel="stylesheet" type="text/css" href="../../css/style.css" />
		<link rel="stylesheet" type="text/css" href="../../css/animate-custom.css" />
</head>
<body>
<body>
        <div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
             <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            <header>
                <h1>Tech Talk Updation Form </h1>				
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <a href="AdminHome.jsp">go back</a>
                        <div id="createTalk" class="form-horizontal">
                            <form  action="../../UpdateTalk" autocomplete="on"> 
                                <h1> Update Talk Details for TalkId: ${param.talkIdEmployee}</h1> 
                                <p> 
                                    <label class="control-label col-sm-2" for="Title" data-icon="u">Title *</label>
                                    <input id="Title" name="titleTalk" value=${param.talkTitleEmployee} type="text" placeholder= ${param.talkTitleEmployee}/>
                                </p>
                                <p> 
                                    <label class="control-label col-sm-2" for="Presenter" data-icon="u">Presenter *</label>
                                    <input id="Presenter" name="presenterTalk" value=${param.talkPresenterEmployee} type="text" placeholder=${param.talkPresenterEmployee} />
                                </p>
                                <p> 
                                    <label class="control-label col-sm-2" for="Venue" data-icon="u">Venue *</label>
                                    <input id="Venue" name="venueTalk" value=${param.talkVenueEmployee} type="text" placeholder=${param.talkVenueEmployee} />
                                </p>
                                <p> 
                                    <label class="control-label col-sm-2" for="Date">Tech Talk Date* </label>
                                    <input id="dateTalk" name="dateTalk" value=${param.talkDateEmployee} type="date" placeholder=${param.talkDateEmployee}/>
                                </p>
                                <p> 
                                    <label class="control-label col-sm-2" for="Time">Time *</label>
                                    <input id="timeTalk" name="timeTalk" value=${param.talkTimeEmployee} type="time" placeholder=${param.talkTimeEmployee} />
                                </p>
                                <p> 
                                    
                                    <label class="control-label col-sm-2" for="Description" data-icon="u">Description *</label>
                                    <textarea id="description" name="descriptionTalk" value=${param.talkDescriptionEmployee} type="text" placeholder=${param.talkDescriptionEmployee} ></textarea>
                                </p>
                                	<input type="hidden" name="talkIdEmployee" value=${param.talkIdEmployee}></input>
                                <p class="signin button">                                	 
									<input type="submit" value="Submit">
									 
									
								</p>  								
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>