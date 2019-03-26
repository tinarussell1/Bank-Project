<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.user.Customer" %>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<%@ page import="com.user.Account" %>
<% Account account = (Account) session.getAttribute("account"); %>
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
<title>Reset</title>
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



<div class="container">
</div>


<form action="DashboardServlet" method="get">
    <div class="float-right">
	<h2><a type="submit" href="newTransaction.jsp"  class="btn  btn-secondary" role="button"/>Make a Transaction</a></h2>
	</div>
      <h1>Account Summary for <% out.print(customer.getFirstName()); %></h1>
      
	 <h3>Personal Checking, Savings, and Credit Accounts</h3>
</form>
					
				<c:forEach var="account" items="${customer.getAccounts()}">
				<br>		
					<div class="w3-container w3-card-4"><br>
						<table class="table "  >
						<tr>
							<th><c:out value="${account.accountType}"/></th>
							<th></th>	
							<th></th><th></th>		
							<th>Balance</th>
							<th><c:out value="${account.accountBalance}"/></th><th>     </th>
						</tr>	
						<tr>
							<th>Acct No:  <c:out value="${account.accountNumber}"></c:out></th>
							<th>Transaction Number</th>			
							<th>Withdraw Amount</th>
							<th>Deposit Amount</th>
							<th></th>
							<th>Balance</th>
						</tr>	
						
						<c:forEach items="${account.getTransactions()}"  var="transaction" >
						<tr>
							<td><c:out value="${transaction.tranDate}"/></td>
							<td><c:out value="${transaction.tranNumber}"/></td>
							<td><c:out value="${transaction.tranAmount}"/></td>
							<td><c:out value="${transaction.tranAmount}"/></td><td></td>
							<td><c:out value="${transaction.tranBalance}"/></td>
						</tr>
						</c:forEach>	
						</table>
					</div>
				</c:forEach>	
				
					<br>
					<br>
      <br>
	${dmsg}
	 <br> <br>


</body>
</html>