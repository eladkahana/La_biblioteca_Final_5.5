package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Audience", schema = "dbo", catalog = "La_biblioteca")
public class Audience {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "teamName")
    private String teamName;
    @Basic
    @Column(name = "startAge")
    private int startAge;
    @Basic
    @Column(name = "EndAge")
    private int endAge;
    @OneToMany(mappedBy = "audienceByGroupId")
    private Collection<AudienceVsBook> audienceVsBooksById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getStartAge() {
        return startAge;
    }

    public void setStartAge(int startAge) {
        this.startAge = startAge;
    }

    public int getEndAge() {
        return endAge;
    }

    public void setEndAge(int endAge) {
        this.endAge = endAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Audience that = (Audience) o;

        if (id != that.id) return false;
        if (startAge != that.startAge) return false;
        if (endAge != that.endAge) return false;
        if (teamName != null ? !teamName.equals(that.teamName) : that.teamName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + startAge;
        result = 31 * result + endAge;
        return result;
    }

    public Collection<AudienceVsBook> getAudienceVsBooksById() {
        return audienceVsBooksById;
    }

    public void setAudienceVsBooksById(Collection<AudienceVsBook> audienceVsBooksById) {
        this.audienceVsBooksById = audienceVsBooksById;
    }
}
