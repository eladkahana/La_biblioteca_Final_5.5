package com.DTOs;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class ResponesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String answer;

    private Date sendDate;

    private Integer requestID;

}
