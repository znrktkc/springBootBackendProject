package com.znrktkc.SpringBootProject.entity;

import javax.persistence.*;

/**
 * this entity created for role table in mySQL db
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}