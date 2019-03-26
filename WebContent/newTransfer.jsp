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
<title>New Transfer</title>
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


<div >

<form action="NewTransferServlet" class="w3-container w3-card-4" method="post">
      <br>
      <h2>New Transfer </h2>
            <br>    <br>
      <table>

      			<tr>
					<td>From Account: </td>
					<td><select  name='FromAccount'   class="form-control margin-right-5px" >
						<c:forEach var="account" items="${customer.getAccounts()}">
							<option value="${account.accountNumber}"  ${account.accountNumber == SelectedAcctNo ? 'selected="selected"' : '' } ><c:out value="${account.accountType}"/> <c:out value="${account.accountNumber}"/> <c:out value="${account.accountBalance}"/> </option>
						</c:forEach>
					</select>	
					</td>
				</tr>
				      			<tr>
					<td>To Account: </td>
					<td><select  name='ToAccount'   class="form-control" >
						<c:forEach var="account" items="${customer.getAccounts()}">
							<option value="${account.accountNumber}"  ${account.accountNumber == SelectedAcctNo ? 'selected="selected"' : '' } ><c:out value="${account.accountType}"/> <c:out value="${account.accountNumber}"/> <c:out value="${account.accountBalance}"/> </option>
						</c:forEach>
					</select>	
					</td>
				</tr>
				<br>
				
				<tr>
					<td>Transfer Amount</td>
					<td><input type="text"   class="form-control"   placeholder="Transfer Amount" name="tranAmount" required /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" class="btn  btn-secondary" value="submit"/>
						<a href="dashboard.jsp" class="margin-left-40px"><u>Back to Main Accounts</u></a>
					</td>
				</tr>
				</table>
      <br>
	${tfrmsg}
	 <br> <br>
</form>
</div>
</body>
</html>


