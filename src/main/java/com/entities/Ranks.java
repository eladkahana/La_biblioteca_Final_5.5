package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ranks", schema = "dbo", catalog = "La_biblioteca")
public class Ranks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "BookID")
    private int bookId;
    @Basic
    @Column(name = "ReaderID")
    private int readerId;
    @Basic
    @Column(name = "Rank")
    private int rank;
    @ManyToOne
    @JoinColumn(name = "BookID", referencedColumnName = "ID", nullable = false)
    private Book bookByBookId;
    @ManyToOne
    @JoinColumn(name = "ReaderID", referencedColumnName = "ID", nullable = false)
    private Readers readersByReaderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ranks that = (Ranks) o;

        if (id != that.id) return false;
        if (bookId != that.bookId) return false;
        if (readerId != that.readerId) return false;
        if (rank != that.rank) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookId;
        result = 31 * result + readerId;
        result = 31 * result + rank;
        return result;
    }

    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public Readers getReadersByReaderId() {
        return readersByReaderId;
    }

    public void setReadersByReaderId(Readers readersByReaderId) {
        this.readersByReaderId = readersByReaderId;
    }
}
