
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.netcracker.labs.lab19.dao.MessagesDAOLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="com.netcracker.labs.lab19.entities.Messages"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.PersistenceContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Messages</title>
    </head>
    <body>
        <%  
            String pAction = request.getParameter("action");
            String pDateFrom = request.getParameter("dateFrom") + " ";
            String pDateTo = request.getParameter("dateTo") + " ";
            String pTimeFrom = request.getParameter("timeFrom");
            String pTimeTo = request.getParameter("timeTo");
            Date dateTimeFrom = null;
            Date dateTimeTo = null;
            SimpleDateFormat formatOut = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
            SimpleDateFormat formatParser = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if ("search".equals(pAction)) {
                if ("".equals(pDateFrom) || "".equals(pDateTo) || "".equals(pTimeFrom) || "".equals(pTimeTo)) {
                    out.print("You should fill in all fields!");%>  <br>
        <%
        } else {
            String from = pDateFrom.concat(pTimeFrom);
            String to = pDateTo.concat(pTimeTo);
            dateTimeFrom = formatParser.parse(from);
            dateTimeTo = formatParser.parse(to);
            InitialContext ic = new InitialContext();
            MessagesDAOLocal localMsg = (MessagesDAOLocal) ic.lookup("java:comp/env/ejb/MessageRef");
            List<Messages> betweenMsg = null;
            betweenMsg = localMsg.findBetweenDates(dateTimeFrom, dateTimeTo);%>
        <h4>Messages between <%=formatOut.format(dateTimeFrom)%> and <%=formatOut.format(dateTimeTo)%></h4>
        <% if (betweenMsg.isEmpty()) {
                out.print("No messages found.");
            } else {%>
        <table  cellpadding="5" border="1" bordercolor="CCCCCC" ><thead><th>Message</th><th width="20%">Time</th></thead>
                <%for (Messages someMsg : betweenMsg) {%>
        <tr><td><%=someMsg.getMessage()%></td><td><%=formatOut.format(someMsg.getMessageTime())%></td></tr>
        <%
            }
        %>
    </table>
    <%}

            }
        }
    %>


    <br>
    <a href="index.jsp">back to main page</a>
</body>
</html>
