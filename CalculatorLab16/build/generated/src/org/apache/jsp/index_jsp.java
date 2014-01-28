package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;

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
      out.write("<!DOCTYPE html>\n");
  String operation=null;
    String first = request.getParameter("firstNumber");
    String second = request.getParameter("secondNumber");
    Double firstOperand = null, secondOperand = null, result = null;

    if (first != null) {
        firstOperand = Double.valueOf(first);
    }
    if (second != null) {
        secondOperand = Double.valueOf(second);
    }
    Map parameters = request.getParameterMap();
    if ((firstOperand!=null)&(secondOperand!=null)){
    if (parameters.containsKey("add")) {
        result =firstOperand+secondOperand;
        operation="+";
    } else if (parameters.containsKey("sub")) {
        result =firstOperand-secondOperand;
        operation="-";
    } else if (parameters.containsKey("mult")) {
        result =firstOperand*secondOperand;
        operation="*";
    } else if (parameters.containsKey("divide")) {
        result =firstOperand/secondOperand;
        operation="/";
    }
}

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Simple calculator</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p>Enter two numbers and select operation</p>\n");
      out.write("        <form name=\"calc\" action=\"index.jsp\">\n");
      out.write("            <input type=\"text\" name=\"firstNumber\" value=\"");
if (request.getParameter("firstNumber") != null) {
                    out.print(request.getParameter("firstNumber"));
                } 
      out.write("\"/>\n");
      out.write("            <input type=\"text\" name=\"secondNumber\"  value=\"");
if (request.getParameter("secondNumber") != null) {
                    out.print(request.getParameter("secondNumber"));
                } 
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" value=\"+\" name=\"add\" />\n");
      out.write("            <input type=\"submit\" value=\"-\" name=\"sub\" />\n");
      out.write("            <input type=\"submit\" value=\"*\" name=\"mult\" />\n");
      out.write("            <input type=\"submit\" value=\"/\" name=\"divide\" />\n");
      out.write("        </form>\n");
      out.write("        ");
 if (result != null) {   
          out.print(firstOperand+operation+secondOperand+"="+result);
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
