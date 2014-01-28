<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="errorMessage.jsp"%>
<!DOCTYPE html>
<%  String operation=null;
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
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple calculator</title>
    </head>
    <body>
        <p>Enter two numbers and select operation</p>
        <form name="calc" action="index.jsp">
            <input type="text" name="firstNumber" value="<%if (request.getParameter("firstNumber") != null) {
                    out.print(request.getParameter("firstNumber"));
                } %>"/>
            <input type="text" name="secondNumber"  value="<%if (request.getParameter("secondNumber") != null) {
                    out.print(request.getParameter("secondNumber"));
                } %>"/>
            <input type="submit" value="+" name="add" />
            <input type="submit" value="-" name="sub" />
            <input type="submit" value="*" name="mult" />
            <input type="submit" value="/" name="divide" />
        </form>
        <% if (result != null) {   
          out.print(firstOperand+operation+secondOperand+"="+result);
      }%>
    </body>
</html>
