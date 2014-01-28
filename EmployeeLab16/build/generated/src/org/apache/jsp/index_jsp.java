package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.Locale;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"errorMessage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

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

      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employee info</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p>Please, enter employee id:</p>\n");
      out.write("        <form name=\"emp\" action=\"index.jsp\">\n");
      out.write("            <input type=\"text\" name=\"empId\"/>\n");
      out.write("            <input type=\"submit\" name=\"search\" value=\"search\" />\n");
      out.write("        </form>\n");
      out.write("      ");

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

        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
