package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "LastName", schema = "dbo", catalog = "La_biblioteca")
public class LastName {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "LastName")
    private String lastName;
    @OneToMany(mappedBy = "lastNameByLastName")
    private Collection<Author> authorsById;
    @OneToMany(mappedBy = "lastNameByLastName")
    private Collection<Readers> readersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LastName that = (LastName) o;

        if (id != that.id) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
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
