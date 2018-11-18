package com.pyramidsystems.oc.intake.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

/**
 * Created by suhas on 11/18/2018.
 */

@Entity(name="request_log")
public class RequestLog {

    public RequestLog(){
        this.identifier = UUID.randomUUID().toString();
        this.setStatus("I");
        this.setCreatedDate(new Date());
    }

    @Id
    private String identifier;

    private String text;

    private String status;

    private Date createdDate;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
