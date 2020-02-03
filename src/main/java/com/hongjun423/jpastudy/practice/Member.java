package com.hongjun423.jpastudy.practice;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userName;

    @OneToOne(mappedBy = "member")
    private Locker locker;
}
