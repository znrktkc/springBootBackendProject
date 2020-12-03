package com.znrktkc.SpringBootProject.entity;

import javax.persistence.*;
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}