package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "shelfmark", schema = "dbo", catalog = "La_biblioteca")
public class Shelfmark {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "mark")
    private String mark;
    @OneToMany(mappedBy = "shelfmarkByShelfmarkId")
    private Collection<Book> booksById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shelfmark that = (Shelfmark) o;

        if (id != that.id) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    public Collection<Book> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<Book> booksById) {
        this.booksById = booksById;
    }
}
