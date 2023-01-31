package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "FirstName", schema = "dbo", catalog = "La_biblioteca")
public class FirstName {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "FirstName")
    private String firstName;
    @OneToMany(mappedBy = "firstNameByFirstName")
    private Collection<Author> authorsById;
    @OneToMany(mappedBy = "firstNameByFirstName")
    private Collection<Readers> readersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FirstName that = (FirstName) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    public Collection<Author> getAuthorsById() {
        return authorsById;
    }

    public void setAuthorsById(Collection<Author> authorsById) {
        this.authorsById = authorsById;
    }

    public Collection<Readers> getReadersById() {
        return readersById;
    }

    public void setReadersById(Collection<Readers> readersById) {
        this.readersById = readersById;
    }
}
