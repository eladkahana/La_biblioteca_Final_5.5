package com.DTOs;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class RequestsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Date sendDate;

    private Integer readerID;

    private String contactContent;

    private Boolean isChecked;

}
