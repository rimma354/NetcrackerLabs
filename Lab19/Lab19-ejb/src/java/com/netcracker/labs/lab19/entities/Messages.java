package com.netcracker.labs.lab19.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "MESSAGES")
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByMessageId", query = "SELECT m FROM Messages m WHERE m.messageId = :messageId")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "MESSAGE_ID")
    @SequenceGenerator(name = "MESSAGE_ID", sequenceName = "MESSAGE_ID", allocationSize = 1)
    @NotNull
    @Column(name = "MESSAGE_ID")
    private Integer messageId;
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MESSAGE")
    private String message;
    @NotNull
    @Column(name = "MESSAGE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date messageTime;

    public Messages() {
    }


    public Messages(String message, Date messageTime) {
        this.message = message;
        this.messageTime = messageTime;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (messageId != null) {
            hash += messageId.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        return (this.messageId.equals(other.messageId));
    }

    @Override
    public String toString() {
        return "messageId = " + messageId + ", message = "+message+", date/time = "+messageTime;
    }
    
}
