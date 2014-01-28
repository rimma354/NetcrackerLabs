
<%@page import="java.util.List"%>
<%@page import="com.netcracker.labs.lab18.entities.Department"%>
<%@page import="com.netcracker.labs.lab18.facades.DepartmentFacadeLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Locale.setDefault(Locale.ENGLISH);	%>
<%@page errorPage="errorMessage.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab18</title>
    </head>
    <body>
        <%  
            InitialContext ic = new InitialContext();
            DepartmentFacadeLocal localDepartment = (DepartmentFacadeLocal) ic.lookup("java:comp/env/ejb/DepartmentRef");
            List<Department> departments = localDepartment.findAll();
 
        %>
        <h1>Departments:</h1>
        <%
            for (Department someDept : departments) {%>
        <p> 
            <a href="department-employees.jsp?idDept=<%=someDept.getDepartmentId()%> ">
                <% out.print(someDept.getDepartmentName());%>
            </a> 
        </p>
        <% }%>

    </body>
</html>
