package com.DTOs;


import lombok.Data;

import java.io.Serializable;

@Data
public class RanksDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer bookID;

    private Integer readerID;

    private Integer rank;

}
