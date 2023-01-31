package com.DTOs;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String isbn;

    private String title;

    private String edition;

    private Integer shelfmarkID;

    private Integer numberOfPages;

    private Integer publishYear;

    private Integer languageID;

    private Integer publisherID;

    private String coverImage;

    private Date insertDate;

    private String note;

}
