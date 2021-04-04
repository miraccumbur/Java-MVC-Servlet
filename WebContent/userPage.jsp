<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mircotech</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark m-1" >
  <a class="navbar-brand" href="/WebProgFinal/">MircoTech</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      
      
      <li class="nav-item active">
        <a class="nav-link" href="/WebProgFinal/logout">Logout</a>
      </li>

    
      <li class="nav-item active">
        <a class="nav-link" href="/WebProgFinal/login">Login</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/WebProgFinal/register">Register</a>
      </li>
     
      
      
      <li class="nav-item active">
        <a class="nav-link" href="/WebProgFinal/products">Products</a>
      </li>
      
      <li class="nav-item active">
        <a class="nav-link" href="/WebProgFinal/cart"><img src="https://img.icons8.com/bubbles/38/000000/buy.png"/></a>
      </li>
      <li style="width: 1100px;"></li>
      <li>
        
        <b class="text-light" ><% 
        		
        		String str = (String)session.getAttribute("enteredUserName");
        		out.print(str);
        		%></b>
        
        
      </li>
    </ul>
  </div>
</nav>
<br>
<h3>This is your user page</h3>
</body>
</html>