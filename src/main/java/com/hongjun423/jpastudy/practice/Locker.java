package com.hongjun423.jpastudy.practice;

import javax.persistence.*;

public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "locker")
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
