package com.netcracker.labs.lab19.dao;

import com.netcracker.labs.lab19.entities.Messages;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MessagesDAOLocal {

    List<Messages> findAll();
    List<Messages> findBetweenDates(Date from, Date to);
}
