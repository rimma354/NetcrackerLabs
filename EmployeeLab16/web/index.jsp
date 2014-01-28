<%@page import="java.sql.*"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="errorMessage.jsp"%>
<!DOCTYPE html>
<%
     Locale.setDefault(Locale.ENGLISH);
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
              //  out.print("JDBC-Driver is OK!\n");
            } catch (ClassNotFoundException e) {
              //  out.print("JDBC-Driver is wrong!\n");
            }
            String url = new String("");
            try {
                url = "jdbc:oracle:thin:@localhost:1521:XE";
                String userid = "lab16";
                String userp = "lab16";
                Connection con = DriverManager.getConnection(url, userid, userp);
              //  out.println("Connection with URL=" + url + " is OK!");
                try {
                    Statement stm = con.createStatement();
                    String empno = request.getParameter("empId");
%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee info</title>
    </head>
    <body>
        <p>Please, enter employee id:</p>
        <form name="emp" action="index.jsp">
            <input type="text" name="empId"/>
            <input type="submit" name="search" value="search" />
        </form>
      <%
                        if (empno != null) {
                        int id = Integer.parseInt(empno);
                     //   out.println("SELECT - OK!");
                        ResultSet rz = stm.executeQuery("select first_name,last_name,salary, department_name from employees e,departments d where employee_id="+id+" and d.department_id=e.department_id");
                        String result = new String("");
                        out.println(id);
                            
                        while (rz.next()) {
                            result = "Employee: "+rz.getString(1)+" "+rz.getString(2)+", salary: "+rz.getInt(3)+", department: "+rz.getString(4);
                            out.print(result);
                        }
                        rz.close();
                        stm.close();
                    }
                } catch (SQLException er)
                {
                  //  out.println("SELECT is wrong!");
                }
                con.close();
            } catch (SQLException er) {
                //out.println("Connection  " + url + " is wrong!");
            }

        %>
    </body>
</html>
