package jpabook.start;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String username;

    //매핑 정보가 없는 필드
    private Integer age;

    @Enumerated(EnumType.STRING) // java enum을 사용해서 회원 타입 구분. enum을 사용하기 위해 @Enumerated 사용
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)   // 자바의 날짜 타입은 @Temporal을 사용해서 매핑한다.
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob    // @Lob 어노테이션을 사용하면 CLOB, BLOB 타입을 매핑할 수 있다.
    private String description;


    //Getter, Setter
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age = age;
    }
}

