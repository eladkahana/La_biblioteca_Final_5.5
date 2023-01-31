package com.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "BookVSCategory", schema = "dbo", catalog = "La_biblioteca")
public class BookVsCategory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "CategoryID")
    private int categoryId;
    @Basic
    @Column(name = "BookID")
    private int bookId;
    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID", nullable = false)
    private Categories categoriesByCategoryId;
    @ManyToOne
    @JoinColumn(name = "BookID", referencedColumnName = "ID", nullable = false)
    private Book bookByBookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

        BookVsCategory that = (BookVsCategory) o;

        if (id != that.id) return false;
        if (categoryId != that.categoryId) return false;
        if (bookId != that.bookId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + categoryId;
        result = 31 * result + bookId;
        return result;
    }

    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
