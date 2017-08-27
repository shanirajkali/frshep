<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/MerchantLogin.js"></script>

	<style type="text/css">
	html {
    font-family: "Lucida Sans", sans-serif;
}
		*{
			box-sizing: border-box;
		}
		body{
			margin: 0px;
			background-color:white;


		}
		
		.row::after{
			content: "";
			clear: both;
			display: table;
		

		}
		[class*="col-"]{
			padding: 0px;				}
			.col-1 {width: 8.33%;}
        	.col-2 {width: 16.66%;}
         	.col-3 {width: 25%;}
        	.col-4 {width: 33.33%;
        	}
        	.col-5 {width: 41.66%;}
        	.col-6 {width: 50%;}
          	.col-7 {width: 58.33%;
          	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
          	margin-left: 300px;}
			.col-8 {width: 66.66%;}
			.col-9 {width: 75%;}
			.col-10 {width: 83.33%;}
			.col-11 {width: 91.66%;}
			.col-12 {width: 100%;}
		
		.button {
				
   			 	background-color: #4CAF50; /* Green */
 				border-radius: 5px;
 				padding: 2px 0px;
  				text-decoration: none;
  				text-align: center;
  				margin:1px 2px;
    			font-size: 30px;
    			height: 40px;
    			display: inline;
    			float: right;
    			margin-top: 5px;
				}
		.header{
			height: 56px;
			float: right;
			overflow: hidden;
			background-color: black;
			border-radius: 10px;
		}
		.headeritem{
			height: 60px;
			float: left;
			overflow: hidden;

			
			
		}
		.loginarea{
			margin-top: 140px;
			height: 280px;
			margin-left: 280px;
			padding: 190px;
		}
		.hiddendiv{
			float: right;
			background-color: white;
			height: 400px;
			border:0px;
		}
		.middle{

			height: 170px;
			overflow: ;
			padding: 14px;
			border-radius: 14px;
			float: left;
			margin-top: 200px;
			align-items: center;
				box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
		}
		.mid{

			height: 560px;
			overflow: ;
			padding: 14px;
			border-radius: 14px;
			float: left;
			margin-top: 0px;
			align-items: center;
		}
		h1.headeritem{
			color: #D3D3D3;
			font-size: 20px;
		}

		li:hover{
			background-color: #555;
			color: black;
			border: 1px solid black;
		}
		ul{
			list-style-type: none;
			margin:0;
			padding: 0;
			background-color: black;
			overflow: hidden;
			border: 1px solid #e7e7e7;

		}
		#home{
			float: left;
		}
		li a{
			display: block;
			width: 120px;
			color:white;
			text-decoration: none;
			padding: 20px 16px;
			text-align: center;
			height: 60px;
			font-size: 20px;
		}
		li a:hover{
			background-color: #555;
			font-size: 14px;
			color: white;
		}

		#profile{
			float: right;
		}
		.sidebar{
			position: fixed;
			height: 900px;
			width: 0px;
			background-color:  #f3f3f3;
			overflow: hidden;
			right:0px;
			top:0px;
			border-radius: 10px;
			border: 1px solid #e7e7e7;
		}
		.profile{
			padding: 10px;
			border-radius: 10px;
		}
		#newsHeading{
			background-color: #4CAF50;


		}
		#newsDescription{
			background-color: #4CAF50;

		}
		.newspost{
			font-size: 25px;
			overflow: hidden;
			border-radius: 6px;
		}
		.NewsPostWarning{
			font-size: 15px;
			margin:0;
		}
		#login1{
			float: left;
		}
				@media only screen and (max-width: 500px) {
    body {
        background-color:;
    }
            .col-2 {width: 0%;}
            .col-4{width: 100%;}
            .col-5{width: 0%;}
            .col-7{width: 100%;
            	margin-left: 0px;}
            .middle{margin-top: -300px;}
}
	</style>
</head>




<body>
	
	<div id="raw1" class="row">
		<div class="col-12 header">	
			<ul>
				<li><a onclick="closeside()" href="#home" id="home">Home</a></li>
				<li><a href="#profile" id="profile" onclick="openside()">Profile &#9776;</a></li>
			</ul>
		</div>
	</div>

	<div id="raw2" class="row">
		<div class="col-4 hiddendiv" id="login1" ></div>
		
		<div class="" id="postedNews"></div>

		<div class="col-7 mid" id="posting">
			<textarea id="newsHeading" class="col-12 newspost" rows="3" minlength="60" maxlength="95" onkeyup="newsHeading()"></textarea>
			<p id="newsHeadingWarning" class="NewsPostWarning">Maximum character: 100 remaining: 100</p>
			<textarea id="newsDescription" class="col-12 newspost" rows="10" maxlength="390" onkeyup="newsDescription()"></textarea>
			<p id="newsDescriptionWarning" class="NewsPostWarning">Maximum character: 400 remaining: 400</p>
			<button class="col-4 button" onclick="newsPost()">Post It!</button>
			<p id="status"></p>
		</div>
		
		<div class="col-4 middle" id="login" >
			<input id="email" class="col-12 button" name="email"><br>
			<input id="pass" class="col-12 button" type="password" name=""><br>
			<button id="button" class=" col-9 button" onclick="login()">Log in</button>
			<p class=""><a href="<%=request.getContextPath() %>http://localhost:9000/frshep/account/signup">Not registerd?</a></p>
		</div>
		
		<div class="col-4 hiddendiv" id="login2"></div>
	</div>
	

	<div id="sidebar" class="sidebar">
		<p class="profile" id="close" onclick="closeside()">close &times;</p>
		<p class="profile" id="name"></p>
		<p class="profile" id="gender"></p>
		<p class="profile" id="check"></p>
		<p class="profile" id="phone"></p>
		<p class="profile" id="merchantType"></p>
		<p class="profile" id="address"></p>
		<button class="col-7 button" id="logout" onclick="logout()">Logout</button>

	</div>



<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/MerchantLogin.js"></script>	
<script type="text/javascript">
	
	function openside() {
		document.getElementById('sidebar').style.width="320px";
		document.getElementById('raw1').style.marginRight="320px";
		document.getElementById('raw2').style.marginRight="320px";
			}
	function closeside(){
		document.getElementById('sidebar').style.width="0px";
		document.getElementById('raw1').style.marginRight="0px";
		document.getElementById('raw2').style.marginRight="0px";
	}

	function newsHeading(){
		var x=document.getElementById('newsHeading').value.length;
		var rem=95-x;

		document.getElementById('newsHeadingWarning').innerHTML="Maximum character: 100 remaining: "+rem.toString();
		if(rem<20){
			document.getElementById('newsHeadingWarning').style.color="red";
		}
		else{
			document.getElementById('newsHeadingWarning').style.color="black";
		}
	}
	function newsDescription(){
		var x=document.getElementById('newsDescription').value.length;
		var rem=390-x;

		document.getElementById('newsDescriptionWarning').innerHTML="Maximum character: 400 remaining: "+rem.toString();
		if(rem<120){
			document.getElementById('newsDescriptionWarning').style.color="red";
		}
		else{
			document.getElementById('newsDescriptionWarning').style.color="black";
		}
	}
	window.onload=login();	
</script>	
</body>

</html>