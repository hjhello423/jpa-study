package com.hongjun423.jpastudy.practice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent {

    @EmbeddedId
    private ParentId id1;

    private String name;
}
