package com.DTOs;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class ReadersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String IDno;

    private String adress;

    private String phoneNo;

    private Integer firstName;

    private Integer lastName;

    private Date birthDate;

    private Date registrationDate;

    private Integer genderID;

    private String email;

}
