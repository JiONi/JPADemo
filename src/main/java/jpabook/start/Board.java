package jpabook.start;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@SequenceGenerator(         //시퀀스 생성기
        name = "BOARD_SEQ_GENERATOR",   //식별자 생성기 이름
        sequenceName = "BOARD_SEQ", // 데이터베이스에 등록되어 있는 시퀀스 이름
        initialValue =  1, allocationSize = 1   //처음 시작하는 수, 시퀀스 한 번 호출에 증가하는 수
)
/*@TableGenerator(
        name = "BOARD_SEQ_GENERATOR",   //식별자 생성기 이름
        table = "MY_SEQUENCES", //키생성 테이블명
        pkColumnValue = "BOARD_SEQ", allocationSize = 1  //시퀀스 컬럼명, 시퀀스 한 번 호출에 증가하는 수
)*/
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;

    /*@Id           IDENTITY 전략으로 기본 키 자동생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;*/

    /*@Id // SEQUENCE 전략으로 기본 키 자동생성
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "BOARD_SEQ_GENERATOR")*/
    private Long id2;

    /*@Id
    @GeneratedValue(strategy = GenerationType.TABLE,    //TABLE 전략으로 기본 키 자동생성
                    generator = "BOARD_SEQ_GENERATOR")
    private Long id3;*/

    public Long getId2(){
        return id2;
    }
}
