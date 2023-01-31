package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SeriesVSBook", schema = "dbo", catalog = "La_biblioteca")
public class SeriesVsBook {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "BookSeriesID")
    private int bookSeriesId;
    @Basic
    @Column(name = "BookID")
    private int bookId;
    @Basic
    @Column(name = "BookIndexInSeries")
    private int bookIndexInSeries;
    @ManyToOne
    @JoinColumn(name = "BookSeriesID", referencedColumnName = "ID", nullable = false)
    private SeriesBook seriesBookByBookSeriesId;
    @ManyToOne
    @JoinColumn(name = "BookID", referencedColumnName = "ID", nullable = false)
    private Book bookByBookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookSeriesId() {
        return bookSeriesId;
    }

    public void setBookSeriesId(int bookSeriesId) {
        this.bookSeriesId = bookSeriesId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookIndexInSeries() {
        return bookIndexInSeries;
    }

    public void setBookIndexInSeries(int bookIndexInSeries) {
        this.bookIndexInSeries = bookIndexInSeries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeriesVsBook that = (SeriesVsBook) o;

        if (id != that.id) return false;
        if (bookSeriesId != that.bookSeriesId) return false;
        if (bookId != that.bookId) return false;
        if (bookIndexInSeries != that.bookIndexInSeries) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookSeriesId;
        result = 31 * result + bookId;
        result = 31 * result + bookIndexInSeries;
        return result;
    }

    public SeriesBook getSeriesBookByBookSeriesId() {
        return seriesBookByBookSeriesId;
    }

    public void setSeriesBookByBookSeriesId(SeriesBook seriesBookByBookSeriesId) {
        this.seriesBookByBookSeriesId = seriesBookByBookSeriesId;
    }

    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
