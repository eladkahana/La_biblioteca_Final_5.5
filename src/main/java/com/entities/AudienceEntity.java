package com.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "Audience", schema = "dbo", catalog = "La_biblioteca")
public class AudienceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "teamName", nullable = false, length = 20)
    private String teamName;
    @Basic
    @Column(name = "startAge", nullable = false)
    private int startAge;
    @Basic
    @Column(name = "EndAge", nullable = false)
    private int endAge;


}
