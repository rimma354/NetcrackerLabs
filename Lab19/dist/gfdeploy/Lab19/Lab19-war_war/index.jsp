<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message sender</title>
    </head>
    <body>
        <form method="GET" action="send">
            <p>Enter your message: </p>
            <p>
                <input type="text" name="message" size="100"> 
                <input type="submit" value="Send">
            </p>
        </form>
        <form method="GET" action="messages.jsp">
            <p>Searching messages during period</p>
            <p>
               From: <input type="date" name="dateFrom"> <input type="time" name="timeFrom"> 
               To: <input type="date" name="dateTo"> <input type="time" name="timeTo">
               <button  type="submit" name="action" value="search">Search</button>
            </p>
        </form>
    </body>
</html>
