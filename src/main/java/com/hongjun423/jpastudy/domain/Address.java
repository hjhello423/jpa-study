package com.hongjun423.jpastudy.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * vo의 경우 setter 는 생략 한다
 * jpa기본 스펙때문에 기본 생성자를 생성해야 한다
 * 이때 사용에 제한을 두기 위해 protected로 지정한다.
 */

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
