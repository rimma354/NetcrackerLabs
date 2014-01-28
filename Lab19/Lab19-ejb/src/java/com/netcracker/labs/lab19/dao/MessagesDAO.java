package com.netcracker.labs.lab19.dao;

import com.netcracker.labs.lab19.entities.Messages;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless (name="MsgBean")
public class MessagesDAO implements MessagesDAOLocal {

    @PersistenceContext(unitName = "Lab19-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Messages> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Messages> q = cb.createQuery(Messages.class);
        Root<Messages> c = q.from(Messages.class);
        q.select(c);
        return getEntityManager().createQuery(q).getResultList();
    }

    @Override
    public List<Messages> findBetweenDates(Date from, Date to) {
return em.createQuery("SELECT m FROM Messages m WHERE m.messageTime <= :to AND m.messageTime >= :from").setParameter("to", to).setParameter("from", from).getResultList();
    }
}
