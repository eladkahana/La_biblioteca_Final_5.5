package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Publisher", schema = "dbo", catalog = "La_biblioteca")
public class Publisher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "publisherName")
    private String publisherName;
    @OneToMany(mappedBy = "publisherByPublisherId")
    private Collection<Book> booksById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher that = (Publisher) o;

        if (id != that.id) return false;
        if (publisherName != null ? !publisherName.equals(that.publisherName) : that.publisherName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (publisherName != null ? publisherName.hashCode() : 0);
        return result;
    }

    public Collection<Book> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<Book> booksById) {
        this.booksById = booksById;
    }
}
