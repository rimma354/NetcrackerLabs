package com.netcracker.labs.lab19.mdbs;

import com.netcracker.labs.lab19.entities.Messages;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(mappedName = "queueDestination19")
public class MessageBean implements MessageListener {

    public MessageBean() {
    }

    @Resource
    private MessageDrivenContext mdc;

    @PersistenceContext(unitName = "Lab19-ejbPU")
    private EntityManager em;

    public void onMessage(Message message) {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println("A Message received: "+ msg.getText()+" at "+format1.format(d));
                Messages newMessage=new Messages(msg.getText(), d);
                em.persist(newMessage);
               // em.flush();
            } else {
                System.out.println("Message of wrong type: "+ message.getClass().getName());

            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
