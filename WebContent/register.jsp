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
       
        <b class="text-light"><% 
        		
        		String str = (String)session.getAttribute("enteredUserName");
        		out.print(str);
        		%></b>
      
        
      </li>
    </ul>
  </div>
</nav>
  <form action="/WebProgFinal/register" method="POST" class="justify-content-center">
      <!-- i choose check-login action and post method in this form we get email and password then we post check login page-->
      <div class="form-group">
        <label for="namelabel">NameAndSurname</label>
        <input
          type="name"
          class="form-control"
          id="name"
          name="name"
          aria-describedby="name"
          placeholder="Enter name"
        />
      </div>
      <div class="form-group">
        <label for="emaillabel">Email</label>
        <input
          type="email"
          class="form-control"
          id="email"
          name="email"
          aria-describedby="email"
          placeholder="Enter email"
        />
      </div>
      <div class="form-group">
        <label for="passwordlabel">Password</label>
        <input
          type="password"
          class="form-control"
          name="password"
          id="password"
          placeholder="Enter password"
        />
      </div>
      <small id="emailHelp" class="form-text text-muted"
        >We'll never share your information with anyone else.</small
      >
      <br />
      <button id="submitButton" type="submit" class="btn btn-dark">
        Register
      </button>
    </form>
</div>


</body>
</html>