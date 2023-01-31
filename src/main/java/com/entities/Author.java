package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Author", schema = "dbo", catalog = "La_biblioteca")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "firstName")
    private int firstName;
    @Basic
    @Column(name = "lastName")
    private int lastName;
    @ManyToOne
    @JoinColumn(name = "firstName", referencedColumnName = "ID", nullable = false)
    private FirstName firstNameByFirstName;
    @ManyToOne
    @JoinColumn(name = "lastName", referencedColumnName = "ID", nullable = false)
    private LastName lastNameByLastName;
    @OneToMany(mappedBy = "authorByAuthorId")
    private Collection<BookVsAuthor> bookVsAuthorsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstName() {
        return firstName;
    }

    public void setFirstName(int firstName) {
        this.firstName = firstName;
    }

    public int getLastName() {
        return lastName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author that = (Author) o;

        if (id != that.id) return false;
        if (firstName != that.firstName) return false;
        if (lastName != that.lastName) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName;
        result = 31 * result + lastName;
        return result;
    }

    public FirstName getFirstNameByFirstName() {
        return firstNameByFirstName;
    }

    public void setFirstNameByFirstName(FirstName firstNameByFirstName) {
        this.firstNameByFirstName = firstNameByFirstName;
    }

    public LastName getLastNameByLastName() {
        return lastNameByLastName;
    }

    public void setLastNameByLastName(LastName lastNameByLastName) {
        this.lastNameByLastName = lastNameByLastName;
    }

    public Collection<BookVsAuthor> getBookVsAuthorsById() {
        return bookVsAuthorsById;
    }

    public void setBookVsAuthorsById(Collection<BookVsAuthor> bookVsAuthorsById) {
        this.bookVsAuthorsById = bookVsAuthorsById;
    }
}
