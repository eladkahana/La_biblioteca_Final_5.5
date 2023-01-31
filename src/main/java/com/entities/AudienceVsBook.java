package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "AudienceVSBook", schema = "dbo", catalog = "La_biblioteca")
public class AudienceVsBook {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "groupID")
    private int groupId;
    @Basic
    @Column(name = "BookID")
    private int bookId;
    @ManyToOne
    @JoinColumn(name = "groupID", referencedColumnName = "ID", nullable = false)
    private Audience audienceByGroupId;
    @ManyToOne
    @JoinColumn(name = "BookID", referencedColumnName = "ID", nullable = false)
    private Book bookByBookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AudienceVsBook that = (AudienceVsBook) o;

        if (id != that.id) return false;
        if (groupId != that.groupId) return false;
        if (bookId != that.bookId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + groupId;
        result = 31 * result + bookId;
        return result;
    }

    public Audience getAudienceByGroupId() {
        return audienceByGroupId;
    }

    public void setAudienceByGroupId(Audience audienceByGroupId) {
        this.audienceByGroupId = audienceByGroupId;
    }

    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
