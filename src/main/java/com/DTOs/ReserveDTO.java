package com.DTOs;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class ReserveDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Date reserveDate;

    private Date dueDate;

    private Date returnDate;

    private Integer readerID;

    private Integer bookID;

    private Integer extensionID;

}
