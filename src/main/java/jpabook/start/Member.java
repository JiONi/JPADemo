package jpabook.start;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"})}) //유니크 제약조건 추
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY 전략으로 기본 키 자동생
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)   //회원 이름은 필수로 입력, 10자를 초과하면 안 됨(제약조건)
    private String username;

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

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

    //연관관계 설정
   public void setTeam(Team team){
        this.team = team;
    }

    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    public Member(String id, String username){
        this.id = id;
        this.username = username;
    }

    public Member(){

    }
}

