package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Gender", schema = "dbo", catalog = "La_biblioteca")
public class Gender {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "gender")
    private String gender;
    @OneToMany(mappedBy = "genderByGenderId")
    private Collection<Readers> readersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender that = (Gender) o;

        if (id != that.id) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    public Collection<Readers> getReadersById() {
        return readersById;
    }

    public void setReadersById(Collection<Readers> readersById) {
        this.readersById = readersById;
    }
}
