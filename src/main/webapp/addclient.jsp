<%--
  Created by IntelliJ IDEA.
  User: Daniel Paredes
  Date: 20/6/2017
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <%--<%@include file="header.jsp" %>--%>
    <title>Usuarios</title>
</head>
<body>
<ol class="breadcrumb">
    <li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
    <li class="active">Add Pupil</li>
</ol>
<h1>Add Pupil</h1>
<form name="form" action="<%=request.getContextPath()%>/addclient" method="get">


    <div class="form-group">
        <label for="surname">Last Name</label>
        <input type="text" class="form-control" id="surname" placeholder="Nombre" name="lastname" />
    </div>

    <div class="form-group">
        <label for="name">Fist Name</label>
        <input type="text" class="form-control" id="name" placeholder="E-Mail" name="fisrtname" />
    </div>

    <div class="form-group">
        <label for="address">Address</label>
        <input type="text" class="form-control" id="address" placeholder="Nombre" name="address" />
    </div>

    <div class="form-group">
        <label for="phone">Phone</label>
        <input type="text" class="form-control" id="phone" placeholder="E-Mail" name="phone" />
    </div>

    <div class="form-group">
        <label for="correo">E-Mail</label>
        <input type="email" class="form-control" id="correo" placeholder="E-Mail" name="correo" />
    </div>





    <button type="submit" class="btn btn-success">Register</button>
</form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>