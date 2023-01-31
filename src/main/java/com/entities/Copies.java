package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Copies", schema = "dbo", catalog = "La_biblioteca")
public class Copies {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "originalID")
    private int originalId;
    @Basic
    @Column(name = "copyISBN")
    private String copyIsbn;
    @Basic
    @Column(name = "isExist")
    private boolean isExist;
    @ManyToOne
    @JoinColumn(name = "originalID", referencedColumnName = "ID", nullable = false)
    private Book bookByOriginalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOriginalId() {
        return originalId;
    }

    public void setOriginalId(int originalId) {
        this.originalId = originalId;
    }

    public String getCopyIsbn() {
        return copyIsbn;
    }

    public void setCopyIsbn(String copyIsbn) {
        this.copyIsbn = copyIsbn;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Copies that = (Copies) o;

        if (id != that.id) return false;
        if (originalId != that.originalId) return false;
        if (isExist != that.isExist) return false;
        if (copyIsbn != null ? !copyIsbn.equals(that.copyIsbn) : that.copyIsbn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + originalId;
        result = 31 * result + (copyIsbn != null ? copyIsbn.hashCode() : 0);
        result = 31 * result + (isExist ? 1 : 0);
        return result;
    }

    public Book getBookByOriginalId() {
        return bookByOriginalId;
    }

    public void setBookByOriginalId(Book bookByOriginalId) {
        this.bookByOriginalId = bookByOriginalId;
    }
}
