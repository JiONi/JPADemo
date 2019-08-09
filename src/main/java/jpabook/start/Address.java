package jpabook.start;

import javax.persistence.*;

@Embeddable
public class Address {
    @Column(name="city")
    private String city;    //매핑할 컬럼 정의 가능

    private String street;

    private String zipcode;
}
