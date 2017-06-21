
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <%@include file="header.jsp" %>


    <title>Usuarios</title>
</head>
<body>
<h1>School Managment</h1>
<p>

</p>
<table class="table table-bordered">
    <thead>
    <th>Start Date</th>
    <th>End Date</th>
    <th>Course Code</th>
    <th>Location</th>
    <th>Accion</th>
    </thead>


        <tr>
            <td> AAAAA </td>
            <td> BBBBB </td>
            <td> CCCCC </td>
            <td> DDDDD </td>
            <td> <a href="<%=request.getContextPath()%>/addclient"><img src="img/add.png"></a> </td>
        </tr>



</table>
</body>
</html>