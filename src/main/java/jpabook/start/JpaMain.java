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

    public void testSave(EntityManager em){
        //팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        //회원1 저장
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1); //연관관계 설정 member1 -> team1
        em.persist(member1);

        //회원2 저장
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1); //연관관계 설정 member2 -> team1
        em.persist(member2);
    }

    //JPQL 조인 검색
    private static void queryLogicJoin(EntityManager em){
        String jpql = "select m from Member m join m.team t where t.name=:teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class).setParameter("teamName","팀1").getResultList();

        for(Member member : resultList) {
            System.out.println("[query] member.username="+member.getUsername());
        }
    }

    //연관관계를 수정하는 코드
    private static void updateRelation(EntityManager em){
        //새로운 팀2
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        //회원1에 새로운 팀2 설정
        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
    }

    //연관관계를 삭제하는 코드
    private static void deleteRelation(EntityManager em){
        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);  //연관관계 제거
    }

    //일대다 컬렉션 조회
    public void biDirection(EntityManager em){
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();   // (팀 -> 회원) 객체 그래프 탐색

        for(Member member : members){
            System.out.println("member.username = "+member.getUsername());
        }
    }

    public void testORM_양방향(EntityManager em){
        //팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member("member1", "회원1");

        //양방향 연관관계 설정
        member1.setTeam(team1);             //연관관계 설정 member1 -> team1
        team1.getMembers().add(member1);    //연관관계 설정 team1 -> member1
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");

        //양방향 연관관계 설정
        member2.setTeam(team1);             //연관관계 설정 member2 -> team1
        team1.getMembers().add(member2);    //연관관계 설정 team1 -> member2
        em.persist(member2);
    }
}
