package com.DTOs;


import lombok.Data;

import java.io.Serializable;

@Data
public class SeriesBookDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String seriesTitle;

}
