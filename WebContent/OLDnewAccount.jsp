<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank New Customer</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<form class="container-fluid" action="NewAccountServlet"
method="post">

<div class="form-group">
<label for="firstName" class="required-field">First Name</label>
<p><input type="text" class="form-control" name="firstName" id="firstName"  placeholder="First Name" 
required autofocus></p>
</div>

<div class="form-group">
<label for="lastName" class="required-field">Last Name</label>
<p><input type="text" class="form-control" name="lastName" id="lastName"  placeholder="Last Name" 
required autofocus></p>
</div>

<div class="form-group">
<label for="telephone" class="required-field">Last Name</label>
<p><input type="text" class="form-control" name="telephone" id="telephone"  placeholder="Telephone" 
required autofocus></p>
</div>

<div class="form-group">
<label for="email" class="required-field">Email Address</label>
<p><input type="text" class="form-control" name="email" id="exampleInputEmail1"  placeholder="Email" 
required autofocus></p>
</div>

<div class="form-group">
<label for="password" class="required-field">Password</label>
<p><input type="text" class="form-control" name="password" id="password"  placeholder="Password" 
required autofocus></p>
</div>


<div class="form-group">
<label for="street">Street</label>
<p><input type="text" class="form-control" name="street" id="street"  placeholder="Street"></p>
</div>


<div class="form-group">
<label for="city">City</label>
<p><input type="text" class="form-control" name="city" id="city"  placeholder="City"></p>
</div>


<div class="form-group">
<label for="state">State</label>
<p><input type="text" class="form-control" name="state" id="state"  placeholder="State"></p>
</div>


<div class="form-group">
<label for="zip">Zip Code</label>
<p><input type="text" class="form-control" name="zip" id="zip"  placeholder="Zip Code"></p>
</div>

<div class="form-group">
<label for="accountNumber">Account Number</label>
<input type="text" class="form-control" name="accountNumber" id="accountNumber"  placeholder="Account Number"></input>
</div>

<div class="form-group">
<label for="tranNumber">Transaction Number(YYYYMMDD##)</label>
<input type="text" class="form-control" name="tranNumber" id="tranNumber"  placeholder="Transaction Number"></input>
</div>

<div class="form-group">
<label for="balance">Balance</label>
<input type="text" class="form-control" name="balance" id="balance"  placeholder="Balance"></input>
</div>

<div class="form-group">
<label for="tranAmount">Transaction Amount</label>
<input type="text" class="form-control" name="tranAmount" id="tranAmount"  placeholder="Transaction Amount"></input>
</div>

<div class="form-group">
<label for="accountType">Account Type</label>
	<select class="form-control" name="accountType" id="accountType" >
		<option value="c">Checking</option>
		<option value="s">Saving</option>
		<option value="cc">Credit Card</option>
	</select>
</div>


<div class="checkbox">
<label>
<p><input type="checkbox">Check me out</p>
</label>
</div>

<input type="submit" class="btn btn-success btn-lg active" value="Submit">

</form>>
</body>
</html>