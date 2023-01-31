package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "SeriesBook", schema = "dbo", catalog = "La_biblioteca")
public class SeriesBook {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "seriesTitle")
    private String seriesTitle;
    @OneToMany(mappedBy = "seriesBookByBookSeriesId")
    private Collection<SeriesVsBook> seriesVsBooksById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeriesBook that = (SeriesBook) o;

        if (id != that.id) return false;
        if (seriesTitle != null ? !seriesTitle.equals(that.seriesTitle) : that.seriesTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (seriesTitle != null ? seriesTitle.hashCode() : 0);
        return result;
    }

    public Collection<SeriesVsBook> getSeriesVsBooksById() {
        return seriesVsBooksById;
    }

    public void setSeriesVsBooksById(Collection<SeriesVsBook> seriesVsBooksById) {
        this.seriesVsBooksById = seriesVsBooksById;
    }
}
