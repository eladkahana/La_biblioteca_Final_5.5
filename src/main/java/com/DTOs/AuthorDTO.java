package com.DTOs;


import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer firstName;

    private Integer lastName;

}
