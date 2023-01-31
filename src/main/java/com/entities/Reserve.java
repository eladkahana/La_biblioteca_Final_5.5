package com.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Reserve", schema = "dbo", catalog = "La_biblioteca")
public class Reserve {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "reserveDate")
    private Date reserveDate;
    @Basic
    @Column(name = "DueDate")
    private Date dueDate;
    @Basic
    @Column(name = "ReturnDate")
    private Date returnDate;
    @Basic
    @Column(name = "ReaderID")
    private int readerId;
    @Basic
    @Column(name = "BookID")
    private int bookId;
    @Basic
    @Column(name = "extensionID")
    private Integer extensionId;
    @ManyToOne
    @JoinColumn(name = "ReaderID", referencedColumnName = "ID", nullable = false)
    private Readers readersByReaderId;
    @ManyToOne
    @JoinColumn(name = "extensionID", referencedColumnName = "ID")
    private Reserve reserveByExtensionId;
    @OneToMany(mappedBy = "reserveByExtensionId")
    private Collection<Reserve> reservesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Integer getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(Integer extensionId) {
        this.extensionId = extensionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserve that = (Reserve) o;

        if (id != that.id) return false;
        if (readerId != that.readerId) return false;
        if (bookId != that.bookId) return false;
        if (reserveDate != null ? !reserveDate.equals(that.reserveDate) : that.reserveDate != null) return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null) return false;
        if (extensionId != null ? !extensionId.equals(that.extensionId) : that.extensionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reserveDate != null ? reserveDate.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + readerId;
        result = 31 * result + bookId;
        result = 31 * result + (extensionId != null ? extensionId.hashCode() : 0);
        return result;
    }

    public Readers getReadersByReaderId() {
        return readersByReaderId;
    }

    public void setReadersByReaderId(Readers readersByReaderId) {
        this.readersByReaderId = readersByReaderId;
    }

    public Reserve getReserveByExtensionId() {
        return reserveByExtensionId;
    }

    public void setReserveByExtensionId(Reserve reserveByExtensionId) {
        this.reserveByExtensionId = reserveByExtensionId;
    }

    public Collection<Reserve> getReservesById() {
        return reservesById;
    }

    public void setReservesById(Collection<Reserve> reservesById) {
        this.reservesById = reservesById;
    }
}
