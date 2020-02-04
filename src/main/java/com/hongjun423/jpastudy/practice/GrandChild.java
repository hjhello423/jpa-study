package com.hongjun423.jpastudy.practice;

import javax.persistence.*;

@Entity
public class GrandChild {

    @EmbeddedId
    private GrandChildId id;

    @MapsId("childId") //GrandChildId.childId 매핑
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id", referencedColumnName = "parent_id"),
            @JoinColumn(name = "child_id", referencedColumnName = "child_id")
    })
    private Child child;

    private String name;
}
