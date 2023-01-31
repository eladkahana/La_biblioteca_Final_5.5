package com.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Respones", schema = "dbo", catalog = "La_biblioteca")
public class Respones {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "answer")
    private String answer;
    @Basic
    @Column(name = "sendDate")
    private Date sendDate;
    @Basic
    @Column(name = "requestID")
    private int requestId;
    @ManyToOne
    @JoinColumn(name = "requestID", referencedColumnName = "ID", nullable = false)
    private Requests requestsByRequestId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Respones that = (Respones) o;

        if (id != that.id) return false;
        if (requestId != that.requestId) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        result = 31 * result + requestId;
        return result;
    }

    public Requests getRequestsByRequestId() {
        return requestsByRequestId;
    }

    public void setRequestsByRequestId(Requests requestsByRequestId) {
        this.requestsByRequestId = requestsByRequestId;
    }
}
