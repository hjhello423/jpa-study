package com.hongjun423.jpastudy.practice;

import javax.persistence.*;

@Entity
public class Child {

    @EmbeddedId
    private ChildId id;

    @MapsId("parentId") //ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    private String name;
}
