package com.netcracker.labs.lab19.util;

import java.io.IOException;
import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class MessageServlet extends HttpServlet {

    @Resource(name = "connectionFactory19")
    private ConnectionFactory connectionFactory;

    @Resource(name = "queueDestination19")
    private Destination queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        try {
            send(message);
        } catch (JMSException ex) {
            throw new ServletException(ex);
        }
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    private void send(String text) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        try {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            producer.send(session.createTextMessage(text));
        } catch (UnsupportedOperationException ex) {
        } finally {
            connection.close();
        }
    }
}
