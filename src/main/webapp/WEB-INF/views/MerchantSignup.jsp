<!DOCTYPE html>
<html>
<head lang="en">

	 <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/getAddress.js"></script>

<script src="newsType.js"></script>
<script src="validation.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">News Group</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    </ul>
  </div>
</nav>
<div class="form-group form-group-lg container" class="container-fluid">
<form class="form-inline">
	<input id="name" class="form-control" placeholder="Name" type="text" name="name" required><br>
	<select id="gender" class="form-control" name="gender">
		<option value="male" selected>Male</option>
		<option value="female">Female</option>
		<option value="option">Other</option>
	</select><br>
	<input id="email" class="form-control" placeholder="Email" type="text" name="email" required><br>
	<input id="phone" name="phone" class="form-control" placeholder="Phone Number" type="number"  required><br>
	<select id="merchant_type" class="form-control" name="merchantType" onchange="getNewsType()">
		<option value="local" >Local</option>
		<option value="health">Health</option>
		<option value="bussiness">Bussiness</option>
		<option value="technical" selected>Technical</option>
		<option value="boxOffice">Box Office</option>
	</select><br>
	<select id="country" class="form-control" name="country">
		<option value="india">India</option>
	</select><br>
	
	<select class="form-control" id="state" name="state" onchange ="getDistrict()">
	</select>
	<select  id="district" class="form-control" name="district" onchange ="getCity()">		
	</select>
	<select class="form-control" id="city" name="city"></select><br>
	<textarea id="address" name="address" class="form-control" type="textarea"  rows="3" cols="20" placeholder="Address line"></textarea><br>
	<input id="dob" class="form-control" type="date" name="date_of_birth"><br>
	<input id="password" class="form-control" placeholder="Password" type="password" name="password" required><br>
	<input id="retype_password" class="form-control" placeholder="Retype Password" type="password" name="retype_password" required><br>
	<p id="error" class=""><a href="">Submit carefully</a></p>
</form>
<button class="btn btn-primary" onclick="merchantSignup()">Submit</button>
<p class=""><a href="freshheap.html">Alredy registerd? login</a></p>
</div>

<script src="<%=request.getContextPath() %>/resources/js/merchantSignup.js"></script>
<script type="text/javascript">window.onload=getNewsType();</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/signupSuccessfull.js"></script>
<h1 id="println"></h1>
</body>
</html>