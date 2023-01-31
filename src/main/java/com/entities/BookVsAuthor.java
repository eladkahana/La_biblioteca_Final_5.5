package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "BookVSAuthor", schema = "dbo", catalog = "La_biblioteca")
public class BookVsAuthor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "bookID")
    private int bookId;
    @Basic
    @Column(name = "AuthorID")
    private int authorId;
    @ManyToOne
    @JoinColumn(name = "bookID", referencedColumnName = "ID", nullable = false)
    private Book bookByBookId;
    @ManyToOne
    @JoinColumn(name = "AuthorID", referencedColumnName = "ID", nullable = false)
    private Author authorByAuthorId;

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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookVsAuthor that = (BookVsAuthor) o;

        if (id != that.id) return false;
        if (bookId != that.bookId) return false;
        if (authorId != that.authorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookId;
        result = 31 * result + authorId;
        return result;
    }

    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
