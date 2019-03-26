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
<link rel="stylesheet" href="form.css" type="text/css">
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<title>AcctType</title>
</head>
<body>



<ul class="topnav"  class="float-left">
  <li><a class="active" href="#home">A Bank</a></li>
  <li><a href="dashboard.jsp">Accounts</a></li>
  <li><a href="newTransaction.jsp">ATM Transaction</a></li>
  <li><a href="newTransfer.jsp">Transfers</a></li>
  <li><a href="#contact">Customer Service</a></li>
  <li><a href="accountTypeAddition.jsp">Open Additional Account</a></li>
  
  	<div class="float-right">
     <li><a href="login.jsp">Log Out</a></li>
  	</div>
</ul>


<div class="acctType">

<form action="NewAccountTypeServlet" method="post" class="w3-container w3-card-4">
      <br>
      <h2>Create New Account</h2>
	<br>
	<h2>Select the types of new account(s) do you want?</h2>
		<table >
  			<tr>
				<td></td>
				<td><input class="w3-check " type="checkbox" name="accountType" value="Checking">
  					<label>Checking</label>
				</td>
			</tr>
  			<tr>
				<td></td>
				<td><input class="w3-check " type="checkbox" name="accountType" value="Savings">
  					<label>Savings</label>
				</td>
			</tr>
  			<tr>
				<td></td>
				<td><input class="w3-check " type="checkbox" name="accountType" value="Credit">
  					<label>Credit</label>
				</td>
			</tr>	 		

		
			<tr>
				<td></td>
				<td><input type="submit" class="btn  btn-secondary" value="submit"/>
						<a href="dashboard.jsp" class="margin-left-40px"><u>Back to Main Accounts</u></a>
				</td>
			</tr>
		</table>
      <br>
 	${namsg}
 	  <br><br>
</form>

</div>
</body>
	
</html>

