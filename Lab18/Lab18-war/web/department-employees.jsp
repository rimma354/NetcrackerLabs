<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page import="com.netcracker.labs.lab18.entities.Department"%>
<%@page import="com.netcracker.labs.lab18.facades.DepartmentFacadeLocal"%>
<%@page import="com.netcracker.labs.lab18.entities.Employee"%>
<%@page import="com.netcracker.labs.lab18.facades.EmployeeFacadeLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="errorMessage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <% 
            String idDept = request.getParameter("idDept");
            Integer idDepartment=Integer.valueOf(idDept);
            InitialContext ic = new InitialContext();
            DepartmentFacadeLocal localDepartment = (DepartmentFacadeLocal) ic.lookup("java:comp/env/ejb/DepartmentRef");
            Department dept=localDepartment.findById(idDepartment);
            EmployeeFacadeLocal localEmployee = (EmployeeFacadeLocal) ic.lookup("java:comp/env/ejb/EmployeeRef");
           // Collection <Employee> employees1=dept.getEmployees();
            List <Employee> employees=localEmployee.findByDepartment(dept);
        %>
        <h1><%out.print(dept.toString());%> </h1>
        <p>In this department work next employees:</p>
        <%
            for (Employee someEmp : employees) {%>
        <p> 
                 <% out.print(someEmp.toString());%>
        </p>
        <% }%>
        <p>Return to <a href="index.jsp">main page</a></p>
    </body>
</html>
