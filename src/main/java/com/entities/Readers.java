package com.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Readers", schema = "dbo", catalog = "La_biblioteca")
public class Readers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "IDno")
    private String iDno;
    @Basic
    @Column(name = "adress")
    private String adress;
    @Basic
    @Column(name = "phoneNo")
    private String phoneNo;
    @Basic
    @Column(name = "FirstName")
    private int firstName;
    @Basic
    @Column(name = "LastName")
    private int lastName;
    @Basic
    @Column(name = "birthDate")
    private Date birthDate;
    @Basic
    @Column(name = "registrationDate")
    private Date registrationDate;
    @Basic
    @Column(name = "genderID")
    private int genderId;
    @Basic
    @Column(name = "Email")
    private String email;
    @OneToMany(mappedBy = "readersByReaderId")
    private Collection<Ranks> ranksById;
    @ManyToOne
    @JoinColumn(name = "FirstName", referencedColumnName = "ID", nullable = false)
    private FirstName firstNameByFirstName;
    @ManyToOne
    @JoinColumn(name = "LastName", referencedColumnName = "ID", nullable = false)
    private LastName lastNameByLastName;
    @ManyToOne
    @JoinColumn(name = "genderID", referencedColumnName = "ID", nullable = false)
    private Gender genderByGenderId;
    @OneToMany(mappedBy = "readersByReaderId")
    private Collection<Requests> requestsById;
    @OneToMany(mappedBy = "readersByReaderId")
    private Collection<Reserve> reservesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getiDno() {
        return iDno;
    }

    public void setiDno(String iDno) {
        this.iDno = iDno;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Readers that = (Readers) o;

        if (id != that.id) return false;
        if (firstName != that.firstName) return false;
        if (lastName != that.lastName) return false;
        if (genderId != that.genderId) return false;
        if (iDno != null ? !iDno.equals(that.iDno) : that.iDno != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (iDno != null ? iDno.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + firstName;
        result = 31 * result + lastName;
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + genderId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<Ranks> getRanksById() {
        return ranksById;
    }

    public void setRanksById(Collection<Ranks> ranksById) {
        this.ranksById = ranksById;
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

    public Gender getGenderByGenderId() {
        return genderByGenderId;
    }

    public void setGenderByGenderId(Gender genderByGenderId) {
        this.genderByGenderId = genderByGenderId;
    }

    public Collection<Requests> getRequestsById() {
        return requestsById;
    }

    public void setRequestsById(Collection<Requests> requestsById) {
        this.requestsById = requestsById;
    }

    public Collection<Reserve> getReservesById() {
        return reservesById;
    }

    public void setReservesById(Collection<Reserve> reservesById) {
        this.reservesById = reservesById;
    }
}
