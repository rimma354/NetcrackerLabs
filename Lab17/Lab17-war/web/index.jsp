<%@page import="com.netcracker.labs.CalculatorBeanLocal"%>
<%@page import="javax.naming.*, javax.ejb.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <%
            InitialContext ic = new InitialContext();
            CalculatorBeanLocal calc = (CalculatorBeanLocal) ic.lookup("java:comp/env/ejb/CalcRef");
            String pFirst = request.getParameter("firstNumber");
            String pSecond = request.getParameter("secondNumber");
            String pAction = request.getParameter("action");
            Double x = null;
            Double y = null;
            Double result = null;
            if (pAction != null) {

                try {
                    x = Double.parseDouble(pFirst);
                } catch (NumberFormatException e) {
                    x = 0.0;
                }
                calc.setX(x);
                try {
                    y = Double.parseDouble(pSecond);
                } catch (NumberFormatException e) {
                    y = 0.0;
                }
                calc.setY(y);

                if ("+".equals(pAction)) {
                    calc.add();
                } else if ("-".equals(pAction)) {
                    calc.substract();
                } else if ("/".equals(pAction)) {
                    calc.divide();
                } else if ("*".equals(pAction)) {
                    calc.multiply();
                }
                result = calc.getResult();
                if ("C".equals(pAction)) {
                    calc.clearMemory();
                } else if ("M".equals(pAction)) {
                    calc.saveInMemory();
                } else if ("M->x".equals(pAction)) {
                    calc.setXFromMemory();
                    x = calc.getX();
                } else if ("M->y".equals(pAction)) {
                    calc.setYFromMemory();
                    y = calc.getY();
                }
            }
        %>
        <p>Enter numbers and choose operation</p>
        <form name="calc" action="index.jsp">
            <input type="text" name="firstNumber" <% if (x != null) {%>value="<%=x%>"<%}%>/>
            <input type="text" name="secondNumber" <% if (y != null) {%> value="<%=y%>" <%}%>/>     
            <input type="submit" value="+" name="action" />
            <input type="submit" value="-" name="action" />
            <input type="submit" value="*" name="action" />
            <input type="submit" value="/" name="action" />
            <input type="submit" value="M" name="action" />
            <input type="submit" value="C" name="action" />
            <input type="submit" value="M->x" name="action" />
            <input type="submit" value="M->y" name="action" />
            <p><label>Result:</label></p>
            <input type="text" readonly <% if (result != null) {%> placeholder="<%=result%>"<%}%>/> 
        </form>
    </body>
</html>
