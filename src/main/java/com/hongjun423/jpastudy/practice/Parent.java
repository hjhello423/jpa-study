package com.hongjun423.jpastudy.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent {

    @Id
    @Column(name = "parent_id")
    private String id1;

    private String name;
}
