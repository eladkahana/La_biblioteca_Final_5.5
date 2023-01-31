package com.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Categories", schema = "dbo", catalog = "La_biblioteca")
public class Categories {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "CategoryName")
    private String categoryName;
    @OneToMany(mappedBy = "categoriesByCategoryId")
    private Collection<BookVsCategory> bookVsCategoriesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        if (id != that.id) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    public Collection<BookVsCategory> getBookVsCategoriesById() {
        return bookVsCategoriesById;
    }

    public void setBookVsCategoriesById(Collection<BookVsCategory> bookVsCategoriesById) {
        this.bookVsCategoriesById = bookVsCategoriesById;
    }
}
