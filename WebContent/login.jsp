<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href='https://fonts.googleapis.com/css?family=Ubuntu:500' 
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="form.css" type="text/css">
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<title>Log In</title>
</head>
<body>

<ul class="topnav"  class="float-left">
  <li><a class="active" href="#home">A Bank</a></li>
  <li><a href="createAccount.jsp">Accounts</a></li>

  <li><a href="#contact">Pay Bills</a></li>
  <li><a href="#contact">Transfers</a></li>
  <li><a href="#contact">Customer Service</a></li>
  <li><a href="createAccount.jsp">Open New Account</a></li>
  
  <div class="float-right">
     <li><a href="login.jsp">Log In</a></li>
  </div>
</ul>

<!-- 
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">A Bank</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active"><a class="nav-link" href="#">Transfers<span class="sr-only">(current)</span></a></li>
      <li class="nav-item"> <a class="nav-link" href="#">Pay Bills</a></li>
      <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Accounts </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log In</button>
    </form>
  </div>
</nav>
-->

<div class="container">
    </div>


<form action="LoginServlet" method="get">
      <br>
      <h2>Log In</h2>
	<br>
			<table>
		
				<tr>
					<td>Email</td>
					<td><input type="text"   class="form-control"   placeholder="Email" name="email" required /></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><input type="password"   class="form-control"   placeholder="Password" name="password" autocomplete="new-password" required /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" class="btn  btn-secondary" />Submit</button>
						<a href="forgot.jsp" class="margin-left-40px"><u>Forgot Password</u></a>
					</td>
				</tr>
				</table>
      <br>
	${lmsg}
	 <br> <br>
    </form>

</body>
</html>


