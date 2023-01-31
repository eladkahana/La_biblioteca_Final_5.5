package com.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "Book", schema = "dbo", catalog = "La_biblioteca")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "ISBN")
    private String isbn;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "edition")
    private String edition;
    @Basic
    @Column(name = "shelfmarkID")
    private int shelfmarkId;
    @Basic
    @Column(name = "numberOfPages")
    private int numberOfPages;
    @Basic
    @Column(name = "publishYear")
    private int publishYear;
    @Basic
    @Column(name = "languageID")
    private int languageId;
    @Basic
    @Column(name = "publisherID")
    private int publisherId;
    @Basic
    @Column(name = "coverImage")
    private byte[] coverImage;
    @Basic
    @Column(name = "insertDate")
    private Date insertDate;
    @Basic
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<AudienceVsBook> audienceVsBooksById;
    @ManyToOne
    @JoinColumn(name = "shelfmarkID", referencedColumnName = "ID", nullable = false)
    private Shelfmark shelfmarkByShelfmarkId;
    @ManyToOne
    @JoinColumn(name = "publisherID", referencedColumnName = "ID", nullable = false)
    private Publisher publisherByPublisherId;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<BookVsAuthor> bookVsAuthorsById;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<BookVsCategory> bookVsCategoriesById;
    @OneToMany(mappedBy = "bookByOriginalId")
    private Collection<Copies> copiesById;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<Ranks> ranksById;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<SeriesVsBook> seriesVsBooksById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getShelfmarkId() {
        return shelfmarkId;
    }

    public void setShelfmarkId(int shelfmarkId) {
        this.shelfmarkId = shelfmarkId;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public byte[] getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(byte[] coverImage) {
        this.coverImage = coverImage;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book that = (Book) o;

        if (id != that.id) return false;
        if (shelfmarkId != that.shelfmarkId) return false;
        if (numberOfPages != that.numberOfPages) return false;
        if (publishYear != that.publishYear) return false;
        if (languageId != that.languageId) return false;
        if (publisherId != that.publisherId) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (edition != null ? !edition.equals(that.edition) : that.edition != null) return false;
        if (!Arrays.equals(coverImage, that.coverImage)) return false;
        if (insertDate != null ? !insertDate.equals(that.insertDate) : that.insertDate != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (edition != null ? edition.hashCode() : 0);
        result = 31 * result + shelfmarkId;
        result = 31 * result + numberOfPages;
        result = 31 * result + publishYear;
        result = 31 * result + languageId;
        result = 31 * result + publisherId;
        result = 31 * result + Arrays.hashCode(coverImage);
        result = 31 * result + (insertDate != null ? insertDate.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    public Collection<AudienceVsBook> getAudienceVsBooksById() {
        return audienceVsBooksById;
    }

    public void setAudienceVsBooksById(Collection<AudienceVsBook> audienceVsBooksById) {
        this.audienceVsBooksById = audienceVsBooksById;
    }

    public Shelfmark getShelfmarkByShelfmarkId() {
        return shelfmarkByShelfmarkId;
    }

    public void setShelfmarkByShelfmarkId(Shelfmark shelfmarkByShelfmarkId) {
        this.shelfmarkByShelfmarkId = shelfmarkByShelfmarkId;
    }

    public Publisher getPublisherByPublisherId() {
        return publisherByPublisherId;
    }

    public void setPublisherByPublisherId(Publisher publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }

    public Collection<BookVsAuthor> getBookVsAuthorsById() {
        return bookVsAuthorsById;
    }

    public void setBookVsAuthorsById(Collection<BookVsAuthor> bookVsAuthorsById) {
        this.bookVsAuthorsById = bookVsAuthorsById;
    }

    public Collection<BookVsCategory> getBookVsCategoriesById() {
        return bookVsCategoriesById;
    }

    public void setBookVsCategoriesById(Collection<BookVsCategory> bookVsCategoriesById) {
        this.bookVsCategoriesById = bookVsCategoriesById;
    }

    public Collection<Copies> getCopiesById() {
        return copiesById;
    }

    public void setCopiesById(Collection<Copies> copiesById) {
        this.copiesById = copiesById;
    }

    public Collection<Ranks> getRanksById() {
        return ranksById;
    }

    public void setRanksById(Collection<Ranks> ranksById) {
        this.ranksById = ranksById;
    }

    public Collection<SeriesVsBook> getSeriesVsBooksById() {
        return seriesVsBooksById;
    }

    public void setSeriesVsBooksById(Collection<SeriesVsBook> seriesVsBooksById) {
        this.seriesVsBooksById = seriesVsBooksById;
    }
}
