<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer form page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<header style="color:white">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Customer Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="customer-list">Customer</a>
        </li>
      </ul>
      </div>
  </div>
</nav>
</header>
<div class="container" style="width:50%">

<c:if test="${customer==null}">
	<FORM action="IC" method="post">
	
   <center> <h1>Customer Form</h1></center>
  </c:if> 
<c:if test="${customer!=null}">
   <form action="EC" method="post">
   
   <h2>Edit Customer</h2>
   
  </c:if>  

 
 <div class="mb-3" hidden>

  <input value="<c:out value="${customer.id}"></c:out>"type="text" name="id" class="form-control" id="exampleFormControlInput4" >
</div> 
 
 <div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">NAME</label>
  <input value="<c:out value="${customer.name}"></c:out>" type="text" name="tbname" class="form-control" id="exampleFormControlInput1" placeholder="Enter your name" required="required">
</div> 
 
<div class="mb-3">
  <label for="exampleFormControlInput2" class="form-label">EMAIL</label>
  <input value="<c:out value="${customer.email}"></c:out>"type="email" name="tbemail" class="form-control" id="exampleFormControlInput2" placeholder="Enter your email">
</div>

<div class="mb-3">
  <label for="exampleFormControlInput3" class="form-label">MOBILE</label>
  <input value="<c:out value="${customer.mobile}"></c:out>"type="number" name="tbmobile" class="form-control" id="exampleFormControlInput3" placeholder="Enter your mobileno">
</div>
 
 <button type="submit" class="btn btn-success">SAVE</button>
</div>

	
	</FORM>

</body>
</html>