package jpabook.start;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){

        //[엔티티 매니저 팩토리] - 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        //[엔티티 매니저] - 생성
        EntityManager em = emf.createEntityManager();
        //[트랜잭션] - 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();         //[트랜잭션] - 시작
            logic(em);          //비즈니스 로직 실행
            tx.commit();        //[트랜잭션] - 커밋
        } catch (Exception e){
            tx.rollback();      //[트랜잭션] - 롤백
        } finally {
            em.close();         //[엔티티 매니저] - 종료
        }
        emf.close();            //[엔티티 매니저 팩토리] - 종료
    }

    private static void logic(EntityManager em) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지원");
        member.setAge(2);

        //등록
        em.persist(member);

        //수정
        member.setAge(26);

        //한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        em.remove(member);
    }

    private static void logic2(EntityManager em) {
        Board board = new Board();
        em.persist(board);
        System.out.println("Board.id = " + board.getId2()); // IDENTITY 전략으로 키 생성 시 persist로 데이터 생성 후 id 데이터 조회 가능
    }
}
