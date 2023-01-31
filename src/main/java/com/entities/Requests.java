package com.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Requests", schema = "dbo", catalog = "La_biblioteca")
public class Requests {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "sendDate")
    private Date sendDate;
    @Basic
    @Column(name = "ReaderID")
    private int readerId;
    @Basic
    @Column(name = "ContactContent")
    private String contactContent;
    @Basic
    @Column(name = "IsChecked")
    private boolean isChecked;
    @ManyToOne
    @JoinColumn(name = "ReaderID", referencedColumnName = "ID", nullable = false)
    private Readers readersByReaderId;
    @OneToMany(mappedBy = "requestsByRequestId")
    private Collection<Respones> responesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getContactContent() {
        return contactContent;
    }

    public void setContactContent(String contactContent) {
        this.contactContent = contactContent;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Requests that = (Requests) o;

        if (id != that.id) return false;
        if (readerId != that.readerId) return false;
        if (isChecked != that.isChecked) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;
        if (contactContent != null ? !contactContent.equals(that.contactContent) : that.contactContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        result = 31 * result + readerId;
        result = 31 * result + (contactContent != null ? contactContent.hashCode() : 0);
        result = 31 * result + (isChecked ? 1 : 0);
        return result;
    }

    public Readers getReadersByReaderId() {
        return readersByReaderId;
    }

    public void setReadersByReaderId(Readers readersByReaderId) {
        this.readersByReaderId = readersByReaderId;
    }

    public Collection<Respones> getResponesById() {
        return responesById;
    }

    public void setResponesById(Collection<Respones> responesById) {
        this.responesById = responesById;
    }
}
